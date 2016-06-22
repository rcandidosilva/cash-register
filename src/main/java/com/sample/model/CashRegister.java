package com.sample.model;

import com.sample.exception.InvalidAmountException;
import com.sample.exception.InvalidArgumentException;
import com.sample.exception.NoChangeException;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Represents the cash register model
 *
 * @author rcandidosilva@gmail.com
 */
public class CashRegister implements Serializable {

    private List<CashNote> notes = Arrays.asList(
            new CashNote(20),
            new CashNote(10),
            new CashNote(5),
            new CashNote(2),
            new CashNote(1));

    private static CashRegister instance = new CashRegister();

    /**
     * Returns the singleton instance from the cash register
     * @return
     */
    public static CashRegister getInstance() {
        return instance;
    }

    private CashRegister() {
        super();
    }

    /**
     * Get the list of cash notes from the cash register
     *
     * @return
     */
    public List<CashNote> getNotes() {
        return notes;
    }

    /**
     * Returns the amount total of cash existing in the cash register balance
     *
     * @return
     */
    public int getTotal() {
        return notes.stream().mapToInt(CashNote::getTotalInSLot).sum();
    }

    /**
     * Add new cash notes sequence to the cas register balance
     *
     * @param args
     * @throws InvalidArgumentException
     */
    public void add(int... args) throws InvalidArgumentException {
        if (args.length != notes.size()) throw new InvalidArgumentException();
        int index = 0;
        for (CashNote m : notes) {
            m.add(args[index++]);
        }
    }

    public void add(CashRegister cashToRemove) {
        for (int i = 0; i < notes.size(); i++) {
            notes.get(i).add(cashToRemove.getNotes().get(i).getQuantity());
        }
    }

    /**
     * Remove the cash notes sequence from the cash register balance
     *
     * @param args
     * @throws InvalidArgumentException
     * @throws InvalidAmountException
     */
    public void remove(int... args) throws InvalidArgumentException, InvalidAmountException {
        if (args.length != notes.size()) throw new InvalidArgumentException();
        if (!validate(args)) throw new InvalidAmountException();
        for (int i = 0; i < notes.size(); i++) {
            notes.get(i).remove(args[i++]);
        }
    }

    /**
     * Validate the existing amounts if it has balance to process the debit on it
     *
     * @param args
     * @return
     */
    private boolean validate(int... args) {
        for (int i = 0; i < args.length; i++) {
            if (!notes.get(i).isValidRemove(args[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Process the money change from the current cash register balance
     *
     * @param moneyChange
     * @throws InvalidAmountException
     * @throws NoChangeException
     */
    public CashRegister processChange(int moneyChange) throws InvalidAmountException, NoChangeException {
        if (moneyChange > getTotal()) throw new InvalidAmountException();
        CashRegister cashback = new CashRegister();
        int totalToRemove = moneyChange;

        for (int i = 0; i < notes.size(); i++) {
            totalToRemove = removeFromSlot(notes.get(i), totalToRemove, cashback.getNotes().get(i));
        }

        if (totalToRemove != 0) {
            this.add(cashback);
            throw new NoChangeException();
        }

        return cashback;
    }

    /**
     *
     * @param moneySlot
     * @param totalToRemove
     * @param moneyRemovedSlot
     * @return
     */
    private int removeFromSlot(CashNote moneySlot, int totalToRemove, CashNote moneyRemovedSlot) {
        if (totalToRemove == 0) return totalToRemove;

        if ((totalToRemove - moneySlot.getAmount()) < 0 || (moneySlot.getTotalInSLot() - moneySlot.getAmount()) < 0)
            return totalToRemove;
        totalToRemove = totalToRemove - moneySlot.getAmount();
        moneySlot.remove(1);
        moneyRemovedSlot.add(1);

        totalToRemove = removeFromSlot(moneySlot, totalToRemove, moneyRemovedSlot);

        return totalToRemove;
    }

}
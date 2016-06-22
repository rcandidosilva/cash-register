package com.sample.test;

import com.sample.exception.InvalidAmountException;
import com.sample.exception.InvalidArgumentException;
import com.sample.model.CashNote;
import com.sample.model.CashRegister;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Unit test class for the cash register model
 */
public class CashRegisterTest {

    CashRegister cash = CashRegister.getInstance();

    @Test
    public void testCashRegisterReset() {
        cash.reset();
        List<CashNote> notes = cash.getNotes();
        Assert.assertNotNull(notes);
        Assert.assertEquals(5, notes.size());
    }

    @Test
    public void testAddCashNotes() throws Exception {
        cash.reset();
        cash.add(1, 2, 3, 4, 5);
        Assert.assertEquals(68, cash.getTotal());
    }

    @Test(expected = InvalidArgumentException.class)
    public void testAddCashNotesWithInvalidArguments() throws Exception {
        cash.reset();
        cash.add();
        Assert.fail("It should not process this line.");
    }

    @Test
    public void testRemoveCashNotes() throws Exception {
        cash.reset();
        cash.add(1, 2, 3, 4, 5);
        cash.remove(1, 2, 3, 4, 0);
        Assert.assertEquals(5, cash.getTotal());
    }

    @Test(expected = InvalidArgumentException.class)
    public void testRemoveCashNotesWithInvalidArguments() throws Exception {
        cash.reset();
        cash.remove();
        Assert.fail("It should not process this line.");
    }

    @Test
    public void testProcessChange() throws Exception {
        cash.reset();
        cash.add(1, 2, 3, 4, 5);
        CashRegister result = cash.processChange(8);
        Assert.assertEquals(8, result.getTotal());
        Assert.assertEquals(60, cash.getTotal());
    }

    @Test(expected = InvalidAmountException.class)
    public void testProcessChangeInvalidAmoung() throws Exception {
        cash.reset();
        cash.add(1, 2, 3, 4, 5);
        cash.processChange(69);
        Assert.fail("It should not process this line.");
    }

}

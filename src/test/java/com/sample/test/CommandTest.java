package com.sample.test;

import com.sample.exception.InvalidAmountException;
import com.sample.exception.InvalidInputException;
import com.sample.model.CashRegister;
import org.junit.Assert;
import org.junit.Test;

import static com.sample.command.CommandFactory.createCommand;
import static com.sample.command.CommandType.*;

/**
 * Unit test class for the application commands
 */
public class CommandTest {

    CashRegister cash = CashRegister.getInstance();

    @Test
    public void testCashRegisterResetState() throws Exception {
        cash.reset();
        Assert.assertEquals("$0 0 0 0 0 0",
                createCommand(SHOW).execute(cash));
    }

    @Test
    public void testPutInitialState() throws Exception {
        cash.reset();
        Assert.assertEquals("$68 1 2 3 4 5",
                createCommand(PUT).execute(cash, "1", "2", "3", "4", "5"));
    }

    @Test(expected = InvalidInputException.class)
    public void testPutWithInvalidInput() throws Exception {
        cash.reset();
        Assert.assertEquals("$68 1 2 3 4 5",
                createCommand(PUT).execute(cash, "X", "2", "3", "4", "5"));
    }

    @Test
    public void testPutAddingMoreCash() throws Exception {
        cash.reset();
        createCommand(PUT).execute(cash, "1", "2", "3", "4", "5");
        Assert.assertEquals("$128 2 4 6 4 10",
                createCommand(PUT).execute(cash, "1", "2", "3", "0", "5"));
    }

    @Test
    public void testTakeValidCashFlow() throws Exception {
        cash.reset();
        createCommand(PUT).execute(cash, "2", "4", "6", "4", "10");
        Assert.assertEquals("$48 1 0 3 4 5",
                createCommand(TAKE).execute(cash, "1", "4", "3", "0", "5"));
    }

    @Test(expected = InvalidAmountException.class)
    public void testTakeWithInvalidAmount() throws Exception {
        cash.reset();
        createCommand(PUT).execute(cash, "2", "4", "6", "4", "10");
        Assert.assertEquals("$88 1 4 3 4 5",
                createCommand(TAKE).execute(cash, "3", "4", "3", "0", "5"));
        Assert.fail("It should not process this line.");
    }

    @Test(expected = InvalidInputException.class)
    public void testTakeWithInvalidInput() throws Exception {
        cash.reset();
        createCommand(PUT).execute(cash, "2", "4", "6", "4", "10");
        Assert.assertEquals("$88 1 4 3 4 5",
                createCommand(TAKE).execute(cash, "X", "4", "3", "0", "5"));
        Assert.fail("It should not process this line.");
    }

    @Test
    public void testProcessChangeSuccessful() throws Exception {
        cash.reset();
        createCommand(PUT).execute(cash, "1", "0", "3", "4", "5");
        CashRegister result = cash.processChange(8);
        Assert.assertEquals("$8 0 0 1 1 1", createCommand(SHOW).execute(result));
    }

    @Test(expected = InvalidAmountException.class)
    public void testProcessChangeWithInvalidAmount() throws Exception {
        cash.reset();
        createCommand(PUT).execute(cash, "1", "0", "3", "4", "5");
        cash.processChange(97);
        Assert.fail("It should not process this line.");
    }


}

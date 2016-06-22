package com.sample.test;

import com.sample.model.CashNote;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test class for the cash note model
 */
public class CashNoteTest {

    @Test
    public void testAddTotalAmount() {
        CashNote note = new CashNote(10);
        Assert.assertEquals(100, note.add(10));
    }

    @Test
    public void testAddAndRemoveQuantityWithBalance() {
        CashNote note = new CashNote(10);
        note.add(10);
        note.remove(5);
        Assert.assertEquals(5,note.getQuantity());
    }

    @Test
    public void testAddAndRemoveQuantityWithoutBalance() {
        CashNote note = new CashNote(10);
        note.add(2);
        note.remove(5);
        Assert.assertEquals(0,note.getQuantity());
    }

    @Test
    public void testHasCashNoteQuantity() {
        CashNote note = new CashNote(10);
        note.add(2);
        Assert.assertTrue(note.hasQuantity(2));
    }

}

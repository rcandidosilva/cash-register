package com.sample.model;

import java.io.Serializable;

/**
 * Represents the cash note model
 */
public class CashNote implements Serializable {

    private int amount;
    private int quantity = 0;

    public CashNote(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return amount * quantity;
    }

    public int add(int quantity) {
        this.quantity = this.quantity + quantity;
        return getTotal();
    }

    public void remove(int quantity) {
        this.quantity = this.quantity - quantity;
        if (this.quantity < 0 ) this.quantity = 0;
    }

    public boolean hasQuantity(int quantity) {
        return this.quantity >= quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CashNote)) return false;

        CashNote cashNote = (CashNote) o;

        if (amount != cashNote.amount) return false;
        return quantity == cashNote.quantity;

    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "CashNote{" +
                "amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }

}
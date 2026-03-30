/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;
public abstract class Payment {
    protected float amount;

    public Payment(float amount) {
        this.amount = amount;
    }

    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    public abstract boolean authorized();
}

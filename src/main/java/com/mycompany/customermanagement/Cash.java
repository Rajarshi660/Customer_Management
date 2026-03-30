/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;

public class Cash extends Payment {
    private float cashTendered;

    public Cash(float amount, float cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    public float getCashTendered() { return cashTendered; }

    public float getChange() { return cashTendered - amount; }

    @Override
    public boolean authorized() {
        return cashTendered >= amount;
    }
}

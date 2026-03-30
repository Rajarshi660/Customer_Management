




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chakr
 */
package com.mycompany.customermanagement;

public class Item {
    private double shippingWeight;
    private String description;
    private double pricePerUnit;
    private double taxRate;
    private int    stockQuantity;

    public Item(String description, double pricePerUnit,
                double shippingWeight, double taxRate, int stockQuantity) {
        this.description    = description;
        this.pricePerUnit   = pricePerUnit;
        this.shippingWeight = shippingWeight;
        this.taxRate        = taxRate;
        this.stockQuantity  = stockQuantity;
    }

    public double getShippingWeight() { return shippingWeight; }
    public String getDescription()    { return description; }

    public double getPriceForQuantity(int qty) {
        return pricePerUnit * qty;
    }

    public double getTax()  { return taxRate; }

    public boolean inStock() { return stockQuantity > 0; }

    public int getStockQuantity()         { return stockQuantity; }
    public void setStockQuantity(int qty) { this.stockQuantity = qty; }
}

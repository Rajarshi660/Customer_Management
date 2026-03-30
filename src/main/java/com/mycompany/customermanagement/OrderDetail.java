/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;

public class OrderDetail {
    private int quality;
    private String taxStatus;
    private Item item;

    public OrderDetail(int quality, String taxStatus, Item item) {
        this.quality   = quality;
        this.taxStatus = taxStatus;
        this.item      = item;
    }

    public int    getQuality()   { return quality; }
    public String getTaxStatus() { return taxStatus; }
    public Item   getItem()      { return item; }

    public double calcSubTotal() {
        return item.getPriceForQuantity(quality);
    }

    public double calcWeight() {
        return item.getShippingWeight() * quality;
    }

    public double calcTax() {
        if (taxStatus.equalsIgnoreCase("taxable")) {
            return calcSubTotal() * item.getTax();
        }
        return 0.0;
    }
}
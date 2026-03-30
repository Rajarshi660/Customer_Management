/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private String status;
    private List<OrderDetail> lineItems;
    private List<Payment> payments;

    public Order(Date date, String status) {
        this.date = date;
        this.status = status;
        this.lineItems = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public Date getDate()     { return date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void addLineItem(OrderDetail detail) { lineItems.add(detail); }
    public void addPayment(Payment payment)     { payments.add(payment); }
    public List<OrderDetail> getLineItems()     { return lineItems; }
    public List<Payment> getPayments()          { return payments; }

    public double calcSubTotal() {
        double subTotal = 0;
        for (OrderDetail d : lineItems) subTotal += d.calcSubTotal();
        return subTotal;
    }

    public double calcTax() {
        double tax = 0;
        for (OrderDetail d : lineItems) tax += d.calcTax();
        return tax;
    }

    public double calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public double calcTotalWeight() {
        double weight = 0;
        for (OrderDetail d : lineItems) weight += d.calcWeight();
        return weight;
    }
}

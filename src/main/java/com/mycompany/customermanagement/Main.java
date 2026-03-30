/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



/**
 *
 * @author chakr
 */
package com.mycompany.customermanagement;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Create items
        Item laptop = new Item("Laptop", 75000.0, 2.5, 0.18, 10);
        Item mouse  = new Item("Mouse",    500.0, 0.2, 0.18, 50);

        // Create order details
        OrderDetail od1 = new OrderDetail(1, "taxable", laptop);
        OrderDetail od2 = new OrderDetail(2, "taxable", mouse);

        // Create order
        Order order = new Order(new Date(), "PENDING");
        order.addLineItem(od1);
        order.addLineItem(od2);

        // Create customer and link order
        Customer customer = new Customer("Rajarshi Chakraborty", "Kolkata");
        customer.addOrder(order);

        // Payment via cash
        Cash cash = new Cash(76001.0f, 80000.0f);
        order.addPayment(cash);

        // Print output
        System.out.println("Customer : " + customer.getName());
        System.out.println("Address  : " + customer.getAddress());
        System.out.printf("Sub-Total: Rs. %.2f%n", order.calcSubTotal());
        System.out.printf("Tax      : Rs. %.2f%n", order.calcTax());
        System.out.printf("Total    : Rs. %.2f%n", order.calcTotal());
        System.out.printf("Weight   : %.2f kg%n",  order.calcTotalWeight());
        System.out.println("Payment Authorized: " + cash.authorized());
        System.out.printf("Change   : Rs. %.2f%n", cash.getChange());
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private List<Order> orders;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public String getName()        { return name; }
    public String getAddress()     { return address; }
    public List<Order> getOrders() { return orders; }

    public void setName(String name)       { this.name = name; }
    public void setAddress(String address) { this.address = address; }

    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "Customer{name='" + name + "', address='" + address + "'}";
    }
}
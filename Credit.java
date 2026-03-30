/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.customermanagement;

import java.util.Date;

public class Credit extends Payment {
    private String name;
    private String type;
    private Date   expDate;

    public Credit(float amount, String name, String type, Date expDate) {
        super(amount);
        this.name    = name;
        this.type    = type;
        this.expDate = expDate;
    }

    public String getName()    { return name; }
    public String getType()    { return type; }
    public Date   getExpDate() { return expDate; }

    @Override
    public boolean authorized() {
        Date today = new Date();
        return expDate != null && expDate.after(today);
    }
}

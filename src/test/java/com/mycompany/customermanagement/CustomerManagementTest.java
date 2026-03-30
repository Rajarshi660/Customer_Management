package com.mycompany.customermanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerManagementTest {

    private Item laptop;
    private Item mouse;
    private Customer customer;
    private Order order;

    @BeforeEach
    void setUp() {
        laptop = new Item("Laptop", 75000.0, 2.5, 0.18, 5);
        mouse = new Item("Mouse", 500.0, 0.2, 0.18, 20);
        customer = new Customer("Rajarshi Chakraborty", "Kolkata");
        order = new Order(new Date(), "PENDING");
    }

    // TC-01: Customer name and address stored correctly
    @Test
    void testCustomerDetails() {
        assertEquals("Rajarshi Chakraborty", customer.getName());
        assertEquals("Kolkata", customer.getAddress());
    }

    // TC-02: Item in-stock check
    @Test
    void testItemInStock() {
        assertTrue(laptop.inStock());
        Item outOfStock = new Item("Tablet", 30000, 0.5, 0.18, 0);
        assertFalse(outOfStock.inStock());
    }

    // TC-03: OrderDetail sub-total calculation
    @Test
    void testOrderDetailSubTotal() {
        OrderDetail od = new OrderDetail(2, "taxable", laptop);
        assertEquals(150000.0, od.calcSubTotal(), 0.01);
    }

    // TC-04: Order tax calculation
    @Test
    void testOrderTax() {
        order.addLineItem(new OrderDetail(1, "taxable", mouse));
        double expectedTax = 500.0 * 0.18;
        assertEquals(expectedTax, order.calcTax(), 0.01);
    }

    // TC-05: Order total weight
    @Test
    void testOrderTotalWeight() {
        order.addLineItem(new OrderDetail(2, "taxable", mouse));
        assertEquals(0.4, order.calcTotalWeight(), 0.01);
    }

    // TC-06: Cash payment authorised - sufficient cash
    @Test
    void testCashAuthorizedTrue() {
        Cash cash = new Cash(1000f, 1500f);
        assertTrue(cash.authorized());
    }

    // TC-07: Cash payment authorised - insufficient cash
    @Test
    void testCashAuthorizedFalse() {
        Cash cash = new Cash(2000f, 1500f);
        assertFalse(cash.authorized());
    }

    // TC-08: Credit card expired -> not authorised
    @Test
    void testCreditExpired() {
        Date past = new Date(System.currentTimeMillis() - 86400000L);
        Credit credit = new Credit(5000f, "Rajarshi", "VISA", past);
        assertFalse(credit.authorized());
    }

    // TC-09: Credit card valid -> authorised
    @Test
    void testCreditValid() {
        Date future = new Date(System.currentTimeMillis() + 86400000L * 365);
        Credit credit = new Credit(5000f, "Rajarshi", "VISA", future);
        assertTrue(credit.authorized());
    }

    // TC-10: Check authorisation with valid bank ID
    @Test
    void testCheckAuthorized() {
        Check chk = new Check(3000f, "Rajarshi", "SBI001");
        assertTrue(chk.authorized());
    }
}
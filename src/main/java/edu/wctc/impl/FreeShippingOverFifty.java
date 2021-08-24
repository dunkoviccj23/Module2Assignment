package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.ShippingPolicy;

public class FreeShippingOverFifty implements ShippingPolicy {
    @Override
    public double getShippingCost(Sale sale) {
        if (sale.getAmount() >= 50.00) {
            return 0.00;
        }

        return 5.00;
    }
}

package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.ShippingPolicy;

public class FreeShipping implements ShippingPolicy {
    @Override
    public double getShippingCost(Sale sale) {
        return 0.00;
    }
}

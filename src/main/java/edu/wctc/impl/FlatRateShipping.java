package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.ShippingPolicy;

public class FlatRateShipping implements ShippingPolicy {
    @Override
    public double getShippingCost(Sale sale) {
        if(sale.getCountry().equals("United States")) {
            return 29.95;
        } else if (sale.getCountry().equals("Japan")) {
            return 14.50;
        } else if (sale.getCountry().equals("Scotland")) {
            return 7.54;
        } else {
            return 11.79;
        }
    }
}

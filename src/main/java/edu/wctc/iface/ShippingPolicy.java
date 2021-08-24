package edu.wctc.iface;

import edu.wctc.Sale;

public interface ShippingPolicy {
    double getShippingCost(Sale sale);
}

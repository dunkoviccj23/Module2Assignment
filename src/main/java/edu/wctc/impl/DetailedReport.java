package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.SalesReport;

import java.util.List;

public class DetailedReport implements SalesReport {
    @Override
    public void generateReport(List<Sale> saleList) {
        System.out.println("SALES DETAIL REPORT");
        System.out.println("Customer\t\t Country\t\t Amount\t Tax\t Shipping");
        for(Sale sale : saleList) {
            System.out.println(sale.getCustomer() + "\t\t " + sale.getCountry() + "\t\t " + sale.getAmount() + "\t " + sale.getTax() + "\t " + sale.getShipping());
        }
    }
}

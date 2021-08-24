package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.SalesReport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SummaryReport implements SalesReport {
    @Override
    public void generateReport(List<Sale> saleList) {
        HashMap<String, CountrySummaryData> summary = new HashMap<>();
        System.out.println("SALES SUMMARY REPORT");
        System.out.println("Country\t\t Amount\t Tax\t Shipping");
        for(Sale sale : saleList) {
            if(!summary.containsKey(sale.getCountry())) {
                summary.put(sale.getCountry(), new CountrySummaryData(sale.getAmount(), sale.getTax(), sale.getShipping()));
            } else {
                CountrySummaryData summaryData = summary.get(sale.getCountry());
                summary.put(sale.getCountry(), new CountrySummaryData(summaryData.getAmount() + sale.getAmount(), summaryData.getTax() + sale.getTax(), sale.getShipping()));
            }
        }

        Iterator iterator = summary.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry element = (Map.Entry) iterator.next();
            String country = (String) element.getKey();
            CountrySummaryData summaryData = (CountrySummaryData) element.getValue();
            System.out.println(country + "\t\t " + summaryData.getAmount() + "\t " + summaryData.getTax() + "\t " + summaryData.getShipping());
        }
    }
}

class CountrySummaryData {
    private double amount;
    private double tax;
    private double shipping;

    public CountrySummaryData(double amount, double tax, double shipping) {
        this.amount = amount;
        this.tax = tax;
        this.shipping = shipping;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
}

package edu.wctc;

import edu.wctc.iface.SalesInput;
import edu.wctc.iface.SalesReport;
import edu.wctc.iface.ShippingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SalesReportGenerator {
    private final SalesInput salesInput;
    private final SalesReport salesReport;
    private final ShippingPolicy shippingPolicy;

    @Autowired
    public SalesReportGenerator(SalesInput salesInput, SalesReport salesReport, ShippingPolicy shippingPolicy) {
        this.salesInput = salesInput;
        this.salesReport = salesReport;
        this.shippingPolicy = shippingPolicy;
    }
    public void generate() {
        List<Sale> sales = new ArrayList<>();
        for(Sale sale : salesInput.getSales()) {
            sales.add(new Sale(sale.getCustomer(), sale.getCountry(), sale.getAmount(), sale.getTax(), shippingPolicy.getShippingCost(sale)));
        }

        salesReport.generateReport(sales);
    }
}

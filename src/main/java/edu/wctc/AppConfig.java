package edu.wctc;

import edu.wctc.iface.SalesInput;
import edu.wctc.iface.SalesReport;
import edu.wctc.iface.ShippingPolicy;
import edu.wctc.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.wctc")
public class AppConfig {
    @Bean
    public SalesInput salesInput() {
        return new ConsoleInput();
        //return new FileInput();
    }

    @Bean
    public ShippingPolicy shippingPolicy() {
        return new FlatRateShipping();
        //return new FreeShippingOverFifty();
        //return new FreeShipping();
    }

    @Bean
    public SalesReport salesReport() {
        return new SummaryReport();
        //return new DetailedReport();
    }
}

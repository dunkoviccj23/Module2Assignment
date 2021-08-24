package edu.wctc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext springContext =  new AnnotationConfigApplicationContext();
        springContext.register(AppConfig.class);
        springContext.refresh();


        ((SalesReportGenerator)springContext.getBean("salesReportGenerator")).generate();
    }
}

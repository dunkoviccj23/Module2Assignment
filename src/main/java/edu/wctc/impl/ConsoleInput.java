package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.SalesInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements SalesInput {
    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sale separated by comma (enter Q to quit): ");
        String sale = scanner.nextLine();
        while (!sale.equalsIgnoreCase("Q")) {
            String[] salesData = sale.split(",");
            sales.add(new Sale(salesData[0], salesData[1], Double.parseDouble(salesData[2]), Double.parseDouble(salesData[3])));
            System.out.print("Enter sale separated by comma (enter Q to quit): ");
            sale = scanner.nextLine();
        }
        return sales;
    }
}

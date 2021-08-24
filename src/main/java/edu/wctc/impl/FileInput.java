package edu.wctc.impl;

import edu.wctc.Sale;
import edu.wctc.iface.SalesInput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileInput implements SalesInput {
    @Override
    public List<Sale> getSales() {
        List<Sale> sales = new ArrayList<>();

        File salesFile = new File("sales.txt");
        try(Scanner fileReader = new Scanner(salesFile)) {
            while(fileReader.hasNextLine()) {
                String[] salesData = fileReader.nextLine().split(",");
                sales.add(new Sale(salesData[0], salesData[1], Double.parseDouble(salesData[2]), Double.parseDouble(salesData[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return sales;
    }
}

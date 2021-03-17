    package io.github.rwik;

    import java.io.*;
    import java.text.ParseException;
    import java.text.SimpleDateFormat;
    import java.util.*;




    public class Main {



        public static void main(String[] args) throws IOException, ParseException {
            String row;

            List<SalesRecord> csvList = new ArrayList<SalesRecord>();
            CsvReader reader = new CsvReader();
            csvList = reader.read("sales_records.csv");

            SalesRecordOperations operations = new SalesRecordOperations(csvList);
    //        (1) Find All distinct countries names and print them.
            operations.distinctCountries();
    //        (2) Print out the regions, county wise.
    //        (3) What are the distinct Item types sold region wise, print them.
    //        (4) Total how many units have been sold in Asia region.
            operations.asiaUnitSold();
    //        (5) Which region has the highest revenue.
    //        (6) Find out the total profit in online business, country wise.
    //        (7) Which country has maximum profit in offline business.
            operations.maxOfflineBusinessProfit();
    //        (8) Which country has sold the minimum unit and how much was the total unit cost.
    //        (9) Find out the average shipping time taken for high priority orders for each country.
    //        (10) Which item type is having highest profit, print the record and the profit. Formula
    //        to calculate profit is: Profit = Unit Price – Unit Cost



        }
    }

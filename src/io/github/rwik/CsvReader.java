package io.github.rwik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CsvReader {
    public List<SalesRecord>  read(String fileName) throws IOException, ParseException {
        String row;
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        List<SalesRecord> csvList = new ArrayList<SalesRecord>();
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        csvReader.readLine();
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            //System.out.println(data.toString());
            SalesRecord salesObj = new SalesRecord();
            salesObj.setRegion(data[0]);
            salesObj.setCountry(data[1]);
            salesObj.setItemType(data[2]);
            salesObj.setSalesChannel(data[3]);
            salesObj.setOrderProperty(data[4]);
            salesObj.setOrderDate(dateFormat.parse(data[5]));
            salesObj.setOrderID(Integer.parseInt(data[6]));
            salesObj.setShipDate(dateFormat.parse(data[7]));
            salesObj.setUnitsSold(Integer.parseInt(data[8]));
            salesObj.setUnitPrice(Float.parseFloat(data[9]));
            salesObj.setUnitCost(Float.parseFloat(data[10]));
            salesObj.setTotalRevenue(Float.parseFloat(data[11]));
            salesObj.setTotalCost(Float.parseFloat(data[12]));
            salesObj.setTotalProfit(Float.parseFloat(data[13]));
            csvList.add(salesObj);
        }
        csvReader.close();
        return csvList;
    }
}

package io.github.rwik;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalesRecordOperations {
    List<SalesRecord> csvList;

    public SalesRecordOperations(List<SalesRecord> csvList) {
        this.csvList = csvList;
    }

    public void distinctCountries(){
        Set<String> hash_Set = new HashSet<String>();
        for(SalesRecord obj : csvList)
        {
            hash_Set.add(obj.getCountry());
        }
        System.out.println(hash_Set);
    }
    public  void asiaUnitSold(){
        int asiaUnitSold = 0;
        for(SalesRecord obj : csvList)
        {
            //System.out.println(obj.getRegion());
            if(obj.getRegion().equals("Asia"))
            {
                asiaUnitSold += obj.getUnitsSold();
            }
        }
        System.out.println("asiaUnitSold = "+asiaUnitSold);
    }

    public void maxOfflineBusinessProfit()
    {
        HashMap<String,Float> map=new HashMap<String,Float>();
        for(SalesRecord obj : csvList)
        {
            //System.out.println(obj.getRegion());
            if(obj.getSalesChannel().equals("Offline"))
            {
                if(map.containsKey(obj.getCountry()))
                {
                    map.put(obj.getCountry(),map.get(obj.getCountry())+obj.getTotalProfit());

                }else {
                    map.put(obj.getCountry(), obj.getTotalProfit());
                }
            }
        }
        float maxVal =0;
        String maxKey = "";
        for(String key : map.keySet())
        {
            if(map.get(key) > maxVal)
            {
                maxVal = map.get(key);
                maxKey = key;
            }
        }

        System.out.println("Highest offline profit = "+maxKey);
    }


}

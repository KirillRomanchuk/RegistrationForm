package com.training.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RegInformation {

    private List<Map> informationHashMaps = new ArrayList<Map>();

    public List<Map> getListInformationHashMap (){
        return informationHashMaps;
    }

    /*public Map getInformationHashMap(int listIndex){
        if ()
        return;
    }*/

    public void addInformationHashMap (Map informationMap) {
        informationHashMaps.add(informationMap);
    }
}

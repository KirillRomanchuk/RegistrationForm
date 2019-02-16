package com.training.Model;

import com.training.BasicInformation;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.*;

public class InitializeRegInformation {

    public RegInformation InitializeRegInformation () {
        RegInformation regInformation = new RegInformation();
        Map infMap = createInformationMap();
        regInformation.addInformationHashMap(infMap);
        return regInformation;
    }

    private Map createInformationMap (){
        Map<BasicInformation.InformationKey, String> informationMap = new HashMap();
        Stream.of(BasicInformation.InformationKey.values()).forEach(infKey ->informationMap.put(infKey, ""));
        return informationMap;
    }
}

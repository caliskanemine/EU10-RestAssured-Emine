package com.cybertek.Day11;


import com.cybertek.utilities.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void test1(){

        ExcelUtil vytrackFile= new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");



                List<Map<String, String>> dataList= vytrackFile.getDataList();

        for (Map<String, String> rowMap : dataList) {
            System.out.println("rowMap = " + rowMap);
        }



    }



}

package com.loop.utilities;

import java.util.Arrays;

public class TestExcel {

    public static void main(String[] args) {
        ExcelUtils excelUtils = new ExcelUtils("C:\\Users\\quraa\\Desktop\\sample.xlsx","Jaad");
        System.out.println("excelUtils.getCellData(1,1) = " + excelUtils.getCellData(1, 1)); // starts from 0
        System.out.println("excelUtils.columnCount() = " + excelUtils.columnCount());
        System.out.println("excelUtils.getDataArray() = " + Arrays.deepToString(excelUtils.getDataArray()));
    }
}

package com.zyn.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @Author 赵亚楠
 * @create 2020/11/27 15:59
 * @Description
 */
public class Test01 {


    public static void main(String[] args) {


        HashMap<Object, Object> map = new HashMap<>();
        HashMap<Object, Object> map2= new HashMap<>();
        List<Object> list = new ArrayList<>();
        list.add(map);
        list.add(map2);

        System.out.println(list.size());

        if (map.isEmpty()){
            System.out.println("===");
        }

        if (map2.isEmpty()){
            System.out.println("===2222");
        }

        HashMap<Object, Object> map3 = null;
        System.out.println(map3.get(""));

    }




}




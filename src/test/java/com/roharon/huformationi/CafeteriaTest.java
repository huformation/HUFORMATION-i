package com.roharon.huformationi;

import com.roharon.huformationi.cafeteria.Cafeteria;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CafeteriaTest {

    @Test
    void CafeteriaGetTest(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();

        String nowDate = dateFormat.format(time);

        Cafeteria cf = new Cafeteria(nowDate);

        List<List<String>> cafeResult = cf.cafeteriaGet();
        System.out.println(cafeResult);
    }
}

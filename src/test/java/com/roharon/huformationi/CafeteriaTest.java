package com.roharon.huformationi;

import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CafeteriaTest {

    @Test
    void CafeteriaGetTest(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();

        String nowDate = dateFormat.format(time);

        List<Cafeteria> cfList = new ArrayList<>();

        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.GYOSOO));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.INMOON));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.SKYLOUNGE));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.GOOKJE));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.HOOSENG_STUDENT));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.HOOSENG_GYOJIK));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.HUFSDORM));
        cfList.add(new Cafeteria(nowDate, CafeteriaData.Cafe.UMOON));

        List<List<String>> cafeResult;

        for(Cafeteria cf: cfList){

            cafeResult = cf.processMenu();
            System.out.println(cf.toString());
        }

    }
}

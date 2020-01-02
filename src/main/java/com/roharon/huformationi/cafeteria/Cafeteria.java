package com.roharon.huformationi.cafeteria;

import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cafeteria {

    String day_d;
    String haksikUrl;


    public Cafeteria(String date){
        this.day_d = date;
        //date format - yyyyMMdd

         this.haksikUrl = "https://wis.hufs.ac.kr/jsp/HUFS/cafeteria/viewWeek.jsp?startDt="
                + day_d + "&endDt=" + day_d + "&caf_name=인문관식당&caf_id=h101";
    }

    public List<List<String>> cafeteriaGet(){

        Document doc = null;

        try {
            doc = Jsoup.connect(haksikUrl).get();
        }
        catch (IOException e){
            return null;
        }

        Elements info = doc.getElementsByTag("td");

        List<String> AllCafeteriaMenu = info.eachText();

        //final String[] matches = new String[] {"조식", "중식", "석식", "일품"};

        List<String> oneMenu = new ArrayList<String>();
        List<List<String>> menuResult = new ArrayList<List<String>>();

        {
            for (String menu : AllCafeteriaMenu) {

                if (menu.contains("조식") || menu.contains("중식") || menu.contains("석식") || menu.contains("일품")) {

                    oneMenu.remove(1);
                    // 중복되는 일렬 데이터 삭제

                    menuResult.add(oneMenu);
                    // 기존 추가된 단일메뉴를 menuResult에 추가
                    oneMenu = new ArrayList<String>();
                    //다시 단일 메뉴얻기위한 초기화
                }

                oneMenu.add(menu);
            }
            oneMenu.remove(1);
            //마지막 remove(1)처리
            oneMenu.remove(oneMenu.size() - 1);
            //분식 메뉴 제외

            menuResult.add(oneMenu);
            menuResult.remove(0);
            //요일/메뉴 내용 삭제
        }

        return menuResult;
    }
}

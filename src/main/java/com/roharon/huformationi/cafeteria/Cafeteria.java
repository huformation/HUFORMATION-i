package com.roharon.huformationi.cafeteria;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cafeteria implements CafeteriaData{

    String whichCafe;
    String haksikUrl;
    List<List<String>> menus;

    public Cafeteria(String date, Cafe cafePlace){
        //date format - yyyyMMdd

        if(cafePlace == Cafe.INMOON){
            this.whichCafe = this.InmoonUrl;
        }
        else if(cafePlace == Cafe.GYOSOO){
            this.whichCafe = this.GyosooUrl;
        }
        else if(cafePlace == Cafe.SKYLOUNGE){
            this.whichCafe = this.SkyloungeUrl;
        }
        else if(cafePlace == Cafe.GOOKJE){
            this.whichCafe = this.GookjeUrl;
        }
        else if(cafePlace == Cafe.HOOSENG_GYOJIK){
            this.whichCafe = this.HoosengGyojikUrl;
        }
        else if(cafePlace == Cafe.HOOSENG_STUDENT){
            this.whichCafe = this.HoosengStudentUrl;
        }
        else if(cafePlace == Cafe.UMOON){
            this.whichCafe = this.UmoonUrl;
        }
        else if(cafePlace == Cafe.HUFSDORM){
            this.whichCafe = this.HufsdormUrl;
        }
        else{
            this.whichCafe = null;
        }

        this.haksikUrl = String.format(whichCafe, date, date);

    }

    public List<List<String>> processMenu(){

        Document doc = null;

        try {
            doc = Jsoup.connect(haksikUrl).get();
        }
        catch (IOException e){
            return null;
        }

        Elements info = doc.getElementsByTag("td");

        if(info.text().contains("등록된 메뉴가 없습니다")) {
            return null;
        }

        List<String> AllCafeteriaMenu = info.eachText();

        List<String> oneMenu = new ArrayList<String>();
        List<List<String>> menuResult = new ArrayList<List<String>>();

        {
            for (String menu : AllCafeteriaMenu) {
                try{
                    if ((menu.length() < 20) && (menu.matches("조식(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*")
                            || menu.matches("중식(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*")
                            || menu.matches("석식(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*")
                            || menu.matches("일품(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*")
                            || menu.matches("메뉴(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*")
                            || menu.matches("샐러드(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*")
                            || menu.matches("뚝배기(\\(\\W\\W\\))?(\\(\\d\\))?(\\(\\w\\))? \\d{4}~\\w*\\s*"))) {
                        // 안내문에 단순 조,중,석식 이름 들어갈 경우의 분류 방지
                        try{
                            oneMenu.remove(1);
                            // 중복되는 일렬 데이터 삭제
                        }

                        catch (IndexOutOfBoundsException e){
                            // remove 에러 예외처리
                        }

                        menuResult.add(oneMenu);
                        // 기존 추가된 단일메뉴를 menuResult에 추가
                        oneMenu = new ArrayList<String>();
                        //다시 단일 메뉴얻기위한 초기화
                    }
                }

                catch (Exception e){
                }

                finally {
                    oneMenu.add(menu);
                }

            }
            oneMenu.remove(1);
            //마지막 remove(1)처리
            oneMenu.remove(oneMenu.size() - 1);
            //분식 메뉴 제외

            menuResult.add(oneMenu);
            menuResult.remove(0);
            //요일/메뉴 내용 삭제
        }

        this.menus = menuResult;
        return menuResult;
    }

    public String toString(){
        String stringResult = "";

        if(this.menus == null){
            return "";
        }

        for (List<String> menu: this.menus) {
            for (Integer ind = 0; ind < menu.size(); ind++){
                stringResult += menu.get(ind) + "\n";

                if (ind==0){
                    stringResult += "\n";
                }

                else if (ind == menu.size()-2){
                    stringResult += "\n";
                }
                else if (ind == menu.size() -1 ){
                    stringResult += "\n\n";
                }
            }
        }

        return stringResult;
    }
}

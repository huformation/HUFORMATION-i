package com.roharon.huformationi.webservice.response;

import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.sun.xml.bind.v2.model.annotation.Quick;

public interface replyData {

    String emptyCafe = "학식메뉴가 없습니다";

    QuickReply cafe = QuickReply.builder()
            .label("\uD83C\uDF72학식메뉴")
            .messageText("학식메뉴 보기")
            .action("message")
            .build();

    QuickReply library = QuickReply.builder()
            .label("\uD83D\uDCD2도서관 좌석")
            .messageText("도서관 좌석보기")
            .action("message")
            .build();

    QuickReply option = QuickReply.builder()
            .label("⚙️환경설정")
            .messageText("학식메뉴")
            .action("message")
            .build();

    QuickReply inmoon = QuickReply.builder()
            .label("인문관")
            .messageText("인문관 메뉴")
            .action("message")
            .build();

    QuickReply gyosoo = QuickReply.builder()
            .label("교수회관")
            .messageText("교수회관 메뉴")
            .action("message")
            .build();

    QuickReply skylounge = QuickReply.builder()
            .label("스카이라운지")
            .messageText("스카이라운지 메뉴")
            .action("message")
            .build();

    QuickReply gookje = QuickReply.builder()
            .label("국제사회교육원")
            .messageText("국제사회교육원 메뉴")
            .action("message")
            .build();

    QuickReply hoosenggyojik = QuickReply.builder()
            .label("후생관 교직원식당")
            .messageText("후생관 교직원식당 메뉴")
            .action("message")
            .build();

    QuickReply hoosengstudent = QuickReply.builder()
            .label("후생관 학생식당")
            .messageText("후생관 학생식당 메뉴")
            .action("message")
            .build();

    QuickReply umoon = QuickReply.builder()
            .label("어문관")
            .messageText("어문관 메뉴")
            .action("message")
            .build();

    QuickReply hufsdorm = QuickReply.builder()
            .label("기숙사식당")
            .messageText("기숙사식당 메뉴")
            .action("message")
            .build();
}

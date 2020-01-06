package com.roharon.huformationi.webservice.response;

import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.sun.xml.bind.v2.model.annotation.Quick;

public interface replyData {

    String emptyCafe = "학식메뉴가 없습니다";

    String inmoon_text = "인문관 메뉴";
    String gyosoo_text = "교수회관 메뉴";
    String skylounge_text = "스카이라운지 메뉴";
    String gookje_text = "국제사회교육원 메뉴";
    String hoosenggyojik_text = "후생관 교직원식당 메뉴";
    String hoosengstudent_text = "후생관 학생식당 메뉴";
    String umoon_text = "어문관 메뉴";
    String hufsdorm_text = "기숙사식당 메뉴";

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
            .action("block")
            .blockId("5e12ccdfffa74800014bdeb5")
            .build();

    QuickReply inmoon = QuickReply.builder()
            .label("인문관")
            .messageText(inmoon_text)
            .action("message")
            .build();

    QuickReply gyosoo = QuickReply.builder()
            .label("교수회관")
            .messageText(gyosoo_text)
            .action("message")
            .build();

    QuickReply skylounge = QuickReply.builder()
            .label("스카이라운지")
            .messageText(skylounge_text)
            .action("message")
            .build();

    QuickReply gookje = QuickReply.builder()
            .label("국제사회교육원")
            .messageText(gookje_text)
            .action("message")
            .build();

    QuickReply hoosenggyojik = QuickReply.builder()
            .label("후생관 교직원식당")
            .messageText(hoosenggyojik_text)
            .action("message")
            .build();

    QuickReply hoosengstudent = QuickReply.builder()
            .label("후생관 학생식당")
            .messageText(hoosengstudent_text)
            .action("message")
            .build();

    QuickReply umoon = QuickReply.builder()
            .label("어문관")
            .messageText(umoon_text)
            .action("message")
            .build();

    QuickReply hufsdorm = QuickReply.builder()
            .label("기숙사식당")
            .messageText(hufsdorm_text)
            .action("message")
            .build();

    QuickReply seoulCampus = QuickReply.builder()
            .label("서울캠퍼스")
            .action("block")
            .blockId("5e12ccdfffa74800014bdeb5")
            .build();

    QuickReply globalCampus = QuickReply.builder()
            .label("글로벌캠퍼스")
            .action("block")
            .blockId("5e12ccdfffa74800014bdeb5")
            .build();

    QuickReply changeCampus = QuickReply.builder()
            .label("캠퍼스 변경")
            .action("block")
            .blockId("5e12ccdfffa74800014bdeb5")
            .build();

    SkillResponse homeResponse = SkillResponse.builder()
            .template(SkillTemplate.builder()
                    .addOutput(SimpleTextView.builder()
                            .simpleText(SimpleText.builder()
                                    .text("아래 버튼을 눌러주세요")
                                    .build()
                            )
                            .build())
                    .addQuickReply(replyData.cafe)
                    .addQuickReply(replyData.library)
                    .addQuickReply(replyData.option)
                    .build())
            .build();


}

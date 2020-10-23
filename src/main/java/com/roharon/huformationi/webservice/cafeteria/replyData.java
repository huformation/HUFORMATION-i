package com.roharon.huformationi.webservice.cafeteria;

import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.QuickReply.QuickReplyBuilder;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.sun.xml.bind.v2.model.annotation.Quick;

public interface replyData {

  String emptyCafe = "학식메뉴가 없습니다";

  String tdy_text = "오늘은 어느 식당에서 드실건가요?";
  String tmw_text = "내일은 어느 식당에서 드실건가요?";
  String inmoon_text = "인문관에서 먹을래";
  String gyosoo_text = "교수회관에서 먹을래";
  String skylounge_text = "스카이라운지에서 먹을래";
  String gookje_text = "국사원에서 먹을래";
  String hoosenggyojik_text = "후생관 교직원식당에서 먹을래";
  String hoosengstudent_text = "후생관에서 먹을래";
  String umoon_text = "어문관에서 먹을래";
  String hufsdorm_text = "긱식 먹을래";

  QuickReply todayCafe = QuickReply.builder()
      .label("\uD83C\uDF72오늘의 학식")
      .action("block")
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tomorrowCafe = QuickReply.builder()
      .label("\uD83E\uDD58내일 학식")
      .action("block")
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReply library = QuickReply.builder()
      .label("\uD83D\uDCD2도서관 좌석")
      .action("block")
      .blockId("5e12c4f98192ac0001792dfd")
      .build();

  QuickReply option = QuickReply.builder()
      .label("⚙️환경설정")
      .action("block")
      .blockId("5e12ccdfffa74800014bdeb5")
      .build();

  QuickReplyBuilder inmoonBuilder = QuickReply.builder()
      .label("인문관")
      .messageText(inmoon_text)
      .action("block");

  QuickReply tdyInmoon = inmoonBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwInmoon = inmoonBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder gyosooBuilder = QuickReply.builder()
      .label("교수회관")
      .messageText(gyosoo_text)
      .action("block");

  QuickReply tdyGyosoo = gyosooBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwGyosoo = inmoonBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder skyloungeBuilder= QuickReply.builder()
      .label("스카이라운지")
      .messageText(skylounge_text)
      .action("block");

  QuickReply tdySkylounge = skyloungeBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwSkylounge = skyloungeBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder gookjeBuilder = QuickReply.builder()
      .label("국제사회교육원")
      .messageText(gookje_text)
      .action("block");

  QuickReply tdyGookje = gookjeBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwGookje = gookjeBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder hoosenggyojikBuilder = QuickReply.builder()
      .label("후생관 교직원식당")
      .messageText(hoosenggyojik_text)
      .action("block");

  QuickReply tdyHoosenggyojik = hoosenggyojikBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwHoosenggyojik = hoosenggyojikBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder hoosengstudentBuilder = QuickReply.builder()
      .label("후생관 학생식당")
      .messageText(hoosengstudent_text)
      .action("block");

  QuickReply tdyHoosengstudent = hoosengstudentBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwHoosengstudent = hoosengstudentBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder umoonBuilder = QuickReply.builder()
      .label("어문관")
      .messageText(umoon_text)
      .action("block");

  QuickReply tdyUmoon = umoonBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwUmoon = umoonBuilder
      .blockId("5e2d824f8192ac0001950f8b")
      .build();

  QuickReplyBuilder hufsdormBuilder = QuickReply.builder()
      .label("기숙사식당")
      .messageText(hufsdorm_text)
      .action("block");

  QuickReply tdyHufsdorm = hufsdormBuilder
      .blockId("5e12c4c8ffa74800014bddbd")
      .build();

  QuickReply tmwHufsdorm = hufsdormBuilder
      .blockId("5e2d824f8192ac0001950f8b")
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
          .addQuickReply(replyData.todayCafe)
          .addQuickReply(replyData.tomorrowCafe)
          .addQuickReply(replyData.library)
          .addQuickReply(replyData.option)
          .build())
      .build();


}

package com.roharon.huformationi.webservice.cafeteria;

import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
import com.roharon.huformationi.domain.user.User;
import com.roharon.huformationi.domain.user.UserRepository;
import com.roharon.huformationi.webservice.user.userData;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class CafeteriaController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  enum DT {
    TODAY, TOMORROW
  }
  private UserRepository userRepository;

  @ResponseBody
  @PostMapping("/today_cafe")
  public SkillResponse cafeToday(@RequestBody SkillPayload spl) {
    logger.info(spl.toString());
    if (spl.userRequest.getUtterance().contains("학식")) {
      User usr = userRepository.findByUserKey(spl.userRequest.user.getId());

      if (usr == null) {
        return userData.campusChange;
      } else if (usr.getCampus().equals(User.Campus.seoul)) {
        return this.showTodaySeoulCafeteriaList();
      } else if (usr.getCampus().equals(User.Campus.global)) {
        return this.showTodayGlobalCafeteriaList();
      } else {
        return replyData.homeResponse;
      }
    }

    return cafeProceed(spl, DT.TODAY);
  }

  @ResponseBody
  @PostMapping("/tomorrow_cafe")
  public SkillResponse cafeTomorrow(@RequestBody SkillPayload spl) {
    logger.info(spl.toString());

    if (spl.userRequest.getUtterance().contains("학식")) {
      User usr = userRepository.findByUserKey(spl.userRequest.user.getId());

      if (usr == null) {
        return userData.campusChange;
      } else if (usr.getCampus().equals(User.Campus.seoul)) {
        return this.showTomorrowSeoulCafeteriaList();
      } else if (usr.getCampus().equals(User.Campus.global)) {
        return this.showTomorrowGlobalCafeteriaList();
      } else {
        return replyData.homeResponse;
      }
    }

    return cafeProceed(spl, DT.TOMORROW);
  }

  private SkillResponse cafeProceed(SkillPayload spl, DT DAY) {
    String nowDate = getDayString(DAY);

    Cafeteria caf;
    CafeteriaData.Cafe cafeSelect = null;

    switch (spl.userRequest.getUtterance()) {
      case replyData.gyosoo_text:
        cafeSelect = Cafeteria.Cafe.GYOSOO;
        break;
      case replyData.inmoon_text:
        cafeSelect = Cafeteria.Cafe.INMOON;
        break;
      case replyData.skylounge_text:
        cafeSelect = Cafeteria.Cafe.SKYLOUNGE;
        break;
      case replyData.gookje_text:
        cafeSelect = Cafeteria.Cafe.GOOKJE;
        break;
      case replyData.hoosenggyojik_text:
        cafeSelect = Cafeteria.Cafe.HOOSENG_GYOJIK;
        break;
      case replyData.hoosengstudent_text:
        cafeSelect = Cafeteria.Cafe.HOOSENG_STUDENT;
        break;
      case replyData.umoon_text:
        cafeSelect = Cafeteria.Cafe.UMOON;
        break;
      case replyData.hufsdorm_text:
        cafeSelect = Cafeteria.Cafe.HUFSDORM;
        break;
      default:
        logger.error(nowDate, spl.getUserRequest().toString());
    }

    caf = new Cafeteria(nowDate, cafeSelect);
    caf.processMenu();

    String cafeResult = caf.toString();

    if (cafeResult.length() == 0) {
      cafeResult = replyData.emptyCafe;
    }

    return SkillResponse.builder()
        .template(SkillTemplate.builder()
            .addOutput(SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                    .text(cafeResult)
                    .build())
                .build())
            .addQuickReply(replyData.todayCafe)
            .addQuickReply(replyData.tomorrowCafe)
            .addQuickReply(replyData.library)
            .addQuickReply(replyData.option)
            .build())
        .build();
  }

  private String getDayString(DT d) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    Date dt = new Date();
    Calendar calendar = Calendar.getInstance();

    calendar.setTime(dt);
    if (d == DT.TOMORROW) {
      calendar.add(Calendar.DATE, 1);
    }

    return dateFormat.format(calendar.getTime());
  }

  private SkillResponse showTodaySeoulCafeteriaList() {

    return SkillResponse.builder()
        .template(SkillTemplate.builder()
            .addOutput(SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                    .text(replyData.tdy_text)
                    .build())
                .build())
            .addQuickReply(replyData.tdyInmoon)
            .addQuickReply(replyData.tdyGyosoo)
            .addQuickReply(replyData.tdySkylounge)
            .build())
        .build();
  }

  private SkillResponse showTomorrowSeoulCafeteriaList() {

    return SkillResponse.builder()
        .template(SkillTemplate.builder()
            .addOutput(SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                    .text(replyData.tmw_text)
                    .build())
                .build())
            .addQuickReply(replyData.tmwInmoon)
            .addQuickReply(replyData.tmwGyosoo)
            .addQuickReply(replyData.tmwSkylounge)
            .build())
        .build();
  }

  private SkillResponse showTodayGlobalCafeteriaList() {

    return SkillResponse.builder()
        .template(SkillTemplate.builder()
            .addOutput(SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                    .text(replyData.tdy_text)
                    .build())
                .build())
            .addQuickReply(replyData.tdyHoosengstudent)
            .addQuickReply(replyData.tdyHoosenggyojik)
            .addQuickReply(replyData.tdyHufsdorm)
            .addQuickReply(replyData.tdyUmoon)
            .addQuickReply(replyData.tdyGookje)
            .build())
        .build();
  }

  private SkillResponse showTomorrowGlobalCafeteriaList() {

    return SkillResponse.builder()
        .template(SkillTemplate.builder()
            .addOutput(SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                    .text(replyData.tmw_text)
                    .build())
                .build())
            .addQuickReply(replyData.tmwHoosengstudent)
            .addQuickReply(replyData.tmwHoosenggyojik)
            .addQuickReply(replyData.tmwHufsdorm)
            .addQuickReply(replyData.tmwUmoon)
            .addQuickReply(replyData.tmwGookje)
            .build())
        .build();
  }
}

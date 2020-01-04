package com.roharon.huformationi.webservice.response;

import com.google.gson.Gson;
import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.CarouselView;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.BasicCard;
import com.roharon.huformationi.wrapper.component.componentType.Carousel;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.roharon.huformationi.wrapper.type.buttons.shareButton;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
public class CafeteriaController {

    @ResponseBody
    @PostMapping("/cafe")
    public SkillResponse cafe(@RequestBody SkillPayload spl) {

        // For test
        if (spl.userRequest.getUtterance().contains("학식메뉴 보기")) {
            System.out.println(spl.userRequest.getUtterance());
            return this.ShowSeoulCafeteriaList();
        }
        //TODO 식당별 조회 분류
        //타 기능 분류
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();

        String nowDate = dateFormat.format(time);
        Cafeteria caf = new Cafeteria(nowDate, CafeteriaData.Cafe.GYOSOO);
        caf.processMenu();

        String cafeResult = caf.toString();

        if (cafeResult.length() == 0) {
            cafeResult = replyData.emptyCafe;
        }

        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text(cafeResult)
                                        .build())
                                .build())
                        .addQuickReply(replyData.cafe)
                        .addQuickReply(replyData.library)
                        .addQuickReply(replyData.option)
                        .build())
                .build();

        return sr;
    }

    public SkillResponse ShowSeoulCafeteriaList() {

        return SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text("식당을 선택해주세요")
                                        .build())
                                .build())
                        .addQuickReply(replyData.inmoon)
                        .addQuickReply(replyData.gyosoo)
                        .addQuickReply(replyData.skylounge)
                        .build())
                .build();
    }
}

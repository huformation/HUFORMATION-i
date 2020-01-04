package com.roharon.huformationi.webservice.response;

import com.google.gson.Gson;
import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
public class CafeteriaController {

    @ResponseBody
    @PostMapping("/cafe")
    public SkillResponse cafe() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();

        String nowDate = dateFormat.format(time);
        Cafeteria caf = new Cafeteria(nowDate, CafeteriaData.Cafe.GYOSOO);
        caf.processMenu();

        String cafeResult = caf.toString();

        if (cafeResult.length()==0){
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

        Gson gson = new Gson();
        String result = gson.toJson(sr);

        return sr;
    }
}

package com.roharon.huformationi.webservice;

import com.google.gson.Gson;
import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
import com.roharon.huformationi.webservice.response.replyData;
import com.roharon.huformationi.webservice.users.UsersRepository;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.BasicCardView;
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
public class HomeMenuController {

    private UsersRepository usersRepository;

    @ResponseBody
    @PostMapping("/home")
    public SkillResponse home() {

        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text("안녕하세요")
                                        .build()
                                )
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

    @GetMapping("/")
    public String root(@RequestParam(value="date", required = true, defaultValue = "20191211") String date) {

        Cafeteria caf = new Cafeteria(date, CafeteriaData.Cafe.GYOSOO);
        caf.processMenu();

        return caf.toString();
    }
}

package com.roharon.huformationi.webservice;

import com.google.gson.Gson;
import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
import com.roharon.huformationi.webservice.users.UsersRepository;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.BasicCardView;
import com.roharon.huformationi.wrapper.component.CarouselView;
import com.roharon.huformationi.wrapper.component.componentType.BasicCard;
import com.roharon.huformationi.wrapper.component.componentType.Carousel;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.roharon.huformationi.wrapper.type.buttons.shareButton;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@AllArgsConstructor
public class WebRestController {

    private UsersRepository usersRepository;

    @ResponseBody
    @PostMapping("/hello")
    public SkillResponse hello() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();

        String nowDate = dateFormat.format(time);

        Cafeteria caf = new Cafeteria(nowDate, CafeteriaData.Cafe.GYOSOO);
        caf.processMenu();

        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(CarouselView.builder()
                                .carousel(Carousel.builder()
                                        .type("basicCard")
                                        .addItem(BasicCard.builder()
                                                .title("베이직 제목")
                                                .description(caf.toString())
                                                .addButton(shareButton.builder()
                                                        .label("공유하기")
                                                        .build())
                                                .build())
                                        .addItem(BasicCard.builder()
                                                .title("베이직 제목")
                                                .description(caf.toString())
                                                .addButton(shareButton.builder()
                                                        .label("공유하기")
                                                        .build())
                                                .build())
                                        .addItem(BasicCard.builder()
                                                .title("베이직 제목")
                                                .description(caf.toString())
                                                .addButton(shareButton.builder()
                                                        .label("공유하기")
                                                        .build())
                                                .build())

                                        .build())
                                .build())
                        .addQuickReply(QuickReply.builder()
                                .label("QR1")
                                .messageText("QR1누름")
                                .action("message")
                                .build())
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

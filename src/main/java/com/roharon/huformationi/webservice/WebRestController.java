package com.roharon.huformationi.webservice;

import com.google.gson.Gson;
import com.roharon.huformationi.webservice.users.UsersRepository;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.componentType.BasicCard;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.roharon.huformationi.wrapper.type.buttons.shareButton;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private UsersRepository usersRepository;

    @GetMapping("/hello")
    public String hello() {
        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(BasicCard.builder()
                                .title("베이직 제목")
                                .description("부가설명")
                                .addButton(shareButton.builder()
                                        .label("공유하기")
                                        .build())
                                .build())
                        .build())
                .build();

        Gson gson = new Gson();
        String result = gson.toJson(sr);

        return result;
    }

    @GetMapping("/")
    public String root(){
        return "root";
    }
}

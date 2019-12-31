package com.roharon.huformationi;

import com.google.gson.Gson;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.CommerceCardView;
import com.roharon.huformationi.wrapper.component.Component;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.CommerceCard;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ComponentTest {

    @Test
    void SimpleTextTest() {

        Component comp = SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                        .text("11")
                        .build())
                .build();

        SkillTemplate st = SkillTemplate.builder()
                .addOutput(comp)
                .addOutput(comp)
                .addOutput(comp)
                .build();

        SkillResponse sr = SkillResponse.builder()
                .version("2.0")
                .template(st)
                .build();

        Gson gson = new Gson();

        System.out.println(sr);
        String srJson = gson.toJson(sr);

        System.out.println(srJson);

        String ExpectJson = "{\"version\":\"2.0\",\"template\":{\"outputs\":[{\"simpleText\":{\"text\":\"11\"}}," +
                "{\"simpleText\":{\"text\":\"11\"}},{\"simpleText\":{\"text\":\"11\"}}],\"quickReplies\":[]}}";

        assertEquals(ExpectJson, srJson);
    }

    @Test
    void CommerceCardTest() {

        Component outputCard = CommerceCard.builder()
                .description("커머스 제품 상세설명")
                .price(5555)
                .currency("won")
                .build();

        SkillResponse sr = SkillResponse.builder()
                .version("2.0")
                .template(SkillTemplate.builder()
                        .addOutput(outputCard)
                        .addQuickReply(QuickReply.builder()
                                .label("퀵리플라이버튼1")
                                .messageText("퀵리플라이버튼1 눌렀습니다.")
                                .action("message")
                                .build())
                        .build())
                .build();

        Gson gson = new Gson();
        String srJson = gson.toJson(sr);

        System.out.println(srJson);
    }

}

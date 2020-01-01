package com.roharon.huformationi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.*;
import com.roharon.huformationi.wrapper.component.componentType.*;
import com.roharon.huformationi.wrapper.type.*;
import com.roharon.huformationi.wrapper.type.buttons.phoneButton;
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

    @Test
    void ComponentWithButtonTest() {
        CarouselView crl = CarouselView.builder()
                .carousel(Carousel.builder()
                        .type("commerceCard")
                        .header(CarouselHeader.builder()
                                .title("캐로셀 헤더 제목")
                                .thumbnail(Thumbnail.builder()
                                        .imageUrl("https://image.png")
                                        .build())
                                .build())
                        .addItem(BasicCard.builder()
                                .title("베이직카드 제목")
                                .description("베제 설명")
                                .addButton(phoneButton.builder()
                                        .label("전화걸기")
                                        .phoneNumber("01012345678")
                                        .build())
                                .build())
                        .build())
                .build();

        QuickReply qr = QuickReply.builder()
                .label("퀵리플라이1")
                .action("message")
                .messageText("퀵리1 사용자에게 보이는 발화")
                .build();

        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(crl)
                        .addQuickReply(qr)
                        .build())
                .build();

        Gson gson = new Gson();
        String srJson = gson.toJson(sr);
        System.out.println(srJson);
    }
}

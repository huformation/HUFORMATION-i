package com.roharon.huformationi.webservice.response;

import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;

public interface replyData {
    SkillResponse homeButton = SkillResponse.builder()
            .template(SkillTemplate.builder()
                    .addQuickReply()
                    .addQuickReply(QuickReply.builder()
                            .label("\uD83D\uDCD2도서관 좌석")
                            .messageText("도서관 좌석보기")
                            .action("message")
                            .build())
                    .addQuickReply(QuickReply.builder()
                            .label("⚙️환경설정")
                            .messageText("학식메뉴")
                            .action("message")
                            .build())
                    .build())
            .build();

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
            .messageText("학식메뉴")
            .action("message")
            .build();
}

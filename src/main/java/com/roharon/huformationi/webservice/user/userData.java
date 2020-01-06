package com.roharon.huformationi.webservice.user;

import com.roharon.huformationi.webservice.response.replyData;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.SkillTemplate;

public interface userData {

    SkillResponse campusChange = SkillResponse.builder()
            .template(SkillTemplate.builder()
                    .addOutput(SimpleTextView.builder()
                            .simpleText(SimpleText.builder()
                                    .text("캠퍼스를 선택해주세요")
                                    .build())
                            .build())
                    .addQuickReply(replyData.seoulCampus)
                    .addQuickReply(replyData.globalCampus)
                    .build())
            .build();
}

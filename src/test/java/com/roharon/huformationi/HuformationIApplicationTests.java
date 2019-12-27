package com.roharon.huformationi;

import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.payload.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HuformationIApplicationTests {

    @Test
    void userRequestpayload() {

        String userData = "{\n" +
                " \"userRequest\": {\n" +
                "    \"timezone\": \"Asia/Seoul\",\n" +
                "    \"params\": {},\n" +
                "    \"block\": {\n" +
                "      \"id\": \"<블록 id>\",\n" +
                "      \"name\": \"<블록 이름>\"\n" +
                "    },\n" +
                "    \"utterance\": \"<사용자 발화>\",\n" +
                "    \"lang\": \"kr\",\n" +
                "    \"user\": {\n" +
                "      \"id\": \"<사용자 botUserKey>\",\n" +
                "      \"type\": \"botUserKey\",\n" +
                "      \"properties\": {\n" +
                "        \"plusfriendUserKey\": \"<카카오톡 채널 사용자 id>\"\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"contexts\": [],\n" +
                "  \"bot\": {\n" +
                "    \"id\": \"<봇 id>\",\n" +
                "    \"name\": \"<봇 이름>\"\n" +
                "  },\n" +
                "  \"action\": {\n" +
                "    \"name\": \"<스킬 이름>\",\n" +
                "    \"clientExtra\": null,\n" +
                "    \"params\": {},\n" +
                "    \"id\": \"<스킬 id>\",\n" +
                "    \"detailParams\": {}\n" +
                "  }\n" +
                "}";

        SkillPayload spl = new SkillPayload(userData);
        
        System.out.println(spl.userRequest.getTimezone());
        System.out.println(spl.userRequest.block);
        System.out.println(spl.userRequest.block.getId());
        System.out.println(spl.userRequest.block.getName());
        System.out.println(spl.bot.getId());
        System.out.println(spl.bot.getName());
        System.out.println(spl.userRequest.user.properties.getPlusfriendUserKey());

    }

}

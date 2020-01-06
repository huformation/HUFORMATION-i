package com.roharon.huformationi.webservice.option;

import com.roharon.huformationi.webservice.response.replyData;
import com.roharon.huformationi.webservice.user.User;
import com.roharon.huformationi.webservice.user.UserRepository;
import com.roharon.huformationi.webservice.user.userData;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OptionController {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @PostMapping("/option")
    public SkillResponse option(@RequestBody SkillPayload spl){

        if(spl.userRequest.getUtterance().contains("캠퍼스 변경")){
            return userData.campusChange;
        }
        else if(spl.userRequest.getUtterance().contains("서울캠퍼스")){

            this.changeCampus(spl.userRequest.user.getId(), "seoul");

            return replyData.homeResponse;
        }
        else if(spl.userRequest.getUtterance().contains("글로벌캠퍼스")){

            this.changeCampus(spl.userRequest.user.getId(), "global");

            return replyData.homeResponse;
        }

        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text("환경설정 메뉴입니다")
                                        .build())
                                .build())
                        .addQuickReply(replyData.changeCampus)
                        .build())
                .build();

        return sr;

    }

    public void changeCampus(String key, String selectCampus){
        List<User> usr = userRepository.findByUserkey(key);

        if(usr.size() == 0){
            userRepository.save(User.builder()
                    .userkey(key)
                    .campus(selectCampus)
                    .build());
        }
        else{
            usr.get(0).setCampus(selectCampus);
            System.out.println(usr.get(0).getCampus());

        }
    }
}

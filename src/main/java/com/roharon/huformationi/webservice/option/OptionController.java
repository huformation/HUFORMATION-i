package com.roharon.huformationi.webservice.option;

import com.roharon.huformationi.webservice.cafeteria.replyData;
import com.roharon.huformationi.domain.user.User;
import com.roharon.huformationi.domain.user.UserRepository;
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

import javax.validation.constraints.Null;
import java.util.List;

@RestController
public class OptionController {
  private UserRepository userRepository;

  @Autowired
  public OptionController(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Transactional
  @PostMapping("/option")
  public SkillResponse option(@RequestBody SkillPayload spl){

    if(spl.userRequest.getUtterance().contains("캠퍼스 변경")){
      return userData.campusChange;
    }
    else if(spl.userRequest.getUtterance().contains("서울캠퍼스")){

      this.changeCampus(spl.userRequest.user.getId(), User.Campus.seoul);

      return replyData.homeResponse;
    }
    else if(spl.userRequest.getUtterance().contains("글로벌캠퍼스")){

      this.changeCampus(spl.userRequest.user.getId(), User.Campus.global);

      return replyData.homeResponse;
    }

    return SkillResponse.builder()
        .template(SkillTemplate.builder()
            .addOutput(SimpleTextView.builder()
                .simpleText(SimpleText.builder()
                    .text("환경설정 메뉴입니다")
                    .build())
                .build())
            .addQuickReply(replyData.changeCampus)
            .build())
        .build();

  }

  private void changeCampus(String key, User.Campus campus){
    User usr = userRepository.findByUserKey(key);

    if(usr == null){
      userRepository.save(User.builder()
          .userKey(key)
          .campus(campus)
          .build());
    }
    else{
      usr.setCampus(campus);
    }
  }
}

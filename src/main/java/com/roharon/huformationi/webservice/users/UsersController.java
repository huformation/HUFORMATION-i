package com.roharon.huformationi.webservice.users;

import com.roharon.huformationi.webservice.response.replyData;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UsersController {


    @ResponseBody
    @PostMapping("/campus")
    public SkillResponse ShowCampusList(){

        return userData.campusChange;
    }
}

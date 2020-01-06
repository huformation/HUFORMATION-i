package com.roharon.huformationi.webservice.user;

import com.roharon.huformationi.wrapper.SkillResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {


    @ResponseBody
    @PostMapping("/campus")
    public SkillResponse ShowCampusList() {

        return userData.campusChange;
    }
}

package com.roharon.huformationi.webservice;

import com.roharon.huformationi.webservice.response.replyData;
import com.roharon.huformationi.wrapper.SkillResponse;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HomeMenuController {

    @ResponseBody
    @PostMapping("/home")
    public SkillResponse home() {

        return replyData.homeResponse;
    }
}

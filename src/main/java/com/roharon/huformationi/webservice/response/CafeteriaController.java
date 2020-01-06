package com.roharon.huformationi.webservice.response;

import com.google.gson.Gson;
import com.roharon.huformationi.cafeteria.Cafeteria;
import com.roharon.huformationi.cafeteria.CafeteriaData;
import com.roharon.huformationi.webservice.HomeMenuController;
import com.roharon.huformationi.webservice.users.Users;
import com.roharon.huformationi.webservice.users.UsersController;
import com.roharon.huformationi.webservice.users.UsersRepository;
import com.roharon.huformationi.webservice.users.userData;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.CarouselView;
import com.roharon.huformationi.wrapper.component.SimpleTextView;
import com.roharon.huformationi.wrapper.component.componentType.BasicCard;
import com.roharon.huformationi.wrapper.component.componentType.Carousel;
import com.roharon.huformationi.wrapper.component.componentType.SimpleText;
import com.roharon.huformationi.wrapper.type.QuickReply;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import com.roharon.huformationi.wrapper.type.User;
import com.roharon.huformationi.wrapper.type.buttons.shareButton;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class CafeteriaController {

    UsersRepository usersRepository;

    @ResponseBody
    @PostMapping("/cafe")
    public SkillResponse cafe(@RequestBody SkillPayload spl) {
        System.out.println(spl.userRequest.block.getName() + spl.userRequest.block.getId());
        // For test
        if (spl.userRequest.getUtterance().contains("학식메뉴")) {
            List<Users> usr = usersRepository.findByUserkey(spl.userRequest.user.getId());

            if(usr.size()==0){
                return userData.campusChange;
            }
            else if(usr.get(0).getCampus() == "seoul"){
                return this.ShowSeoulCafeteriaList();
            }
            else if(usr.get(0).getCampus() == "global"){
                return this.ShowGlobalCafeteriaList();

            }

        }

        else if (spl.userRequest.getUtterance() == "서울캠퍼스"){

            return replyData.homeResponse;
        }
        else if(spl.userRequest.getUtterance() == "글로벌캠퍼스"){
            usersRepository.save(new Users(spl.userRequest.user.getId(), "global"));

            return replyData.homeResponse;
        }

        //TODO 식당별 조회 분류
        //타 기능 분류
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date time = new Date();

        String nowDate = dateFormat.format(time);

        Cafeteria caf;
        CafeteriaData.Cafe cafeSelect;

        switch(spl.userRequest.getUtterance()){
            case replyData.gyosoo_text:
                cafeSelect = Cafeteria.Cafe.GYOSOO;
                break;
            case replyData.inmoon_text:
                cafeSelect = Cafeteria.Cafe.INMOON;
                break;
            case replyData.skylounge_text:
                cafeSelect = Cafeteria.Cafe.SKYLOUNGE;
                break;
            case replyData.gookje_text:
                cafeSelect = Cafeteria.Cafe.GOOKJE;
                break;
            case replyData.hoosenggyojik_text:
                cafeSelect = Cafeteria.Cafe.HOOSENG_GYOJIK;
                break;
            case replyData.hoosengstudent_text:
                cafeSelect = Cafeteria.Cafe.HOOSENG_STUDENT;
                break;
            case replyData.umoon_text:
                cafeSelect = Cafeteria.Cafe.UMOON;
                break;
            case replyData.hufsdorm_text:
                cafeSelect = Cafeteria.Cafe.HUFSDORM;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + spl.userRequest.getUtterance());
        }

        caf = new Cafeteria(nowDate, cafeSelect);
        caf.processMenu();

        String cafeResult = caf.toString();

        if (cafeResult.length() == 0) {
            cafeResult = replyData.emptyCafe;
        }

        SkillResponse sr = SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text(cafeResult)
                                        .build())
                                .build())
                        .addQuickReply(replyData.cafe)
                        .addQuickReply(replyData.library)
                        .addQuickReply(replyData.option)
                        .build())
                .build();

        return sr;
    }

    public SkillResponse ShowSeoulCafeteriaList() {

        return SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text("식당을 선택해주세요")
                                        .build())
                                .build())
                        .addQuickReply(replyData.inmoon)
                        .addQuickReply(replyData.gyosoo)
                        .addQuickReply(replyData.skylounge)
                        .build())
                .build();
    }

    public SkillResponse ShowGlobalCafeteriaList() {

        return SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(SimpleTextView.builder()
                                .simpleText(SimpleText.builder()
                                        .text("식당을 선택해주세요")
                                        .build())
                                .build())
                        .addQuickReply(replyData.hoosengstudent)
                        .addQuickReply(replyData.hoosenggyojik)
                        .addQuickReply(replyData.hufsdorm)
                        .addQuickReply(replyData.umoon)
                        .addQuickReply(replyData.gookje)
                        .build())
                .build();
    }
}

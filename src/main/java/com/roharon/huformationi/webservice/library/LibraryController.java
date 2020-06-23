package com.roharon.huformationi.webservice.library;

import com.roharon.huformationi.domain.user.User;
import com.roharon.huformationi.domain.user.User.Campus;
import com.roharon.huformationi.domain.user.UserRepository;
import com.roharon.huformationi.library.Library;
import com.roharon.huformationi.webservice.cafeteria.replyData;
import com.roharon.huformationi.webservice.user.userData;
import com.roharon.huformationi.wrapper.SkillPayload;
import com.roharon.huformationi.wrapper.SkillResponse;
import com.roharon.huformationi.wrapper.component.ListCardView;
import com.roharon.huformationi.wrapper.component.componentType.ListCard;
import com.roharon.huformationi.wrapper.type.ListItem;
import com.roharon.huformationi.wrapper.type.SkillTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class LibraryController {
    private UserRepository userRepository;

    @Autowired
    public LibraryController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/library")
    public SkillResponse library(@RequestBody SkillPayload spl){

        String userKey = spl.userRequest.user.getId();
        User usr = userRepository.findByUserKey(userKey);

        if(usr == null){
            return userData.campusChange;
        }

        Campus userCampus = usr.getCampus();
        Library library = new Library(userCampus);
        List<Map<String, Object>> seatData = library.process();

        List<ListItem> seatListData = new ArrayList<>();

        for(Map<String, Object> data : seatData){
            int available = (int)((double) data.get("available"));
            int total = (int)((double) data.get("total"));

            String description = String
                    .format("이용 가능 : %d / 전체 좌석 : %d", available, total);

            seatListData.add(ListItem.builder()
                    .title((String) data.get("name"))
                    .description(description)
                    .build());
        }

        return SkillResponse.builder()
                .template(SkillTemplate.builder()
                        .addOutput(ListCardView.builder()
                                .listCard(ListCard.builder()
                                        .header(ListItem.builder()
                                            .title("도서관 자리 안내")
                                            .build())
                                    .items(seatListData)
                                    .build())
                                .build())
                        .addQuickReply(replyData.cafe)
                        .addQuickReply(replyData.library)
                        .addQuickReply(replyData.option)
                        .build())
                .build();
    }
}

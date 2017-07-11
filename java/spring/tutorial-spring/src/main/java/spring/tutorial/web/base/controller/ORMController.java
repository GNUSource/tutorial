package spring.tutorial.web.base.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.tutorial.orm.domain.User;
import spring.tutorial.orm.domain.UserProfile;
import spring.tutorial.orm.repository.IUserRepository;
import spring.tutorial.orm.repository.UserProfileRepository;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orm")
public class ORMController {

    private static final ObjectMapper mapper = new ObjectMapper();

//    @Autowired
//    private IBlockTxRepository iBlockTxRepository;

    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

//    @ResponseBody
//    @RequestMapping(value = "/blocktx/list", method = RequestMethod.GET)
//    public String getList() {
//        List<BlockTx> blockTxes = iBlockTxRepository.findAll();
//        try {
//            mapper.writeValue(System.out, blockTxes);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("this is test");
//        return null;
//    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getList(@PathVariable("id") Integer id) throws JsonProcessingException {
        User user = iUserRepository.getUserDetail(id);
        try {
            mapper.writeValue(System.out, user);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapper.writeValueAsString(user);
    }


    @ResponseBody
    @RequestMapping(value = "/user-profile", method = RequestMethod.GET)
    public String getUserProfileList() throws JsonProcessingException {
        Date now = new Date();
        String perferedContactMode = "m";
        List<UserProfile> userProfiles = userProfileRepository.findByLastAccessTimeGreaterThanAndPreferredContactMode(now, perferedContactMode);
        try {
            mapper.writeValue(System.out, userProfiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mapper.writeValueAsString(userProfiles);
    }


}

package jmu.zyu.jianglin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jmu.zyu.jianglin.dao.WxUser;
import jmu.zyu.jianglin.dao.WxUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/wx")
public class WxUserController {

    private final String URL_code2Session = "https://api.weixin.qq.com/sns/jscode2session";
    private final String WxAppId = "wxb4d9506522390ec9";
    private final String WxAppSecret = "b966f88a2d58a7fa8b23130ab52c32f3";

    @GetMapping("/code2session")
    public ResponseEntity<?> getOpenIdAndSessionKey(@RequestParam String WxCode) throws JsonProcessingException {
        System.out.println("ovo, in getOpenIdAndSessionKey(), WxCode = " + WxCode);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(URL_code2Session)
                .queryParam("appid", WxAppId)
                .queryParam("secret", WxAppSecret)
                .queryParam("js_code", WxCode)
                .queryParam("grant_type", "authorization_code");
        String finalUrl = uriBuilder.toUriString();

        RestTemplate restTemplate = new RestTemplate();
        String responseString = restTemplate.getForObject(finalUrl, String.class);
        Map<String, Object> response = new ObjectMapper().readValue(responseString, Map.class);


        if (response == null)
            return new ResponseEntity<>("No response from WeChat server", HttpStatus.INTERNAL_SERVER_ERROR);

        if (response.containsKey("errcode") && (int) response.get("errcode")!=0)
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @Autowired
    WxUserRepository wxUserRepository;

    @GetMapping("/user/{openid}")
    @ResponseBody
    public ResponseEntity<?> getWxUserByOpenId(@PathVariable String openid){
        System.out.println("qaq, getWxUserByOpenId(): openid: " + openid);
        if (wxUserRepository.existsById( openid )) {
            return ResponseEntity.ok(wxUserRepository.findById(openid) );
        } else {
            return ResponseEntity.badRequest().body("[openid not exist] openid " + openid + " does not exist");
        }
    }

    @GetMapping("/user/all")
    @ResponseBody
    public ResponseEntity<?> GetWxUserList(){
        return ResponseEntity.ok(wxUserRepository.findAll());
    }

    @PostMapping("/user/add")
    @ResponseBody
    public ResponseEntity<?> addNewWxUser( @RequestBody WxUser wxUser ){
        System.out.println("qaq, addNewWxUser(): openid: " + wxUser.getOpen_id());
        // ↓注意是已经存在
        if ( wxUserRepository.existsById( wxUser.getOpen_id() )){
            return ResponseEntity.badRequest().body("openid" + wxUser.getOpen_id() + "already exists");
        } else {
            return ResponseEntity.ok( wxUserRepository.save(wxUser) );
        }
    }

    @PutMapping("/user/update/{openid}")
    @ResponseBody
    public ResponseEntity<?> updateWxUserByOpenId(@PathVariable String oldOpenId, @RequestBody WxUser newWxUserInfo){
        // ↓注意是不存在 有感叹号
        if ( !wxUserRepository.existsById( oldOpenId ))
            return ResponseEntity.badRequest().body("openid" + newWxUserInfo.getOpen_id() + "does not exist");


        WxUser wxUserInDb = wxUserRepository.findById(oldOpenId)
                .orElseThrow(() -> new IllegalArgumentException("id " + oldOpenId + " does not exist"));

        wxUserInDb.setName( newWxUserInfo.getName() );
        wxUserInDb.setPhone( newWxUserInfo.getPhone() );
        wxUserInDb.setWx_gender( newWxUserInfo.getWx_gender() );
        wxUserInDb.setWx_nickname(newWxUserInfo.getWx_nickname() );
        wxUserInDb.setWx_avatar_url(newWxUserInfo.getWx_avatar_url() );

        return ResponseEntity.ok( wxUserRepository.save(wxUserInDb) );
    }



}

package jmu.zyu.jianglin.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WxMpQrCodeController {

    private static final Logger logger = LoggerFactory.getLogger(WxMpQrCodeController.class);

    private final String WxAppId = "wxb4d9506522390ec9";
    private final String WxAppSecret = "b966f88a2d58a7fa8b23130ab52c32f3";

    private RestTemplate restTemplate = new RestTemplate();

    private String getAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={APPID}&secret={APPSECRET}";
        Map<String, String> params = new HashMap<>();
        params.put("APPID", WxAppId);
        params.put("APPSECRET", WxAppSecret);

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class, params);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return (String) response.getBody().get("access_token");
        } else {
            logger.error("Failed to get access token: {}", response);
            throw new RuntimeException("Failed to get access token");
        }
    }

    @GetMapping("/getQrCode")
    public ResponseEntity<byte[]> getQrCode(
            @RequestParam String scene,
            @RequestParam(required = false, defaultValue = "pages/index/index") String page,
            @RequestParam(required = false, defaultValue = "430") int width,
            @RequestParam(required = false, defaultValue = "false") boolean autoColor,
            @RequestParam(required = false, defaultValue = "{\"r\":0,\"g\":0,\"b\":0}") String lineColor,
            @RequestParam(required = false, defaultValue = "false") boolean isHyaline) {

        try {
            String accessToken = getAccessToken();
            String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + accessToken;

            Map<String, Object> body = new HashMap<>();
            body.put("scene", scene);
            body.put("page", page);
            body.put("width", width);
            body.put("auto_color", autoColor);
            body.put("line_color", lineColor);
            body.put("is_hyaline", isHyaline);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            ResponseEntity<byte[]> response = restTemplate.postForEntity(url, requestEntity, byte[].class);
            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_PNG)
                        .body(response.getBody());
            } else {
                logger.error("Failed to generate QR code: {}", response);
                return ResponseEntity.status(response.getStatusCode()).body(null);
            }
        } catch (Exception e) {
            logger.error("Error in getQrCode", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

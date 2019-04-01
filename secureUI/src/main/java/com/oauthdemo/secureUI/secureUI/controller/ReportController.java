package com.oauthdemo.secureUI.secureUI.controller;

import com.oauthdemo.secureUI.secureUI.domain.TollUsage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2ClientContext clientContext;

    @Autowired
    private OAuth2RestTemplate oAuth2RestTemplate;

    private Logger log = LoggerFactory.getLogger(ReportController.class);
    private String tollDataUrl = "http://localhost:9001/services/tolldata";

    @RequestMapping("/")
    public String loadHome(){
        return "home";
    }

    @RequestMapping("/report")
    public String getTollReport(Model model){
        OAuth2AccessToken token = clientContext.getAccessToken();
        log.info("Access Token "  + token.getValue());

        try {

            ResponseEntity<ArrayList<TollUsage>> responseEntity = oAuth2RestTemplate.exchange(tollDataUrl, HttpMethod.GET,
                    null, new ParameterizedTypeReference<ArrayList<TollUsage>>() {
                    });
            model.addAttribute("tolls",responseEntity.getBody());
        }
        catch (Exception ex){
            log.error(ex.getMessage());
        }

        return "report";
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:Off
        http
            .authorizeRequests()
                .antMatchers("/","login/**")
                .permitAll()
            .anyRequest()
                .authenticated();
        // @formatter:on

    }
}

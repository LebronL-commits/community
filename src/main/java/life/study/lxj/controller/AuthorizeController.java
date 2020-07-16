package life.study.lxj.controller;

import life.study.lxj.dto.AccessTokenDTO;
import life.study.lxj.dto.GithubUser;
import life.study.lxj.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8133/callback");
        accessTokenDTO.setClient_id("f28d362fac3b5bb64940");
        accessTokenDTO.setClient_secret("e2be604ab955f373a7f1fcca05ffe9a2a3870540");
        accessTokenDTO.setStatus(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}

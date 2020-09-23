package lmsbackendapp.backend.controller;

import lmsbackendapp.backend.model.RegUser;
import lmsbackendapp.backend.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@CrossOrigin(origins = {"http://localhost:4200"})
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    LoginService loginSrvc;
    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<HashMap<String ,String>> login(@RequestBody RegUser regUser){
        return loginSrvc.login(regUser);
    }
}

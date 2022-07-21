package br.csi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("index")
public class beforeLogin {
    @RequestMapping(value = "login", method = GET)
    public String fazerLogin(){
        return "login";
    }

    @RequestMapping(value = "criar", method = POST)
    public String criarConta(){
        return "criarConta";
    }
}

package br.csi.controller;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.usuario.Usuario;
import br.csi.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Controller
@RequestMapping("/index")
public class beforeLogin {
    @RequestMapping(value = "login", method = GET)
    public String fazerLogin(){
        return "login";
    }
   @PostMapping("/logar")
   public RedirectView logar(@RequestParam String email, String senha, HttpSession session){
        Usuario usuario = new UsuarioService().autenticado(email, senha);
        if (usuario != null) {
            session.setAttribute("usuario_logado", usuario);
        }
        return new RedirectView("/index/farmaciaIndex", true);
   }
   @GetMapping("/farmaciaIndex")
   public String farmaciaIndex(@ModelAttribute("farm")Farmacia farmacia) {
        return "farmaciaIndex";
   }
    @RequestMapping(value = "criar", method = GET)
    public String criarConta(Model model){
        model.addAttribute("user", new Usuario());
        return "criarConta";
    }

    @RequestMapping(value = "criar", method = POST)
    public String criarConta(@ModelAttribute("user") Usuario user){
        Usuario usuario = new UsuarioService().cadastro(user);
        return "login";
    }
}

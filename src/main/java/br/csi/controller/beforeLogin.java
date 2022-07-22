package br.csi.controller;
import br.csi.model.usuario.Usuario;
import br.csi.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @RequestMapping(value = "criar", method = GET)
    public String criarConta(Model model){
        model.addAttribute("user", new Usuario());
        return "criarConta";
    }
//    @RequestMapping(value = "criar", method = POST)
//    public String criarConta(@ModelAttribute("user") Usuario user, Model model){
//        String nome = (String) model.getAttribute("nomeUser");
//        String email = (String) model.getAttribute("emailUser");
//        String senha = (String) model.getAttribute("senhaUser");
//
//        Usuario newuser = new Usuario(nome, email, senha);
//        Usuario usuario = new UsuarioService().cadastro(newuser);
//
//
//        return "criarConta";
//    }
}

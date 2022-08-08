package br.csi.controller;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.usuario.Usuario;
import br.csi.service.FarmaciaService;
import br.csi.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Controller
@RequestMapping("/app")
public class afterLogin {

    @RequestMapping(value = "franquias", method = GET)
    public String listarFranquias(Model model){
        model.addAttribute("farmacias", new FarmaciaService().getFarm());
        return "farmaciaIndex";
    }
    @RequestMapping(value = "cadastrarFarm", method = POST)
    public RedirectView criarConta(@ModelAttribute("farm") Farmacia farmacia){
        //model.addAttribute("farmacia", new FarmaciaService().getFarm());
        RedirectView redirect = new RedirectView("/app_farm/app/franquias");
        Farmacia farm = new FarmaciaService().cadastrar(farmacia);
        return redirect;
    }

}

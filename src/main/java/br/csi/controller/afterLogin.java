package br.csi.controller;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.funcionario.Funcionario;
import br.csi.model.usuario.Usuario;
import br.csi.service.FarmaciaService;
import br.csi.service.FuncionarioService;
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

    //TODO:metodos da funcionario abaixo
    @RequestMapping(value ="funcionarios", method = GET)
    public String redirecionaFuncionarios(Model model){
        model.addAttribute("func", new Funcionario());
        return "funcionariosIndex";
    }
    @RequestMapping(value = "cadastrarFunc", method = POST)
    public RedirectView criarConta(@ModelAttribute("func") Funcionario funcionario){
        RedirectView redirect = new RedirectView("/app_farm/app/franquias");
        Funcionario func = new FuncionarioService().cadastrarFuncionario(funcionario);
        return redirect;
    }


    //TODO:metodos da farmacia abaixo
    final static RedirectView redirect = new RedirectView("/app_farm/app/franquias");
    @RequestMapping(value = "franquias", method = GET)
    public String listarFranquias(Model model){
        model.addAttribute("farmacias", new FarmaciaService().getFarm());
        return "farmaciaIndex";
    }
    @RequestMapping(value = "cadastrarFarm", method = POST)
    public RedirectView criarConta(@ModelAttribute("farm") Farmacia farmacia){
        Farmacia farm = new FarmaciaService().cadastrar(farmacia);
        RedirectView redirect = new RedirectView("/app_farm/app/franquias");
        return redirect;
    }
    @RequestMapping(value="excluir", method = GET)
    public RedirectView excluirFarmacia(int id_farmacia){
        Farmacia farm = new FarmaciaService().excluirFarmacia(id_farmacia);
        return redirect;
    }
}

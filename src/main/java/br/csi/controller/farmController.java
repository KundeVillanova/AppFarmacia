package br.csi.controller;

import br.csi.dao.FarmaciaDao;
import br.csi.dao.FuncionarioDao;
import br.csi.dao.ProdutoDao;
import br.csi.model.farmacia.Farmacia;
import br.csi.service.FarmaciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/farm")
public class farmController {

    @GetMapping("franquias")
    public String listarFranquias(Model model){
        model.addAttribute("farmacias", new FarmaciaService().getFarm());
        model.addAttribute("farm", new Farmacia());
        model.addAttribute("acao", "cadastrar");
        return "farmaciaIndex";
    }

    @PostMapping("cadastrar")
    public RedirectView criarFarm(@ModelAttribute Farmacia farm){
        RedirectView redirect = new RedirectView("/app_farm/farm/franquias");

        new FarmaciaDao().criarFarmacia(farm);

        return redirect;
    }

    @GetMapping("editar")
    public String editarFarm(@RequestParam int id_farm, Model model){
        RedirectView redirect = new RedirectView("/app_farm/farm/franquias");

        model.addAttribute("farmacias", new FarmaciaService().getFarm());
        model.addAttribute("farm", new FarmaciaDao().getFarmaciaUnica(id_farm));
        model.addAttribute("acao", "editar");

        return "farmaciaIndex";
    }

    @PostMapping(value = "editar")
    public RedirectView editFarm(@ModelAttribute Farmacia farm){
        RedirectView redirect = new RedirectView("/app_farm/farm/franquias");

        new FarmaciaDao().editar(farm);

        return redirect;
    }
    @GetMapping("excluir")
    public RedirectView excluirFarm(@RequestParam int id_farm){

        new FarmaciaDao().excluir(id_farm);

        return new RedirectView("/app_farm/farm/franquias");
    }

    @GetMapping("sair")
    public RedirectView sair(){

        return new RedirectView("/app_farm/index/login");
    }

    @GetMapping("irRelatorio")
    public String relatorio(@RequestParam int id_farm, Model model){

        model.addAttribute("prods", new ProdutoDao().getProdutos(id_farm));
        model.addAttribute("funcionarios", new FuncionarioDao().getFuncionarios2(id_farm));
        model.addAttribute("farmacia", new FarmaciaDao().getFarmaciaUnica(id_farm));

        return "relatorio";
    }

}
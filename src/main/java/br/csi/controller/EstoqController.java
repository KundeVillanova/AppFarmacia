package br.csi.controller;

import br.csi.dao.FarmaciaDao;
import br.csi.dao.FuncionarioDao;
import br.csi.dao.ProdutoDao;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.funcionario.Funcionario;
import br.csi.model.produto.Produto;
import br.csi.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/esto")
public class EstoqController {

    @GetMapping("irEstoque")
    public RedirectView estoque(@RequestParam int id_farm, HttpSession session){

        session.setAttribute("farmacia", new FarmaciaDao().getFarmaciaUnica(id_farm));

        return new RedirectView("/app_farm/esto/inicio");
    }

    @GetMapping("inicio")
    public String inicio(HttpSession session, Model model){

        Farmacia farma = (Farmacia) session.getAttribute("farmacia");

        model.addAttribute("prod", new Produto());
        model.addAttribute("acao", "cadastrar");
        model.addAttribute("prods", new ProdutoDao().getProdutos(farma.getId_farm()));

        return "estoqueIndex";
    }

    @PostMapping("cadastrar")
    public RedirectView criarConta(@ModelAttribute("func") Produto prod){
        RedirectView redirect = new RedirectView("/app_farm/esto/inicio");

        new ProdutoDao().setProduto(prod);

        return redirect;
    }

    @GetMapping("/editar")
    public String editPro(@RequestParam int id, Model model, HttpSession session){

        Farmacia farma = (Farmacia) session.getAttribute("farmacia");

        model.addAttribute("acao", "editar");
        model.addAttribute("prod", new ProdutoDao().getProdutoUnico(id));
        model.addAttribute("prods", new ProdutoDao().getProdutos(farma.getId_farm()));

        return "estoqueIndex";
    }

    @PostMapping("/editar")
    public RedirectView updPro(@ModelAttribute Produto prod){

        new ProdutoDao().editar(prod);

        return new RedirectView("/app_farm/esto/inicio");
    }

    @GetMapping("/excluir")
    public RedirectView delete(@RequestParam int id){

        new ProdutoDao().excluir(id);

        return new RedirectView("/app_farm/esto/inicio");
    }
}

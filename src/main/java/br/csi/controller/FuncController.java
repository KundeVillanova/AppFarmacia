package br.csi.controller;

import br.csi.dao.FarmaciaDao;
import br.csi.dao.FuncionarioDao;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.funcionario.Funcionario;
import br.csi.service.FuncionarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/func")
public class FuncController {

    @GetMapping("irFuncionario")
    public RedirectView inicio(@RequestParam int id_farm, HttpSession session){

        session.setAttribute("farmacia", new FarmaciaDao().getFarmaciaUnica(id_farm));

        return new RedirectView("/app_farm/func/funcionarios");
    }

    @GetMapping("funcionarios")
    public String funcionariosIndex(Model model, HttpSession session){

        Farmacia farma = (Farmacia) session.getAttribute("farmacia");

        System.out.println(farma.getId_farm());

        model.addAttribute("func", new Funcionario());
        model.addAttribute("acao", "cadastrar");
        model.addAttribute("funcionarios", new FuncionarioDao().getFuncionarios2(farma.getId_farm()));

        return "funcionariosIndex";
    }

    @PostMapping("cadastrar")
    public RedirectView criarConta(@ModelAttribute("func") Funcionario funcionario){
        RedirectView redirect = new RedirectView("/app_farm/func/funcionarios");
        new FuncionarioService().cadastrarFuncionario(funcionario);
        return redirect;
    }

    @GetMapping("/editar")
    public String editFun(@RequestParam int id, Model model, HttpSession session){

        Farmacia farma = (Farmacia) session.getAttribute("farmacia");

        model.addAttribute("acao", "editar");
        model.addAttribute("func", new FuncionarioDao().getFuncionarioUnico(id));
        model.addAttribute("funcionarios", new FuncionarioDao().getFuncionarios2(farma.getId_farm()));

        return "funcionariosIndex";
    }

    @PostMapping("/editar")
    public RedirectView updFun(@ModelAttribute Funcionario func){

        System.out.println(func.getNome_func());

        new FuncionarioDao().editar(func);

        return new RedirectView("/app_farm/func/funcionarios");
    }

    @GetMapping("/excluir")
    public RedirectView delete(@RequestParam int id){

        new FuncionarioDao().excluir(id);

        return new RedirectView("/app_farm/func/funcionarios");
    }
}

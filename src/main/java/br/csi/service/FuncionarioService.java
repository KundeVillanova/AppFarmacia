package br.csi.service;

import br.csi.dao.FuncionarioDao;
import br.csi.model.funcionario.Funcionario;

public class FuncionarioService {

    public Funcionario cadastrarFuncionario(Funcionario func){
        if(func.getNome_func() != "" && func.getTelefone() != "" && func.getData_nasc() != "") {
            Funcionario u = new FuncionarioDao().setFuncionario(func);
            return u;
        }
        return null;
    }

}

package br.csi.service;

import br.csi.dao.FarmaciaDao;
import br.csi.dao.UsuarioDao;
import br.csi.model.farmacia.Farmacia;
import br.csi.model.usuario.Usuario;

import java.util.ArrayList;

public class FarmaciaService {

    private FarmaciaDao dao = new FarmaciaDao();
    public Farmacia cadastrar(Farmacia farm){
        Farmacia f = new FarmaciaDao().criarFarmacia(farm);
        return f;
    }
    public ArrayList<Farmacia> getFarm() {
        return  dao.getFranquias();
    }
}

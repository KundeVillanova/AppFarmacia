package br.csi.service;

import br.csi.dao.FarmaciaDao;
import br.csi.model.farmacia.Farmacia;

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
    public Farmacia excluirFarmacia(int id_farm){
        dao.excluirFarm(id_farm);
        return null;
    }
}

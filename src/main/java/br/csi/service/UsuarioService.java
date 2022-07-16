package br.csi.service;

import br.csi.dao.UsuarioDao;
import br.csi.model.usuario.Usuario;

public class UsuarioService {

    public Usuario autenticado(String email, String senha) {
        if(email != "" && senha != ""){
            System.out.println(email);
        Usuario u = new UsuarioDao().getUsuario(email);
            System.out.println(email + senha);
            if (u != null) {
                if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                    return u;
                }
            }
    }
        return null;
    }
    public Usuario cadastro(Usuario user){

        System.out.println(user.getNome());
        System.out.println(user.getEmail());
        System.out.println(user.getSenha());

        if(user.getNome() != "" && user.getEmail() != "" && user.getSenha() != "") {
            System.out.println("ta indo");
            Usuario u = new UsuarioDao().setUsuario(user);
            return u;
        }
        return null;

    }
}

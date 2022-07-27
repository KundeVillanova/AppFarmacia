package br.csi.service;

import br.csi.dao.UsuarioDao;
import br.csi.model.usuario.Usuario;
public class UsuarioService {
    public Usuario autenticado(String email, String senha) {
        if(email != "" && senha != ""){
        Usuario u = new UsuarioDao().getUsuario(email);
            if (u != null) {
                if (u.getEmail().equals(email) && u.getSenha().equals(senha)) {
                    return u;
                }
            }
        }
        return null;
    }
    public Usuario cadastro(Usuario user){
        if(user.getNome() != "" && user.getEmail() != "" && user.getSenha() != "") {
            Usuario u = new UsuarioDao().criarUsuario(user);
            return u;
        }
        return null;
    }
}

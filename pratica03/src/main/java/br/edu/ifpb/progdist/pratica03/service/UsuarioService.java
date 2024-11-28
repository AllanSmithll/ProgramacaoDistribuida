package br.edu.ifpb.progdist.pratica02.service;

import br.edu.ifpb.progdist.pratica02.dao.UsuariosDAO;
import br.edu.ifpb.progdist.pratica02.model.Usuario;

import java.util.List;

public class UsuarioService {
    private UsuariosDAO usuariosDAO = new UsuariosDAO();

    public List<Usuario> getUsuarios() {
        return usuariosDAO.getUsuarios();
    }

    public Usuario getUsuarioPorCodigo(int codigo) {
        return usuariosDAO.getUsuarioPorCodigo(codigo);
    }

    public void inserirUsuario(Usuario usuario) {
        this.usuariosDAO.inserirUsuario(usuario);
    }
}

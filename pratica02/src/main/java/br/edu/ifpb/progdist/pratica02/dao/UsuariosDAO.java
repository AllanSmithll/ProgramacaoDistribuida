package br.edu.ifpb.progdist.pratica02.dao;

import br.edu.ifpb.progdist.pratica02.model.Usuario;

import java.util.List;
import java.util.ArrayList;

public class UsuariosDAO {
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public UsuariosDAO() {
        this.usuarios.add(new Usuario(1,"Ana",20));
        this.usuarios.add(new Usuario(2,"Carlos",30));
        this.usuarios.add(new Usuario(3,"João",25));
        this.usuarios.add(new Usuario(4,"José",18));
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public Usuario getUsuarioPorCodigo(int codigo) {
            for (Usuario usuario : usuarios) {
                if (usuario.getCodigo() == codigo) {
                    return usuario;
                }
            } return null;
    }

    public void inserirUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
}

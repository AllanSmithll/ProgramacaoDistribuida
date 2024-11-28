package br.edu.ifpb.progdist.pratica02.controller;

import br.edu.ifpb.progdist.pratica02.model.Usuario;
import br.edu.ifpb.progdist.pratica02.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("")
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{codigo}")
    public Usuario getUsuariosCodigo(@PathVariable("codigo") int codigo) {
        return this.usuarioService.getUsuarioPorCodigo(codigo);
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public Integer inserirUsuario(@RequestBody Usuario usuario) {
        this.usuarioService.inserirUsuario(usuario);
        return  usuario.getCodigo();
    }
}

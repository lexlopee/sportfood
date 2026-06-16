package com.lexlopee.sportfood.controller.usuario;

import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.service.usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuariooController {

    private final UsuarioService usuarioService;

    //Constructor
    public UsuariooController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //GET  api/v1/usuario -> lista todos
    @GetMapping
    public List<UsuarioEntity> findAll() {
        return usuarioService.findAll();
    }

    //GET api/v1/usuario/1 -> busca uno por id
    @GetMapping("/{id}")
    public UsuarioEntity findById(@PathVariable Integer id) {
        return usuarioService.findById(id);
    }

    //POST api/v1/usuario -> crea un usuario
    @PostMapping
    public UsuarioEntity save(@RequestBody UsuarioEntity usuario) {
        return usuarioService.save(usuario);
    }

    //DELETE api/v1/usuario/1 -> borra por id
    @DeleteMapping("/{id}")
    public void delete(Integer id) {
        usuarioService.delete(id);
    }

}

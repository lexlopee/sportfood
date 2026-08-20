package com.lexlopee.sportfood.controller.usuario;

import com.lexlopee.sportfood.dto.comida.ComidaResponseDTO;
import com.lexlopee.sportfood.dto.usuario.UsuarioResponseDTO;
import com.lexlopee.sportfood.entity.usuario.UsuarioEntity;
import com.lexlopee.sportfood.mapper.comida.ComidaMapper;
import com.lexlopee.sportfood.mapper.usuario.UsuarioMapper;
import com.lexlopee.sportfood.service.usuario.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsuariooController {

    private final UsuarioService usuarioService;
    private final UsuarioMapper usuarioMapper;
    private final ComidaMapper comidaMapper;


    //Constructor
    public UsuariooController(UsuarioService usuarioService, UsuarioMapper usuarioMapper, ComidaMapper comidaMapper) {
        this.usuarioService = usuarioService;
        this.usuarioMapper = usuarioMapper;
        this.comidaMapper = comidaMapper;
    }

    //GET  api/v1/usuario -> lista todos
    @GetMapping
    public List<UsuarioResponseDTO> findAll() {
        return usuarioService.findAll().stream()
                .map(usuarioMapper::toResponseDTO)
                .toList();
    }

    //GET api/v1/usuario/1 -> busca uno por id
    @GetMapping("/{id}")
    public UsuarioResponseDTO findById(@PathVariable Integer id) {
        return usuarioMapper.toResponseDTO(usuarioService.findById(id));
    }

    //POST api/v1/usuario -> crea un usuario
    @PostMapping
    public UsuarioResponseDTO save(@RequestBody UsuarioEntity usuario) {
        return usuarioMapper.toResponseDTO(usuarioService.save(usuario));
    }

    @PostMapping("/{id}/favorites")
    public UsuarioResponseDTO guardarComidaFavorita(@PathVariable("id") Integer id,
                                                    @RequestParam("idExterno") String idExterno){
        UsuarioEntity usuario = usuarioService.guardarComidaFavorita(id, idExterno);
        return usuarioMapper.toResponseDTO(usuario);
    }

    @GetMapping("/{id}/favorites")
    public List<ComidaResponseDTO> listarComidasFavoritas(@PathVariable("id") Integer id){
        return usuarioService.listarComidasFavoritas(id).stream()
                .map(comidaMapper::toResponseDTO)
                .toList();
    }

    //DELETE api/v1/usuario/1 -> borra por id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        usuarioService.delete(id);
    }

}

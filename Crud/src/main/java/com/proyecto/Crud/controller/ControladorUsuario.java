package com.proyecto.Crud.controller;

import com.proyecto.Crud.modelo.Miembros;
import com.proyecto.Crud.servicio.ServicioMiembros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class ControladorUsuario {

    private final ServicioMiembros servicioMiembros;

    @Autowired
    public ControladorUsuario(ServicioMiembros servicioMiembros) {
        this.servicioMiembros = servicioMiembros;
    }

    @GetMapping
    public List<Miembros> getTodoslosUsuarios(){
        return servicioMiembros.getUsuarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Miembros> getUsuarioById(@PathVariable Long id){
        Optional<Miembros> usuario = servicioMiembros.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Miembros crearUsuario(@RequestBody Miembros miembros){
        return servicioMiembros.crearUsuario(miembros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Miembros> actualizarUsuario(@PathVariable Long id, @RequestBody Miembros detallesMiembros){
        Optional<Miembros> usuario = servicioMiembros.actualizarUsuario(id, detallesMiembros);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> borrarUsuario(@PathVariable Long id){
        if(servicioMiembros.borrarUsuario(id)){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

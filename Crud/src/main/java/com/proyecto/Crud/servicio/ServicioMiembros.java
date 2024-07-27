package com.proyecto.Crud.servicio;

import com.proyecto.Crud.modelo.Miembros;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioMiembros {

    private List<Miembros> miembros = new ArrayList<>();
    private Long nextId = 1L;

    public List<Miembros> getUsuarios(){
        return miembros;
    }

    public Optional<Miembros> getUsuarioById(Long id) {
        return miembros.stream().filter(miembros -> miembros.getId.equals(id)).findFirst();
    }

    public Miembros crearUsuario(Miembros miembros){
        miembros.setId(nextId++);
        this.miembros.add(miembros);
        return miembros;
    }

    public Optional<Miembros> actualizarUsuario(Long id, Miembros detallesMiembros){
       return getUsuarioById(id).map(usuarios -> {
           usuarios.setNombre(detallesMiembros.getNombre());
           usuarios.setEmail(detallesMiembros.getEmail());
           return usuarios;
       });
    }

    public boolean borrarUsuario(Long id){
        return miembros.removeIf(miembros -> miembros.getId().equals(id));
    }

}

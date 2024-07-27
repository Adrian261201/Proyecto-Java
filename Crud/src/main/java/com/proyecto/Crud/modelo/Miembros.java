package com.proyecto.Crud.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Miembros {
    private Long id;
    private String nombre;
    private String email;
}

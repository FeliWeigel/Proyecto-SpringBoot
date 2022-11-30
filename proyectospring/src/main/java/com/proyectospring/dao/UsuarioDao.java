package com.proyectospring.dao;

import com.proyectospring.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    void registrar(Usuario usuario);
    Usuario dataCheck(Usuario usuario);
}

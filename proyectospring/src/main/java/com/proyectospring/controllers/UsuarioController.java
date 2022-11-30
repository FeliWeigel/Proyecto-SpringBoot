package com.proyectospring.controllers;

import com.proyectospring.dao.UsuarioDao;
import com.proyectospring.models.Usuario;
import com.proyectospring.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void registrarUsuarios(@RequestBody Usuario usuario){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024,1,usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String logearUsuario(@RequestBody Usuario usuario){
        Usuario usuarioLogin = usuarioDao.dataCheck(usuario);
        if(usuarioLogin != null){           //convierto id en string
            return jwtUtil.create(String.valueOf(usuarioLogin.getId()), usuarioLogin.getEmail());
        }

        return "fail";

    }
}

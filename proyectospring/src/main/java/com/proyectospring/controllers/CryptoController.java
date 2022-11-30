package com.proyectospring.controllers;

import com.proyectospring.dao.CryptoDao;
import com.proyectospring.models.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CryptoController {

    @Autowired
    private CryptoDao cryptoDao;

    @RequestMapping(value = "api/cryptos", method = RequestMethod.GET)
    public List<Crypto> getCryptos(){
        return cryptoDao.getCryptos();
    }

}

package com.proyectospring.dao;

import com.proyectospring.models.Crypto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CryptoDaoImp implements CryptoDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Crypto> getCryptos(){
        String query = "FROM Crypto";
        return entityManager.createQuery(query).getResultList();
    }


}

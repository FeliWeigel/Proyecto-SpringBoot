package com.proyectospring.dao;

import com.proyectospring.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository // Acceder a los repositorios de nuestra base de datos MYSQL
@Transactional // Forma en la que se efectuara la conexion y flujo de datos (transacciones)
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext//Delimita el alcance de las transacciones
    private EntityManager entityManager; //Gestiona las entidades(automatiza la persistencia de los objetos). Maneja las operaciones CRUD(Insertar, borrar, etc).

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario); //".merge" se usa para insertar una entidad al contexto o actualizar la información de una entidad ya manejada, como respuesta se obtiene la entidad manejada.
    }

    @Override
    public Usuario dataCheck(Usuario usuario){
        String query = "FROM Usuario WHERE email = :email";
        List<Usuario> dataList = entityManager.createQuery(query).setParameter("email", usuario.getEmail()).getResultList();

        if(dataList.isEmpty()){
            return null;
        }

        String passwordHashed = dataList.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(passwordHashed, usuario.getPassword())){
            return dataList.get(0);
        }
        return null;
    }
}
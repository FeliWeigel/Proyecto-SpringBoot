package com.proyectospring.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity //Le indico que esta clase conformara una identidad de mi BD
@Table(name = "users")//Le indico a que tabla hace referencia
@ToString @EqualsAndHashCode //Etiquetas que se usan siempre, Equals es utilizado en colecciones(List, Set) para determinar si un objeto ya esta incluido, Hashcode se usa en los Map para encontrar el objeto a traves de la clave
public class Usuario {

    public Usuario() {

    }

    @Getter @Setter @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "apellido")
    private String apellido;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "password")
    private String password;



}

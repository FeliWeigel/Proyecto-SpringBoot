package com.proyectospring.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "cryptos")
@EqualsAndHashCode@ToString
public class Crypto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter@Setter@Column(name = "id")
    private long id;
    @Getter@Setter@Column(name = "nombre")
    private String nombre;
    @Getter@Setter@Column(name = "descripcion")
    private String descripcion;
    @Getter@Setter@Column(name = "logo")
    private String logo;
    @Getter@Setter@Column(name = "simbolo")
    private String simbolo;
}

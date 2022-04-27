package edu.pucp.gtics.lab4_gtics_20221.entity;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Table(name = "juegos")
public class Juegos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idjuego;

    @Size(min = 3,max = 45,message = "El mensaje debe contener entre 3 y 45 caracteres")
    private String nombre;

    @Size(min = 3,max = 400,message = "La descripcion debe contener entre 3 y 400 caracteres")
    private String descripcion;

    @Digits(integer = 10,fraction = 4)
    @Min(value = 10,message = "El valor debe ser mayor que 10")
    @Max(value = 500,message = "El valor dene ser menor a 500")
    private double precio;

    @Size(min=3,message = "El url debe tener mas de 3 caracteres")
    @URL(message = "Debe ser un url valido")
    private String image;

    @ManyToOne
    @JoinColumn(name = "idplataforma")
    @NotNull(message = "Plataforma no puede ser nulo")
    private Plataformas plataforma;

    @ManyToOne
    @JoinColumn(name = "iddistribuidora")
    @NotNull(message = "Distribuidora no puede ser nulo")
    private Distribuidoras distribuidora;

    @ManyToOne
    @JoinColumn(name = "idgenero")
    @NotNull(message = "Genero no puede ser nulo")
    private Generos genero;

    public int getIdjuego() {
        return idjuego;
    }

    public void setIdjuego(int idjuego) {
        this.idjuego = idjuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Plataformas getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataformas plataforma) {
        this.plataforma = plataforma;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Distribuidoras getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(Distribuidoras distribuidora) {
        this.distribuidora = distribuidora;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }
}

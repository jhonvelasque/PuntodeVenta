/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEAN;

import java.util.Vector;

/**
 *
 * @author carlo
 */
public class Categoria_producto {

    private int id_categoria ;
    private String categoria ;
    private int subcategoria ;
    private String marca;
    private String modelo ;
    private String descripcion ;

    public int getId_categoria() {
        return id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getSubcategoria() {
        return subcategoria;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Categoria_producto() {
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setSubcategoria(int subcategoria) {
        this.subcategoria = subcategoria;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}

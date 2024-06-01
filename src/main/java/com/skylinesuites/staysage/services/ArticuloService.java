package com.skylinesuites.staysage.services;

import com.skylinesuites.staysage.entities.ArticulosEntity;

import java.util.List;

public interface ArticuloService {
    List<ArticulosEntity> listarArticulos();
    void agregarArticulo(ArticulosEntity articulo);
    void eliminarArticulo(long id);
    void actualizarArticulo(ArticulosEntity articulo);
    ArticulosEntity buscarArticulo(long id);
    boolean articuloExiste(String nombreArticulo);
}

package com.skylinesuites.staysage.services.impl;

import com.skylinesuites.staysage.entities.ArticulosEntity;
import com.skylinesuites.staysage.repositories.ArticuloRepository;
import com.skylinesuites.staysage.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    ArticuloRepository articulosRepository;
    @Override
    public List<ArticulosEntity> listarArticulos() {
        return articulosRepository.findAll();
    }

    @Override
    public void agregarArticulo(ArticulosEntity articulo) {
        articulosRepository.save(articulo);
    }

    @Override
    public void eliminarArticulo(long id) {
        articulosRepository.deleteById(id);
    }

    @Override
    public void actualizarArticulo(ArticulosEntity articulo) {
        articulosRepository.save(articulo);
    }

    @Override
    public ArticulosEntity buscarArticulo(long id) {
        return articulosRepository.findById(id).orElse(null);
    }

    @Override
    public boolean articuloExiste(String nombreArticulo) {
        return false;
    }
}

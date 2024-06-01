package com.skylinesuites.staysage.controllers;

import com.skylinesuites.staysage.entities.ArticulosEntity;
import com.skylinesuites.staysage.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;
    @GetMapping("/articulos")
    public String articulos(Model model) {
        model.addAttribute("pagina", "articulos");
        model.addAttribute("articulos", articuloService.listarArticulos());
        return "pages/articulos";
    }

    @PostMapping("/articulos")
    public String articulosPost(@ModelAttribute ArticulosEntity articulos){
        articuloService.agregarArticulo(articulos);
        return "redirect:/articulos";
    }

    @GetMapping("/articulos/ver-todos")
    public String verTodos(Model model) {
        model.addAttribute("articulos", articuloService.listarArticulos());
        return "pages/total-articulos";
    }

    @GetMapping("/articulos/ver-todos/editar/{id}")
    public String editarArticulo(@ModelAttribute ArticulosEntity articulo, Model model){
        model.addAttribute("articulo", articuloService.buscarArticulo(articulo.getId()));
        return "pages/editar-articulo";
    }

    @PostMapping("/articulos/ver-todos/editar/{id}")
    public String editarArticulo(@ModelAttribute ArticulosEntity articulo){
        ArticulosEntity articuloActual = articuloService.buscarArticulo(articulo.getId());
        if (articuloActual != null){
            articuloActual.setId(articulo.getId());
            articuloActual.setNombreArticulo(articulo.getNombreArticulo());
            articuloActual.setDescripcion(articulo.getDescripcion());
            articuloActual.setCantidad(articulo.getCantidad());
            articuloService.agregarArticulo(articuloActual);
            return "redirect:/articulos/ver-todos";
        } else {
            return "redirect:/total-articulos?errorArticuloNoExiste";
        }
    }

    @GetMapping("/articulos/ver-todos/eliminar/{id}")
    public String eliminarArticulo(@ModelAttribute ArticulosEntity articulo){
        articuloService.eliminarArticulo(articulo.getId());
        return "redirect:/articulos/ver-todos";
    }
}

package com.example.ejemplo.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo.modelos.Productos;
import com.example.ejemplo.Services.ProductosDb;

@RestController
public class ProductosController {

    @GetMapping("/productos/all")
    public List<Productos> ObtenerProductos() {
        return new ProductosDb().ObtenerProductos();
    }

    @DeleteMapping("/producto/{productoId}")
    public int Delete(@PathVariable("productoId") int pid) {
        return new ProductosDb().EliminarProducto(pid);
    }

    @PostMapping("/producto")
    public int InsertarProducto(@RequestBody Productos productos) {
        return new ProductosDb().GuardarProductos(productos);
    }

    @PutMapping("/producto")
    public int ActualizarProducto(@RequestBody Productos productos) {
        return new ProductosDb().ActualizarProducto(productos);
    }
}

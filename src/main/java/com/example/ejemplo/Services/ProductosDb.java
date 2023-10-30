package com.example.ejemplo.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.ejemplo.modelos.*;

public class ProductosDb {
  Connection cn;

  public ProductosDb() {
    cn = new Conexion().openDb();
  }

  public List<Productos> ObtenerProductos() {

    try {
      Statement stmt = cn.createStatement();
      String query = "SELECT * FROM productos";

      List<Productos> productos = new ArrayList<>();
      ResultSet result = stmt.executeQuery(query);
      while (result.next()) {
        Productos producto = new Productos(
            result.getInt("id"),
            result.getString("nombre"),
            result.getFloat("precio"),
            result.getInt("categoria_id"),
            result.getString("fotoUrl"),
            result.getString("fecha_preparacion"),
            result.getString("fecha_expiracion"));

        productos.add(producto);
      }

      result.close();
      stmt.close();
      return productos;

    } catch (Exception e) {
      int x = 1;
    }
    return null;
  }

  public int GuardarProductos(Productos producto) {
    int resultado = 0;

    try {
      Statement stm = cn.createStatement();
      String query = "Call InsertarProducto('"
          + producto.getNombre() + "',"
          + producto.getPrecio() + ","
          + producto.getCategoriaId() + ",'"
          + producto.getFoto() + "','"
          + producto.getFecha_preparacion() + "','"
          + producto.getFecha_expiracion() + "')";

      resultado = stm.executeUpdate(query);

      return resultado;
    } catch (Exception e) {
      int x = 1;
    }
    return resultado;
  }

  public int EliminarProducto(int pid) {
    int resultado = 0;

    try {
      Statement stmt = cn.createStatement();
      String query = "Call EliminarProducto(" + pid + ")";

      return stmt.executeUpdate(query);
    } catch (Exception e) {
      int x = 1;
    }
    return resultado;
  }

  public int ActualizarProducto(Productos producto) {
    int resultado = 0;
    try {
      Statement stm = cn.createStatement();
      String query = "Call ActualizarProducto("
          + producto.getId() + ",'"
          + producto.getNombre() + "',"
          + producto.getPrecio() + ","
          + producto.getCategoriaId() + ",'"
          + producto.getFoto() + "','"
          + producto.getFecha_preparacion() + "','"
          + producto.getFecha_expiracion() + "')";

      resultado = stm.executeUpdate(query);

      return resultado;
    } catch (Exception e) {
      int x = 1;
    }
    return resultado;
  }
}
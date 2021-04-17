package com.macowins;

import com.macowins.prendas.Prenda;

public class Item {
  private Prenda prenda;
  private int cantidad;

  public Item(Prenda prenda, int cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public double getTotal() {
    return prenda.getPrecioFinal() * cantidad;
  }

  public Prenda getPrenda() {
    return prenda;
  }

  public void setPrenda(Prenda prenda) {
    this.prenda = prenda;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}

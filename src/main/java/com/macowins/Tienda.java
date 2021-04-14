package com.macowins;

import java.util.Date;
import java.util.List;

public class Tienda {
  private List<Venta> ventas;

  public Tienda(List<Venta> ventas) {
    this.ventas = ventas;
  }

  public double gananciasDelDia(Date dia){
    return ventas.stream()
        .filter(venta -> venta.getFecha().compareTo(dia) == 0)
        .map(Venta::getTotalVenta)
        .reduce(0.0, Double::sum);
  }

  public List<Venta> getVentas() {
    return ventas;
  }

  public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
  }
}

package com.macowins;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

public class Tienda {
  private List<Venta> ventas;

  public Tienda() {
    this.ventas = new ArrayList<>();
  }

  public double gananciasDelDia(Date dia){
    return ventas.stream()
        .filter(esDeLaFecha(dia))
        .map(Venta::getTotalVenta)
        .reduce(0.0, Double::sum);
  }

  public void agregarVenta(Venta venta){
    ventas.add(venta);
  }

  private Predicate<Venta> esDeLaFecha(Date dia) {
    return venta -> venta.getFecha().compareTo(dia) == 0;
  }

  public List<Venta> getVentas() {
    return ventas;
  }

  public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
  }
}

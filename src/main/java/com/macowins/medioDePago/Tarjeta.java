package com.macowins.medioDePago;

import com.macowins.prendas.Prenda;

import java.util.List;

public class Tarjeta implements MedioDePago{
  private int cantidadCuotas;
  private double recargo;

  public Tarjeta(int cantidadCuotas, double recargo) {
    this.cantidadCuotas = cantidadCuotas;
    this.recargo = recargo;
  }

  @Override
  public double calcularTotal(List<Prenda> prendas) {
    return cantidadCuotas * recargo + prendas.stream()
        .map(prenda -> prenda.getValor() + 0.01).reduce(0.0, Double::sum);
  }
}

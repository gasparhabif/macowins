package com.macowins.medioDePago;

import com.macowins.prendas.Prenda;

import java.util.List;

public class Efectivo implements MedioDePago{

  @Override
  public double calcularTotal(List<Prenda> prendas) {
    return prendas.stream().map(Prenda::getValor).reduce(0.0, Double::sum);
  }
}

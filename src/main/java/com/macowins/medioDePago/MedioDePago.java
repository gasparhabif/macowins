package com.macowins.medioDePago;

import com.macowins.prendas.Prenda;

import java.util.List;

public interface MedioDePago {
  double calcularTotal(List<Prenda> prendas);
}

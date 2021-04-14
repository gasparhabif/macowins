package com.macowins.prendas;

import com.macowins.prendas.estados.EstadoPrenda;

public class Prenda {
  private double valor;
  private EstadoPrenda estado;

  public Prenda(double valor, EstadoPrenda estado) {
    this.valor = valor;
    this.estado = estado;
  }

  public EstadoPrenda getEstado() {
    return estado;
  }

  public void setEstado(EstadoPrenda estado) {
    this.estado = estado;
  }

  public double getValor() {
    return estado.modificarPrecio(valor);
  }

  public void setValor(double valor) {
    this.valor = valor;
  }
}

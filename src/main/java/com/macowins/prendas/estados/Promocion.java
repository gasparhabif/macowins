package com.macowins.prendas.estados;

public class Promocion implements EstadoPrenda{
  private double descuento;

  public Promocion(double descuento) {
    this.descuento = descuento;
  }

  public double getDescuento() {
    return descuento;
  }

  public void setDescuento(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public double modificarPrecio(double valor) {
    return valor - descuento;
  }
}

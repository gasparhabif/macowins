package com.macowins.prendas.estados;

public class Liquidacion implements EstadoPrenda {
  private static final double DESCUENTO = 50;

  @Override
  public double modificarPrecio(double valor) {
    return valor - (valor * DESCUENTO / 100);
  }
}

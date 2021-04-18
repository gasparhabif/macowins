package ar.edu.utn.frba.dds.macowins.medioDePago;

import ar.edu.utn.frba.dds.macowins.Item;

public class Tarjeta extends MedioDePago{
  private int cantidadCuotas;
  private double recargo;

  public Tarjeta(int cantidadCuotas, double recargo) {
    this.cantidadCuotas = cantidadCuotas;
    this.recargo = recargo;
  }

//  (cantidad de cuotas * un coeficiente fijo + 0.01 del valor de cada prenda)
  public double aplicarRecargo(Item item) {
    return (cantidadCuotas * recargo) +
            (0.01 * super.aplicarRecargo(item) + super.aplicarRecargo(item));
  }
}

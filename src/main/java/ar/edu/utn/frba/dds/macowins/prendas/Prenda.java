package ar.edu.utn.frba.dds.macowins.prendas;

import ar.edu.utn.frba.dds.macowins.prendas.estados.EstadoPrenda;

public class Prenda {
  private double precio;
  private EstadoPrenda estado;
  private TipoDePrenda tipoDePrenda;

  public Prenda(double precio, EstadoPrenda estado, TipoDePrenda tipoDePrenda) {
    this.precio = precio;
    this.estado = estado;
    this.tipoDePrenda = tipoDePrenda;
  }

  public double getPrecioFinal() {
    return this.estado.modificarPrecio(this.precio);
  }

  public EstadoPrenda getEstado() {
    return estado;
  }

  public void setEstado(EstadoPrenda estado) {
    this.estado = estado;
  }

  public double getPrecio() {
    return this.precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public TipoDePrenda getTipoDePrenda() {
    return tipoDePrenda;
  }

  public void setTipoDePrenda(TipoDePrenda tipoDePrenda) {
    this.tipoDePrenda = tipoDePrenda;
  }
}

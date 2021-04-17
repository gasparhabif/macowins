package com.macowins;

import com.macowins.medioDePago.MedioDePago;

import java.util.Date;
import java.util.List;

public class Venta {
  private List<Item> itemsComprados;
  private Date fecha;
  private MedioDePago medioDePago;

  public Venta(List<Item> itemsComprados, Date fecha, MedioDePago medioDePago) {
    this.itemsComprados = itemsComprados;
    this.fecha = new Date(fecha.getTime());
    this.medioDePago = medioDePago;
  }

  public double getTotalVenta() {
    return this.itemsComprados.stream()
        .map(item -> this.medioDePago.aplicarRecargo(item))
        .reduce(0.0, Double::sum);
  }

  public List<Item> getItemsComprados() {
    return itemsComprados;
  }

  public void setItemsComprados(List<Item> itemsComprados) {
    this.itemsComprados = itemsComprados;
  }

  public Date getFecha() {
    return new Date(this.fecha.getTime());
  }

  public void setFecha(Date fecha) {
    this.fecha = new Date(fecha.getTime());
  }

  public MedioDePago getMedioDePago() {
    return medioDePago;
  }

  public void setMedioDePago(MedioDePago medioDePago) {
    this.medioDePago = medioDePago;
  }
}

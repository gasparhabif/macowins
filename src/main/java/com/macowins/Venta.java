package com.macowins;

import com.macowins.medioDePago.MedioDePago;
import com.macowins.prendas.Prenda;

import java.util.Date;
import java.util.List;

public class Venta {
  private List<Prenda> prendas;
  private Date fecha;
  private MedioDePago medioDePago;

  public Venta(List<Prenda> prendas, Date fecha, MedioDePago medioDePago) {
    this.prendas = prendas;
    this.fecha = fecha;
    this.medioDePago = medioDePago;
  }

  public double getTotalVenta() {
    return this.medioDePago.calcularTotal(this.prendas);
  }

  public List<Prenda> getPrendas() {
    return prendas;
  }

  public void setPrendas(List<Prenda> prendas) {
    this.prendas = prendas;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public MedioDePago getMedioDePago() {
    return medioDePago;
  }

  public void setMedioDePago(MedioDePago medioDePago) {
    this.medioDePago = medioDePago;
  }
}

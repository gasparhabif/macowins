package ar.edu.utn.frba.dds.macowins.medioDePago;

import ar.edu.utn.frba.dds.macowins.Item;

public class MedioDePago {
  public double aplicarRecargo(Item item) {
    return item.getTotal();
  };
}

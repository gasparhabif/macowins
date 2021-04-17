package com.macowins.medioDePago;

import com.macowins.Item;

public class MedioDePago {
  public double aplicarRecargo(Item item) {
    return item.getPrenda().getPrecioFinal();
  };
}

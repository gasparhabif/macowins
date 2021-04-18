package ar.edu.utn.frba.dds.macowins.prendas.estados;

public class Nuevo implements EstadoPrenda {
  public Nuevo() {
  }

  @Override
  public double modificarPrecio(double valor) {
    return valor;
  }
}

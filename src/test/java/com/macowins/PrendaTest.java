package com.macowins;

import com.macowins.prendas.Prenda;
import com.macowins.prendas.TipoDePrenda;
import com.macowins.prendas.estados.Liquidacion;
import com.macowins.prendas.estados.Nuevo;
import com.macowins.prendas.estados.Promocion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrendaTest {
    @Test
    public void elTipoDeUnaCamisaNuevaEsCAMISA() {
        assertEquals(camisaNueva(200).getTipoDePrenda().toString(), "CAMISA");
    }

    @Test
    public void elTipoDeUnSacoEnLiquidacionEsSACO() {
        assertEquals(sacoEnLiquidacion(200).getTipoDePrenda().toString(), "SACO");
    }

    @Test
    public void elPrecioDeUnaCamisaNuevaEsSuPrecioBase() {
        assertEquals(camisaNueva(4000).getPrecioFinal(), 4000, 0);
        assertEquals(camisaNueva(5000).getPrecioFinal(), 5000, 0);
    }

    @Test
    public void elPrecioDeUnSacoEnLiquidacionEsSuLaMitadDeSuPrecioBase() {
        assertEquals(sacoEnLiquidacion(3000).getPrecioFinal(), 1500, 0);
        assertEquals(sacoEnLiquidacion(8000).getPrecioFinal(), 4000, 0);
    }

    @Test
    public void elPrecioDeUnPantalonEnPromocionEsSuPrecioBaseMenosSuDecuento() {
        assertEquals(pantalonEnPromocion(1500, 200).getPrecioFinal(), 1300, 0);
        assertEquals(pantalonEnPromocion(1500, 100).getPrecioFinal(), 1400, 0);
    }

    private Prenda pantalonEnPromocion(int precioBase, int descuento) {
        return new Prenda(precioBase, new Promocion(descuento), TipoDePrenda.PANTALON);
    }


    private Prenda camisaNueva(double precioBase) {
        return new Prenda(precioBase, new Nuevo(), TipoDePrenda.CAMISA);
    }

    private Prenda sacoEnLiquidacion(double precioBase) {
        return new Prenda(precioBase, new Liquidacion(), TipoDePrenda.SACO);
    }

}

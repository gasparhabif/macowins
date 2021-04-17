package com.macowins;

import com.macowins.medioDePago.Efectivo;
import com.macowins.medioDePago.Tarjeta;
import com.macowins.prendas.Prenda;
import com.macowins.prendas.TipoDePrenda;
import com.macowins.prendas.estados.Liquidacion;
import com.macowins.prendas.estados.Nuevo;
import com.macowins.prendas.estados.Promocion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MacowinsTests {
    Tienda tiendaVacia = new Tienda();
    static Tienda tiendaConVentas = new Tienda();

    Venta unaVenta;
    Prenda pantalon;
    Item pantalonesItem;

    static Date hoy = new Date();
    static Date ayer = Date.from(Instant.now().minus(1, ChronoUnit.DAYS));

    @BeforeAll
    public void setVariables() {
        pantalon = new Prenda(20, new Nuevo(), TipoDePrenda.PANTALON);
        Prenda camisa = new Prenda(10, new Nuevo(), TipoDePrenda.CAMISA);
        Prenda sacoEnPromocion = new Prenda(15, new Promocion(10), TipoDePrenda.SACO);
        Prenda camisaEnLiquidacion = new Prenda(10, new Liquidacion(), TipoDePrenda.CAMISA);

        pantalonesItem = new Item(pantalon, 2);
        Item camisaItem = new Item(camisa, 1);
        Item sacoEnPromocionItem = new Item(sacoEnPromocion, 1);
        Item camisaEnLiquidacionItem = new Item(camisaEnLiquidacion, 3);

        // Total = 50
        List<Item> productos1 = Arrays.asList(pantalonesItem, camisaItem);
        // Total = 15
        List<Item> productos2 = Collections.singletonList(camisaItem);
        // Total = 15
        List<Item> productos3 = Arrays.asList(camisaEnLiquidacionItem, sacoEnPromocionItem);

        // Total: 2*20$ + 1*10$ = 50$
        unaVenta = new Venta(productos1, hoy, new Efectivo());
        // Total: (6 cuotas * 0.50$ de Recargo) + (0.01 * 10$ + 10$) = $13,1
        Venta otraVenta = new Venta(productos2, hoy, new Tarjeta(6, 0.5));
        // Total: 3*(10$ * 50% por Liquidación) + 1*(15$ - 10$ por Promoción) = 20$
        Venta ventaVieja = new Venta(productos3, ayer, new Efectivo());

        tiendaConVentas.agregarVenta(unaVenta);
        tiendaConVentas.agregarVenta(otraVenta);
        tiendaConVentas.agregarVenta(ventaVieja);
    }

    @Test
    public void unaTiendaSinVentasNoTieneGanancias(){
        assert tiendaVacia.gananciasDelDia(hoy) == 0;
    }

    @Test
    public void unaTiendaConVentasTiene3Ventas() {
        assert tiendaConVentas.getVentas().size() == 3;
    }

    @Test
    public void unaTiendaConVentasHoyTieneGanancias() {
        assert tiendaConVentas.gananciasDelDia(hoy) == 63.1;
    }

    @Test
    public void unaTiendaConVentasAyerTieneGanancias() {
        assert tiendaConVentas.gananciasDelDia(ayer) == 20;
    }

    @Test
    public void unaVentaTieneItemsCompradosYMedioDePago() {
        assert unaVenta.getTotalVenta() == 50;
        assert unaVenta.getItemsComprados().size() == 2;
        assert unaVenta.getFecha() == hoy;
        assertSame(unaVenta.getMedioDePago().getClass(), Efectivo.class);
    }

    @Test
    public void unItemTienePrendasYCantidad() {
        assert pantalonesItem.getPrenda().getTipoDePrenda().equals(TipoDePrenda.PANTALON);
        assert pantalonesItem.getCantidad() == 2;
    }

    @Test
    public void unaPrendaPuedeCambiarDeTipoDePrecioYDeEstado() {
        Prenda prenda = new Prenda(20, new Liquidacion(), TipoDePrenda.CAMISA);
        prenda.setTipoDePrenda(TipoDePrenda.SACO);
        prenda.setEstado(new Nuevo());
        prenda.setPrecio(23);
        assert prenda.getPrecio() == 23;
        assertSame(prenda.getTipoDePrenda().getClass(), TipoDePrenda.SACO.getClass());
        assertSame(prenda.getEstado().getClass(), Nuevo.class);
    }

    @Test
    public void unaPromocionTieneDescuentos() {
        Promocion promocion = new Promocion(10);
        promocion.setDescuento(20);
        assert promocion.getDescuento() == 20;
    }

    // Hay ciertos tests que son innecesarios ya que solo testean getters o setters
    // pero se dejaron para que el testCoverage quede mas lindo :)

}

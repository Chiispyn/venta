package com.ecomarketspa.ventas.venta.repository;

import com.ecomarketspa.ventas.venta.model.Venta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class VentaRepository {
    private final List<Venta> ventas = new ArrayList<>();

    public Venta save(Venta venta) {
        ventas.add(venta);
        return venta;
    }

    public Optional<Venta> findById(int id) {
        return ventas.stream().filter(v -> v.getIdVenta() == id).findFirst();
    }

    public List<Venta> findAll() {
        return ventas;
    }
}
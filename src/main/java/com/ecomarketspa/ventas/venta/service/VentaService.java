package com.ecomarketspa.ventas.venta.service;

import com.ecomarketspa.ventas.venta.model.Venta;
import com.ecomarketspa.ventas.venta.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    public Venta crearVenta(Venta venta) {
        if (venta.validarStock()) {
            venta.aplicarDesc(10); // Ejemplo: Aplicar descuento fijo
            return ventaRepository.save(venta);
        }
        throw new RuntimeException("Stock insuficiente");
    }

    public List<Venta> obtenerTodas() {
        return ventaRepository.findAll();
    }

    public Venta obtenerPorId(int id) {
        return ventaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
    }
}
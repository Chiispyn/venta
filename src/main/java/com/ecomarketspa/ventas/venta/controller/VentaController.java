package com.ecomarketspa.ventas.venta.controller;

import com.ecomarketspa.ventas.venta.model.Venta;
import com.ecomarketspa.ventas.venta.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ventas")
@Validated
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> crearVenta(@Valid @RequestBody Venta venta) {
        Venta ventaGuardada = ventaService.crearVenta(venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaGuardada);
    }

    @GetMapping
    public List<Venta> obtenerTodas() {
        return ventaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Venta obtenerPorId(@PathVariable int id) {
        return ventaService.obtenerPorId(id);
    }
}
package com.ecomarketspa.ventas.venta.model;

import java.util.Date;

import com.ecomarketspa.ventas.venta.model.enums.MedioEnvio;
import com.ecomarketspa.ventas.venta.model.enums.MedioPago;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@ToString
@Data
@Setter
@EqualsAndHashCode
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @NotNull(message = "El ID de venta es obligatorio")
    @Min(value = 1, message = "El ID de venta debe ser mayor o igual a 1")
    private int idVenta;

    @FutureOrPresent(message = "La fecha de venta no puede ser anterior a hoy")
    private Date fechaVenta;

    @DecimalMin(value = "0.01", message = "El total de venta debe ser mayor a 0")
    private float totalVenta;

    @NotNull(message = "El ID del pedido es obligatorio")
    @Min(value = 1, message = "El ID del pedido debe ser mayor o igual a 1")
    private int idPedido;

    @NotNull(message = "El ID del cliente es obligatorio")
    @Min(value = 1, message = "El ID del cliente debe ser mayor o igual a 1")
    private int idCliente;

    @NotNull(message = "El ID del usuario es obligatorio")
    @Min(value = 1, message = "El ID del usuario debe ser mayor o igual a 1")
    private int idUsuario;

    @NotBlank(message = "La descripción es obligatoria")
    private String desc;

    @NotNull(message = "El método de pago es obligatorio")
    private MedioPago metodoPago;

    @NotNull(message = "El método de envío es obligatorio")
    private MedioEnvio metodoEnvio;

    public void aplicarDesc(int descuento) {
        totalVenta -= descuento; // Aplica el descuento al total
    }

    public boolean validarStock() {
        return idPedido > 0; // Simula que hay stock si el ID del pedido es válido
    }
}
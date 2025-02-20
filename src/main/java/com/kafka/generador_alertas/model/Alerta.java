package com.kafka.generador_alertas.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ALERTAS")
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ALERTA_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    private Paciente paciente;

    @Column(name = "TIPO_ALERTA", nullable = false)
    private String alertType; // Ej.: "Hipoxia", "Taquicardia"

    @Column(name = "ESTADO", nullable = false)
    private String status; // "En Curso" o "Resuelta"

    @Column(name = "FECHA_HORA", nullable = false)
    private LocalDateTime timestamp;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPatient() {
        return paciente;
    }

    public void setPatient(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getAlertType() {
        return alertType;
    }

    public void setAlertType(String alertType) {
        this.alertType = alertType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

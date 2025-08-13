package br.com.mottu.mottuapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class MotoRequestDTO {

    @NotBlank
    private String placa;

    @NotBlank
    private String modelo;

    @NotBlank
    private String marca;

    @NotNull
    private Boolean ligada;

    private Integer coordenadaX;
    private Integer coordenadaY;

    @NotNull
    private Long patioId;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Boolean getLigada() {
        return ligada;
    }

    public void setLigada(Boolean ligada) {
        this.ligada = ligada;
    }

    public Integer getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Integer coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Integer getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Integer coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public Long getPatioId() {
        return patioId;
    }

    public void setPatioId(Long patioId) {
        this.patioId = patioId;
    }

}

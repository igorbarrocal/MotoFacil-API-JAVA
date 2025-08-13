package br.com.mottu.mottuapi.dto;

import jakarta.validation.constraints.NotBlank;

public class PatioRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O endereço é obrigatório")
    private String endereco;

    private Integer tamanhoX;
    private Integer tamanhoY;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getTamanhoX() {
        return tamanhoX;
    }

    public void setTamanhoX(Integer tamanhoX) {
        this.tamanhoX = tamanhoX;
    }

    public Integer getTamanhoY() {
        return tamanhoY;
    }

    public void setTamanhoY(Integer tamanhoY) {
        this.tamanhoY = tamanhoY;
    }
}

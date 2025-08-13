package br.com.mottu.mottuapi.dto;

public class PatioResponseDTO {

    private Long id;
    private String nome;
    private String endereco;
    private Integer tamanhoX;
    private Integer tamanhoY;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

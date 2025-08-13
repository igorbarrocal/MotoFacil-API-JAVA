package br.com.mottu.mottuapi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    private Integer tamanhoX;
    private Integer tamanhoY;

    @OneToMany(mappedBy = "patio", cascade = CascadeType.ALL)
    private List<Moto> motos;

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

    public List<Moto> getMotos() {
        return motos;
    }

    public void setMotos(List<Moto> motos) {
        this.motos = motos;
    }

}

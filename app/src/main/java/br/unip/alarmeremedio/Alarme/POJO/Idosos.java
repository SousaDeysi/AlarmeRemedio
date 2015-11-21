package br.unip.alarmeremedio.Alarme.POJO;

import java.io.Serializable;

public class Idosos implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String nome_idoso;
    private String imagem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_idoso() {
        return nome_idoso;
    }

    public void setNome_idoso(String nome_idoso) {
        this.nome_idoso = nome_idoso;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}


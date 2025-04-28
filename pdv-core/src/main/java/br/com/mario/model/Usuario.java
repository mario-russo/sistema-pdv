package br.com.mario.model;

import java.time.LocalDateTime;

public class Usuario {
    private Integer id;
    private String nome;
    private String permissao;
    private String status;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimoLogin;
    private String senhaHash;

    // Construtor
    public Usuario(String nome, String permissao, String status, String senhaHash) {
        this.nome = nome;
        this.permissao = permissao;
        this.status = status;
        this.senhaHash = senhaHash;
        this.dataCriacao = LocalDateTime.now();
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", permissao=" + permissao + ", status=" + status + "]";
    }
}

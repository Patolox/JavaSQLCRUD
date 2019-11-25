/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author titof
 */
public class pessoa {
    
    private int id;
    private String nome;
    private int telefone;
    private int cpf;

    public pessoa() {
    }

    public pessoa(int id, String nome, int telefone, int cpf) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "pessoa{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", cpf=" + cpf + '}';
    }
    
    
    
}

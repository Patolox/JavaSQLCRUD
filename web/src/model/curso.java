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
public class curso {
    
    private int matricula;
    private String nome;

    public curso() {
    }

    public curso(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "curso{" + "matricula=" + matricula + ", nome=" + nome + '}';
    }
    
    
    
}

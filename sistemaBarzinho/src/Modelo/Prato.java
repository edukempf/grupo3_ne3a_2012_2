/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Juliana
 */
public class Prato {

    @Id
    @GeneratedValue
    private int id;
    @Column(length = 100)
    private String nome;
    @Column(length = 6, precision = 2)
    private double preco;
//    @ManyToOne(cascade=Comida)
    private Comida ingredientes;
    @Column(length = 5)
    private int quantidadePorcoes;
    
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Comida getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Comida ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getQuantidadePorcoes() {
        return quantidadePorcoes;
    }

    public void setQuantidadePorcoes(int quantidadePorcoes) {
        this.quantidadePorcoes = quantidadePorcoes;
    }

    
}

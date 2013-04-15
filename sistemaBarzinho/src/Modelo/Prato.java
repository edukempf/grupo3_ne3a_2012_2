/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Juliana
 */
@Entity
public class Prato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 100)
    private String nome;
    @Column(length = 6, precision = 2)
    private double preco;
    @ManyToMany(fetch = FetchType.EAGER)@Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Comida> ingredientes;
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

    public List<Comida> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Comida> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public int getQuantidadePorcoes() {
        return quantidadePorcoes;
    }

    public void setQuantidadePorcoes(int quantidadePorcoes) {
        this.quantidadePorcoes = quantidadePorcoes;
    }
}

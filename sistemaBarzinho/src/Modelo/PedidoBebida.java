/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Eduardo
 */
@Entity
public class PedidoBebida implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMesa")
    private Mesa idMesa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFuncionario")
    private Funcionario idFuncionario;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @IndexColumn(name = "id")
    private List<Bebida> bebidas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.idMesa = idMesa;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }
}

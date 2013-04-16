/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 *
 * @author Eduardo
 */


@MappedSuperclass
public abstract class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
     @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMesa")
    private Mesa idMesa;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idFuncionario")
    private Funcionario idFuncionario;
    
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
    
}

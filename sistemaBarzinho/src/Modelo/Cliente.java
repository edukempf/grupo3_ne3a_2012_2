/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author Juliana
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 100)
    private String nome;    
    @Column(length=11)
    private String cpf;
    
    @Column(length=20)
    private String rg;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNasc;
    
    @Column(length=15)
    private String estadoCivil;
    
    @Transient
    @ManyToOne
    @JoinColumn(name = "idMesa") 
    private Mesa idMesa; 

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Mesa getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Mesa idMesa) {
        this.idMesa = idMesa;
    }
    

    
}

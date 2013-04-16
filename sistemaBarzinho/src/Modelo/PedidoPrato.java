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
import javax.persistence.ManyToMany;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Eduardo
 */
@Entity
public class PedidoPrato extends Pedido implements Serializable {

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @IndexColumn(name="id")
    private List<Prato> pratos;

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nicolas
 */
public class Modalite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_modalite;
    @Column
    private String type;
    
    public Modalite(int id_modalite, String type){
        this.id_modalite=id_modalite;
        this.type=type;
}

    public int getId_modalite() {
        return id_modalite;
    }

    public void setId_modalite(int id_modalite) {
        this.id_modalite = id_modalite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
     @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modalite)) {
            return false;
        }
        Modalite other = (Modalite) object;
        if (this.id_modalite != other.id_modalite) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id_modalite;
        return hash;
    }
}

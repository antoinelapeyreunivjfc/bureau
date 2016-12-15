/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nicolas
 */
@Entity
@XmlRootElement
public class UF implements Serializable {
    @Id
    private int code_UF;
    @Column
    private String nom_UF;
    
    /*Commande SQL pour remplir la base :
    INSERT INTO `bureau`.`UF` (`code_UF`, `nom_UF`) VALUES ('1', 'Gastro-enterologie'), ('2', 'Diabétologie'), ('3', 'Pneumologie'), ('4', 'Oncologie'), ('5', 'Orthopédie'), ('6', 'Soins paliatifs'), ('7', 'Kinésithérapie'), ('8', 'Consultations médicales'), ('9', 'Radiothérapie');
    */

    public int getCode_UF() {
        return code_UF;
    }

    public void setCode_UF(int code_UF) {
        this.code_UF = code_UF;
    }

    public String getNom_UF() {
        return nom_UF;
    }

    public void setNom_UF(String nom_UF) {
        this.nom_UF = nom_UF;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UF)) {
            return false;
        }
        UF other = (UF) object;
        if (this.code_UF != other.code_UF) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) code_UF;
        return hash;
    }
}

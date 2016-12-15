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
public class CCAM implements Serializable {
    @Id
    private String code_CCAM;
    @Column
    private String libelle;
    @Column
    private String cout;
    
    /*Commande SQL pour remplir la base :
    INSERT INTO `bureau`.`CCAM` (`code_CCAM`, `cout`, `libelle`) VALUES ('ZBQK002', '20', 'Radiographie du thorax'), ('ZCQK002', '20', 'Radiographie de l\'abdomen sans préparation'), ('EAQH002', '20', 'Scanographie des vaisseaux encéphaliques'), ('EBQH006', '20', 'Scanographie des vaisseaux cervicaux'), ('ZZQN002', '20', 'Restitution tridimensionnelle des images acquises par remnographie'), ('AAQN004', '20', 'Remnographhie fonctionnelle du cerveau pour étude des fonctions motrices');
    */

    public String getCode_CCAM() {
        return code_CCAM;
    }

    public void setCode_CCAM(String code_CCAM) {
        this.code_CCAM = code_CCAM;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCout() {
        return cout;
    }

    public void setCout(String cout) {
        this.cout = cout;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CCAM)) {
            return false;
        }
        CCAM other = (CCAM) object;
        if (this.code_CCAM != other.code_CCAM) {
            return false;
        }
        return true;
    }
    
    /*@Override
    public int hashCode() {
        int hash = 0;
        hash += (int) code_CCAM;
        return hash;
    }*/
}

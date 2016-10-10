/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 *
 * @author Nicolas
 */
public class CCAM implements Serializable {
    @Id
    private int code_CCAM;
    @Column
    private String libelle;
    @Column
    private String cout;
    
    public CCAM(int code_CCAM, String libelle, String cout){
        this.code_CCAM=code_CCAM;
        this.libelle=libelle;
        this.cout=cout;
    }

    public int getCode_CCAM() {
        return code_CCAM;
    }

    public void setCode_CCAM(int code_CCAM) {
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) code_CCAM;
        return hash;
    }
}

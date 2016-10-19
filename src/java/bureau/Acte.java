/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Skip
 */
@Entity
@XmlRootElement
public class Acte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_acte;
    
    @Column
    String date;
    
    @Column
    String heure;
    
    @Column
    int IEP;
    
    @Column
    int code_UF;
    
    @Column
    int id_modalite;
    
    @Column
    int code_CCAM;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Images> images;

    public int getId_acte() {
        return id_acte;
    }

    public void setId_acte(int id_acte) {
        this.id_acte = id_acte;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getIEP() {
        return IEP;
    }

    public void setIEP(int IEP) {
        this.IEP = IEP;
    }

    public int getCode_UF() {
        return code_UF;
    }

    public void setCode_UF(int code_UF) {
        this.code_UF = code_UF;
    }

    public int getId_modalite() {
        return id_modalite;
    }

    public void setId_modalite(int id_modalite) {
        this.id_modalite = id_modalite;
    }

    public int getCode_CCAM() {
        return code_CCAM;
    }

    public void setCode_CCAM(int code_CCAM) {
        this.code_CCAM = code_CCAM;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
    
    
    
}

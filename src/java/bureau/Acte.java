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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Skip
 */
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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    String IEP;
    
    @Column
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    String code_UF;
    
    @Column
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    String id_modalite;
    
    @Column
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    String code_CCAM;
    
    @Column
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Images> images;

    public Acte(String date, String heure, String IEP, String code_UF, String id_modalite, String code_CCAM, List<Images> images) {
        this.date = date;
        this.heure = heure;
        this.IEP = IEP;
        this.code_UF = code_UF;
        this.id_modalite = id_modalite;
        this.code_CCAM = code_CCAM;
        this.images = images;
    }
    
    

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

    public String getIEP() {
        return IEP;
    }

    public void setIEP(String IEP) {
        this.IEP = IEP;
    }

    public String getCode_UF() {
        return code_UF;
    }

    public void setCode_UF(String code_UF) {
        this.code_UF = code_UF;
    }

    public String getId_modalite() {
        return id_modalite;
    }

    public void setId_modalite(String id_modalite) {
        this.id_modalite = id_modalite;
    }

    public String getCode_CCAM() {
        return code_CCAM;
    }

    public void setCode_CCAM(String code_CCAM) {
        this.code_CCAM = code_CCAM;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }
    
    
    
}

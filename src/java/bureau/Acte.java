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
    private int id;
    
    @Column
    String date;
    
    @Column
    String heure;
    
    @ManyToOne
    Admission admission;
    
    @ManyToOne
    UF uf;
    
    @ManyToOne
    Modalite modalite;
    
    @ManyToOne
    CCAM ccam;
    
    @OneToMany
    List<Images> images;
    
    @Column
    boolean passage_pp;
    
    @Column
    boolean passage_factu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public UF getUF() {
        return uf;
    }

    public void setUF(UF uf) {
        this.uf = uf;
    }

    public Modalite getModalite() {
        return modalite;
    }

    public void setModalite(Modalite modalite) {
        this.modalite = modalite;
    }

    public CCAM getCCAM() {
        return ccam;
    }

    public void setCCAM(CCAM ccam) {
        this.ccam = ccam;
    }

    public List<Images> getImages() {
        return images;
    }

    public void setImages(List<Images> images) {
        this.images = images;
    }

    public boolean getPassage_pp() {
        return passage_pp;
    }

    public void setPassage_pp(boolean passage_pp) {
        this.passage_pp = passage_pp;
    }

    public boolean getPassage_factu() {
        return passage_factu;
    }

    public void setPassage_factu(boolean passage_factu) {
        this.passage_factu = passage_factu;
    }
    
    
    
}

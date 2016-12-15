/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Charline
 */
@Entity
@XmlRootElement
public class Admission implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int IEP;
   
    @Column
    String nom_patient;
 
    @Column
    String prenom_patient;
    
    @Column
    String IPP_patient;
    
    @OneToMany
    List<Acte> actes;

    public int getIEP() {
        return IEP;
    }

    public String getNom_patient() {
        return nom_patient;
    }

    public String getPrenom_patient() {
        return prenom_patient;
    }

    public String getIPP_patient() {
        return IPP_patient;
    }

    public List<Acte> getActes() {
        return actes;
    }

    public void setIEP(int IEP) {
        this.IEP = IEP;
    }

    public void setNom_patient(String nom_patient) {
        this.nom_patient = nom_patient;
    }

    public void setPrenom_patient(String prenom_patient) {
        this.prenom_patient = prenom_patient;
    }

    public void setIPP_patient(String IPP_Patient) {
        this.IPP_patient = IPP_Patient;
    }

    public void setActes(List<Acte> actes) {
        this.actes = actes;
    }


}

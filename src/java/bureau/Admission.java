/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Charline
 */
public class Admission implements Serializable {
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private String IEP;
   
 @Column
 private String nom_patient;
 
 private String prenom_patient;
 private String IPP_patient;
 List<Acte> actes;


    public String getIEP() {
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

    public void setIEP(String IEP) {
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

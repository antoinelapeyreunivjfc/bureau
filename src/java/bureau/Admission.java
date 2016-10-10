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
 private String IPP_Patient;
 
List liste_actes=new ArrayList() ;


    public String getIEP() {
        return IEP;
    }

    public String getNom_patient() {
        return nom_patient;
    }

    public String getPrenom_patient() {
        return prenom_patient;
    }

    public String getIPP_Patient() {
        return IPP_Patient;
    }

    public List getListe_actes() {
        return liste_actes;
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

    public void setIPP_Patient(String IPP_Patient) {
        this.IPP_Patient = IPP_Patient;
    }

    public void setListe_actes(List liste_actes) {
        this.liste_actes = liste_actes;
    }


}

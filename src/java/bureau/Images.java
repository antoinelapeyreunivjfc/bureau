/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Charline
 */
@Entity
@XmlRootElement
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_image;
    
    @Column
    private String file_image;
    
    @ManyToOne
    Acte acte;

    public int getId_image() {
        return id_image;
    }

    public String getFile_image() {
        return file_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public void setFile_image(String file_image) {
        this.file_image = file_image;
    }

    public Acte getActe() {
        return acte;
    }

    public void setActe(Acte acte) {
        this.acte = acte;
    }
   
}

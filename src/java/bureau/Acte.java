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
    Date date;
    
    @Column
    Date heure;
    
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
    List<Image> images;
    
}

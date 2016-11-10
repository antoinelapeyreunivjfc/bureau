/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bureau.Boite;
import bureau.Crayon;
import bureau.DatabaseUtils;
import bureau.Services;
import bureau.Acte;
import bureau.Admission;
import bureau.CCAM;
import bureau.Modalite;
import bureau.UF;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nicolas Singer <Nicolas.Singer@gmail.com>
 */
public class bureauTest {
    
    static EntityManagerFactory fact;
    
    public bureauTest() {
       
    }
    
    @BeforeClass
    public static void setUpClass() {
         //fact = Persistence.createEntityManagerFactory("bureauPU");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //fact.close();
    }
    
    @Before
    public void setUp() {
       
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    
    public void clean() {
        Services serv = new Services(DatabaseUtils.fact());
        //serv.deleteAllBoites();
        //serv.deleteAllCrayons();
        //List<Crayon> res = serv.getAllCrayons();
        //assert(res.isEmpty());
      serv.deleteAllAdmission();
       List<Admission> res1=serv.getAllAdmission();
       assert(res1.isEmpty());
        serv.deleteAllActes();
        List<Acte> res = serv.getAllActes();
        assert(res.isEmpty());
        
    }
    
        
    /*@Test
    public void crayon() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        Crayon cr = serv.newCrayon("vert");
        assertNotNull(cr); 
        cr = serv.newCrayon("jaune");
        assertNotNull(cr);
        cr = serv.newCrayon("vert");
        assertNotNull(cr);
        List<Crayon> res = serv.getCrayonsByCouleurId("vert");
        assert(!res.isEmpty());
        assert(res.size() == 2);
      
        res = serv.getAllCrayons();
        assert(!res.isEmpty());
        assert(res.size() == 3);
        
    }
    
    @Test
    public void boite() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        List<Crayon> liste = new ArrayList<>();
        String[] couleurs = { "rouge", "jaune", "vert" };
        for (String c : couleurs) {
            Crayon cr = new Crayon();
            cr.setCouleur(c);
            liste.add(cr);
        }
        Boite b = serv.newBoite(liste);
        assertNotNull(b);
        
        List<Boite> boites = serv.getBoitesByCouleurDeCrayon("vert");
        assert(!boites.isEmpty());
        assert(!boites.get(0).getCrayons().isEmpty());
        System.out.println(boites.get(0).getCrayons().get(2).getCouleur());
        assert(boites.get(0).getCrayons().size() == 3);
        
    }
    
    @Test
    public void boite2() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        
        List<Crayon> liste = new ArrayList<>();
        String[] couleurs = { "rouge", "jaune", "vert" };
        for (String c : couleurs) {
            Crayon cr = new Crayon();
            cr.setCouleur(c);
            liste.add(cr);
        }
        Boite b = serv.newBoite(liste);
        assertNotNull(b);
        
        Crayon cr = new Crayon();
        cr.setCouleur("vert");
        
        b.getCrayons().add(cr);
        
        
        List<Boite> boites = serv.getBoitesByCouleurDeCrayon("vert");
        assert(!boites.isEmpty());
        assert(!boites.get(0).getCrayons().isEmpty());
        assert(boites.get(0).getCrayons().size() == 4);
        
        serv.updateBoite(b);
        
        
    }*/
    
    @Test
    public void acte() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        Admission ad1 = serv.newAdmission("Jean", "Jacques", "12", null);
        UF uf1 = serv.newUF(10, "Chirurgie");
        Modalite mod1 = serv.newModalite("Scanner");
        CCAM ccam1 = serv.newCCAM(3, "quelque chose", "autre chose");
        Acte ac1 = serv.newActe("10/10/2016", "10h54", ad1, uf1, mod1, ccam1, null);
        //Acte ac2 = serv.newActe("19/10/2016", "11h51", "456", "12", "48", "55", null);
        assertNotNull(ac1);
        //assertNotNull(ac2);
        
        Acte res1 = serv.getActesById(ac1.getId_acte());
        System.out.println(res1.getDate() + " " + res1.getHeure());
        System.out.println("C'EST LÀ : " + res1.getAdmission().getNom_patient());
        /*Acte res2 = serv.getActesById(ac2.getId_acte());
        System.out.println(res2.getDate() + " " + res2.getHeure());*/
      
        List<Acte> res3 = serv.getAllActes();
        System.out.println(res3.size());
    }
    
   /*@Test
    public void admission() {
        clean();
        Services serv = new Services(DatabaseUtils.fact());
        Admission ad = serv.newAdmission("George", "Jacque", "12", null);
        assertNotNull(ad); 
        
        Admission res = serv.getAdmissionByIEP(ad.getIEP());
       
       System.out.println(res.getNom_patient()+ ""+ res.getPrenom_patient());
      
        
        
    }*/
    
}

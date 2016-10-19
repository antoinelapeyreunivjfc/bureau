/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bureau;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author Nicolas Singer <Nicolas.Singer@gmail.com>
 */
public class Services {
    
    EntityManagerFactory fact;
    EntityManager em;

    public Services(EntityManagerFactory fact) {
        this.fact = fact;
        this.em = fact.createEntityManager();
    }
    
    
    public void close() {
        em.close();
    }
    public void newCrayon(Crayon cr) {
	em.getTransaction( ).begin( );
        em.persist(cr);
        em.getTransaction().commit();
    }

    public Crayon newCrayon(String couleur) {
        Crayon p = new Crayon();
        p.setCouleur(couleur);
     
	em.getTransaction( ).begin( );
        em.persist(p);
        em.getTransaction().commit();
      
        return p;
    }
    
    public void removeCrayon(int id) {
       
        Crayon cr = em.find( Crayon.class, id );
	em.getTransaction( ).begin( );
        em.remove(cr);
        em.getTransaction().commit();
       
    }
    
    public void deleteBoite(int id) {
       
        Boite b = em.find( Boite.class, id );
	em.getTransaction( ).begin( );
        em.remove(b);
        em.getTransaction().commit();
       
    }
  
    public void editCrayon(Crayon cr) {
      
	em.getTransaction( ).begin( );
        em.merge(cr);
        em.getTransaction().commit();
     
    }
    
    public Crayon getCrayonsById(int id) {
       
	Crayon res = em.find( Crayon.class, id );
      
        return res;
    }
    
    public List<Crayon> getAllCrayons() {
	TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c", Crayon.class);
        List<Crayon> res = query.getResultList();
        return res;
    }
    
     public List<Crayon> getAllCrayonsSansBoite() {
        // va chercher la liste des crayons qui ne sont pas affectés à une boite, cad les crayons pour lesquels
        // il n'existe pas de boite les contenant. D'où la requête.
	TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c WHERE  NOT EXISTS (SELECT b FROM Boite b, IN (b.crayons) cr WHERE cr = c)", Crayon.class);
        List<Crayon> res = query.getResultList();
        return res;
    }
    
    public List<Boite> getAllBoites() {
      
	TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b", Boite.class);
        List<Boite> res = query.getResultList();
      
        return res;
    }
    
    public List<Crayon> getCrayonsByCouleurId(String couleur) {
     
        TypedQuery<Crayon> query = em.createQuery("SELECT c FROM Crayon c WHERE c.couleur = :couleur", Crayon.class)
                .setParameter("couleur",couleur);
        List<Crayon> res = query.getResultList();
     
        return res;
    }
    
    public Boite newBoite(List<Crayon> crayons) {
        Boite b = new Boite();
	em.getTransaction( ).begin( );
        b.setCrayons(crayons);
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }
    
    public Boite newBoite(Boite b) {
	em.getTransaction( ).begin( );
        em.persist(b);
        em.getTransaction().commit();
        return b;
    }
    
    public void updateBoite(Boite b) {
        em.getTransaction( ).begin( );
        em.merge(b);
        em.getTransaction().commit();
    }
    
    public Boite getBoiteById(int id) {
        
	Boite res = em.find( Boite.class, id );
       
        return res;
    }
    
    public List<Boite> getBoitesByCouleurDeCrayon(String couleur) {
       
        TypedQuery<Boite> query = em.createQuery("SELECT b FROM Boite b JOIN b.crayons c WHERE c.couleur = :couleur", Boite.class)
                .setParameter("couleur",couleur);
        List<Boite> res =  query.getResultList();
       
        return res;
    }
    
    public void deleteAllBoites() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Boite").executeUpdate();
        em.getTransaction().commit();
        
    }
    
    public void deleteAllCrayons() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Crayon").executeUpdate();
        em.getTransaction().commit();
        
    }
    
    public Acte getActesById(int id) {
       
	Acte res = em.find( Acte.class, id );
      
        return res;
    }
    
    public List<Acte> getAllActes() {
	TypedQuery<Acte> query = em.createQuery("SELECT a FROM Acte a", Acte.class);
        List<Acte> res = query.getResultList();
        return res;
    }
    
    public void newActe(Acte ac) {
	em.getTransaction( ).begin( );
        em.persist(ac);
        em.getTransaction().commit();
    }
    
    public Acte newActe(String date, String heure, String IEP, String code_UF, String id_modalite, String code_CCAM, List<Images> images) {
        Acte ac = new Acte();
        ac.setDate(date);
        ac.setHeure(heure);
        ac.setIEP(IEP);
        ac.setCode_UF(code_UF);
        ac.setId_modalite(id_modalite);
        ac.setCode_CCAM(code_CCAM);
        ac.setImages(images);
     
	em.getTransaction( ).begin( );
        em.persist(ac);
        em.getTransaction().commit();
      
        return ac;
    }
    
    public void editActe(Acte ac) {
      
	em.getTransaction( ).begin( );
        em.merge(ac);
        em.getTransaction().commit();
     
    }
    
    public void removeActe(int id) {
       
        Acte ac = em.find( Acte.class, id );
	em.getTransaction( ).begin( );
        em.remove(ac);
        em.getTransaction().commit();
       
    }
     public void deleteAllActes() {
      
        em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Acte").executeUpdate();
        em.getTransaction().commit();
        
    }
     public Admission getAdmissionByIEP(String IEP) {
       
	Admission res = em.find( Admission.class, IEP );
      
        return res;
    }
    
    public List<Admission> getAllAdmission() {
	TypedQuery<Admission> query = em.createQuery("SELECT ad FROM Admission ad", Admission.class);
        List<Admission> res = query.getResultList();
        return res;
    }
    
    public Admission newAdmission(Admission ad) {
	em.getTransaction( ).begin( );
        em.persist(ad);
        em.getTransaction().commit();
        return ad;
    }
     public Admission newAdmission(String IEP, String nom_patient,String prenom_patient,String IPP_patient, List<Acte> actes) {
        Admission ad = new Admission();
	em.getTransaction( ).begin( );
        ad.setIEP(IEP);
        ad.setNom_patient(nom_patient);
        ad.setPrenom_patient(prenom_patient);
        ad.setIPP_patient(IPP_patient);
        ad.setActes(actes);
        em.persist(ad);
        em.getTransaction().commit();
        return ad;
    }
    
    
    public void editAdmission(Admission ad) {
      
	em.getTransaction( ).begin( );
        em.merge(ad);
        em.getTransaction().commit();
     
    }
    
    public void removeAdmission(int IEP) {
       
        Admission ac = em.find( Admission.class, IEP );
	em.getTransaction( ).begin( );
        em.remove(ac);
        em.getTransaction().commit();
       
    }
    public void deleteAllAdmission (){
         em.getTransaction( ).begin( );
        em.createQuery("DELETE FROM Admission").executeUpdate();
        em.getTransaction().commit();
        
    }
    

  
}

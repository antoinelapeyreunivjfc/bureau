
package bureau;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Nicolas Singer
 */
@Path("generic")
public class RestServices {

    @Context
    private UriInfo context;
    
    Services serv;

    public RestServices() {
        serv = new Services(DatabaseUtils.fact());
    }


    @GET
    @Path("crayons/{id}")
    @Produces("application/json")
    public Crayon getCrayons(@PathParam("id") int id) {
        return serv.getCrayonsById(id);
    }
    
    @GET
    @Path("crayons")
    @Produces("application/json")
    public List<Crayon> getAllCrayons(@DefaultValue("") @QueryParam("type") String type ) {
        if (type.equals("sansboites"))
            return serv.getAllCrayonsSansBoite();
        else return serv.getAllCrayons();
    }

    
    
    @POST
    @Path("crayons")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Crayon newCrayon(Crayon cr) {
        serv.newCrayon(cr);
        System.out.println("id:"+cr.getId());
        return cr;
    }
    
    @POST
    @Path("crayons/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCrayon(Crayon cr) {
        serv.editCrayon(cr);
        return Response.status(200).entity(cr).build();
    }
    
    @DELETE
    @Path("crayons/{id}")
    public Response removeCrayon(@PathParam("id") int id) {
        serv.removeCrayon(id);
        return Response.status(200).build();
    }

    @GET
    @Path("boites")
    @Produces("application/json")
    public List<Boite> getBoites() {
        return serv.getAllBoites();
    }
    
    @GET
    @Path("boites/{id}")
    @Produces("application/json")
    public Boite getBoite(@PathParam("id") int id) {
        return serv.getBoiteById(id);
    }
    
    @POST
    @Path("boites")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Boite newBoite(Boite b) {
        return serv.newBoite(b);

    }
    
    @POST
    @Path("boites/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editBoite(Boite b) {
        serv.updateBoite(b);
        return Response.status(200).entity(b).build();
    }
    
    @DELETE
    @Path("boites/{id}")
    public Response removeBoite(@PathParam("id") int id) {
        serv.deleteBoite(id);
        return Response.status(200).build();
    }

    @GET
    @Path("actes/{id}")
    @Produces("application/json")
    public Acte getActes(@PathParam("id") int id) {
        return serv.getActesById(id);
    }
    
    @GET
    @Path("actes")
    @Produces("application/json")
    public List<Acte> getAllActes(){
        return serv.getAllActes();
    }
    
    @POST
    @Path("actes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Acte newActe(Acte ac) {
        serv.newActe(ac);
        System.out.println("id:"+ac.getId_acte());
        return ac;
    }
    
    @POST
    @Path("actes/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editActe(Acte ac) {
        serv.editActe(ac);
        return Response.status(200).entity(ac).build();
    }
    
    @DELETE
    @Path("actes/{id}")
    public Response removeActe(@PathParam("id") int id) {
        serv.removeActe(id);
        return Response.status(200).build();
    }
    
    @GET
    @Path("admission/{IEP}")
    @Produces("application/json")
    public Admission getAdmission(@PathParam("IEP") int IEP) {
        return serv.getAdmissionByIEP(IEP);   }
    
    @GET
    @Path("admission")
    @Produces("application/json")
    public List<Admission> getAllAdmission(){
        return serv.getAllAdmission();
    }
    
    @POST
    @Path("admission")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Admission newAdmission(Admission ad) {
        serv.newAdmission(ad);
        System.out.println("IEP:"+ad.getIEP());
        return ad;
    }
    
    @POST
    @Path("admission/{IEP}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editAdmission(Admission ad) {
        serv.editAdmission(ad);
        return Response.status(200).entity(ad).build();
    }
    
    @DELETE
    @Path("admission/{IEP}")
    public Response removeAdmission(@PathParam("IEP") int IEP) {
        serv.removeAdmission(IEP);
        return Response.status(200).build();
    }
    
    @GET
    @Path("ccam/{id}")
    @Produces("application/json")
    public CCAM getCCAM(@PathParam("id") int id) {
        return serv.getCCAMByCode(id);
    }
    
    @GET
    @Path("ccam")
    @Produces("application/json")
    public List<CCAM> getAllCCAM(){
        return serv.getAllCCAM();
    }
    
    @POST
    @Path("ccam")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public CCAM newCCAM(CCAM ccam) {
        serv.newCCAM(ccam);
        System.out.println("id:"+ccam.getCode_CCAM());
        return ccam;
    }
    
    @POST
    @Path("ccam/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editCCAM(CCAM ccam) {
        serv.editCCAM(ccam);
        return Response.status(200).entity(ccam).build();
    }
    
    @DELETE
    @Path("ccam/{id}")
    public Response removeCCAM(@PathParam("id") int id) {
        serv.removeCCAM(id);
        return Response.status(200).build();
    }
    
    @GET
    @Path("images/{id}")
    @Produces("application/json")
    public Images getImage(@PathParam("id") int id) {
        return serv.getImageById(id);
    }
    
    @GET
    @Path("images")
    @Produces("application/json")
    public List<Images> getAllImages(){
        return serv.getAllImages();
    }
    
    @POST
    @Path("images")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Images newImage(Images im) {
        serv.newImage(im);
        System.out.println("id:"+im.getId_image());
        return im;
    }
    
    @POST
    @Path("images/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editImage(Images im) {
        serv.editImage(im);
        return Response.status(200).entity(im).build();
    }
    
    @DELETE
    @Path("images/{id}")
    public Response removeImage(@PathParam("id") int id) {
        serv.removeImage(id);
        return Response.status(200).build();
    }
    
    @GET
    @Path("modalite/{id}")
    @Produces("application/json")
    public Modalite getModalite(@PathParam("id") int id) {
        return serv.getModaliteById(id);
    }
    
    @GET
    @Path("modalite")
    @Produces("application/json")
    public List<Modalite> getAllModalites(){
        return serv.getAllModalites();
    }
    
    @POST
    @Path("modalite")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Modalite newModalite(Modalite mod) {
        serv.newModalite(mod);
        System.out.println("id:"+mod.getId_modalite());
        return mod;
    }
    
    @POST
    @Path("modalite/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editModalite(Modalite mod) {
        serv.editModalite(mod);
        return Response.status(200).entity(mod).build();
    }
    
    @DELETE
    @Path("modalite/{id}")
    public Response removeModalite(@PathParam("id") int id) {
        serv.removeModalite(id);
        return Response.status(200).build();
    }
    
    @GET
    @Path("uf/{id}")
    @Produces("application/json")
    public UF getUF(@PathParam("id") int id) {
        return serv.getUFByCode(id);
    }
    
    @GET
    @Path("uf")
    @Produces("application/json")
    public List<UF> getAllUF(){
        return serv.getAllUF();
    }
    
    @POST
    @Path("uf")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public UF newUF(UF uf) {
        serv.newUF(uf);
        System.out.println("id:"+uf.getCode_UF());
        return uf;
    }
    
    @POST
    @Path("uf/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editUF(UF uf) {
        serv.editUF(uf);
        return Response.status(200).entity(uf).build();
    }
    
    @DELETE
    @Path("uf/{id}")
    public Response removeUF(@PathParam("id") int id) {
        serv.removeUF(id);
        return Response.status(200).build();
    }
    
}

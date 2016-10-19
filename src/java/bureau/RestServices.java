
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
    public Admission getAdmission(@PathParam("IEP") String IEP) {
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
    
}

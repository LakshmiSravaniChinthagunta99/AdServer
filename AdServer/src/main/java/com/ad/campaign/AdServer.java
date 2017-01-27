package com.ad.campaign;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/AdServer")
public class AdServer {
	public static AdServerManager manager = new AdServerManager();
	
	 @GET
	   @Path("/listallad")
	   @Produces(MediaType.APPLICATION_XML)
	   public List<AdVO> getAd(){
		 System.out.println("getAd called....");
		 manager.removeExpiredAds();
	      return manager.listAddAds();
	   }	
	 
	 @GET
	    @Path("/{param}")
	    public AdVO getMsg(@PathParam("param") String partnerId) throws Exception {
	        System.out.println("finding Ad for partnerId "+partnerId);
	        
	        return manager.getAd(partnerId);
	    }
	 
	 @POST
	    @Consumes({MediaType.APPLICATION_JSON})
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("/createnewad")
	    public String createNewAd(AdVO ad) throws Exception{
	        ad.setCreatedTime(new Date());
	        System.out.println("creatint new ad");
	        manager.createAd(ad);
	        System.out.println("Ad Created!!");
	        return "ok";
	    }
}

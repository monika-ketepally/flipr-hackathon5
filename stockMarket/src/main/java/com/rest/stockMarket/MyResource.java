package com.rest.stockMarket;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.Companydao;
import com.dao.NseNBseao;
import com.dao.Userdao;
import com.dto.BSE;
import com.dto.Graph;
import com.dto.NSE;
import com.dto.User;

@Path("myresource")
public class MyResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
   /* @Path("registerUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String registerUser(){
    	User user = new User();
    	user.setUserId(1);
    	user.setEmail("monikaketepally2001@gmail.com");
    	user.setPassword("monika@14");
    	Userdao u= new Userdao();
    	int x = u.register(user);
    	return user.getEmail();
    }
   */
    @Path("registerUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String registerUser(User user){
    	Userdao u= new Userdao();
    	int x = u.register(user);
    	return "s";
    }

    @Path("loginUser/{email}/{password}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User loginUser(@PathParam("email") String email , @PathParam("password") String password){
    	Userdao u= new Userdao();
    	User user = u.login(email,password);
    	return user;
    	
    }
    
   /* @Path("stock")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RELIENCE> stock(){
    	<List> RELIENCE list =null;
    	return null;
    }*/
    
    @Path("nse")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public NSE nse(){
    	String date = "2020-08-13";
    	java.util.Date date1;
    	java.sql.Date sqldate;
    	NSE nsee = new NSE();
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			sqldate = new java.sql.Date(date1.getTime());
			System.out.println(sqldate);
	    	NseNBseao n = new NseNBseao();
	    	nsee = n.getNse(sqldate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return nsee;
    	
    }
    
    @Path("bse")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public BSE bse(){
    	String date = "2020-08-13";
    	java.util.Date date1;
    	java.sql.Date sqldate;
    	BSE nsee = new BSE();
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			sqldate = new java.sql.Date(date1.getTime());
			System.out.println(sqldate);
	    	NseNBseao n = new NseNBseao();
	    	nsee = n.getBse(sqldate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return nsee;
    	
    }
    @Path("graph")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public <List>Graph graph(){
    	Companydao cd = new Companydao();
    	return (Graph) cd.graphDate();
    }
    
    @Path("graphh")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public <List>Date graphh(){
    	Companydao cd = new Companydao();
    	return (Date) cd.graphData();
    }
}






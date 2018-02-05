package com.oy.bookmark.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oy.bookmark.core.UserCore;
import com.oy.bookmark.core.exception.BusinessException;
import com.oy.bookmark.core.impl.UserCoreImpl;
import com.oy.bookmark.dao.model.User;

@Path("/user")
public class UserRs {

	private UserCore userCore = new UserCoreImpl();

	@GET
	@Path("/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response authentificationUser(@PathParam("email") String email, @PathParam("password") String password)
			throws BusinessException {
		User userResponse = userCore.authentificationUser(email, password);
		return Response.ok().entity(userResponse).build();

	}

}

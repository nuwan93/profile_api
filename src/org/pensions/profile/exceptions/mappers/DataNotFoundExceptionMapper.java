package org.pensions.profile.exceptions.mappers;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



import org.pensions.profile.exceptions.DataNotFoundException;
import org.pensions.profile.model.dto.Message;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		return Response
				.status(Status.NOT_FOUND)
				.entity(new Message(Status.NOT_FOUND.getStatusCode(), exception.getMessage()))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}

}

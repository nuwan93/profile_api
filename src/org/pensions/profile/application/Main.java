package org.pensions.profile.application;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


import org.pensions.profile.exceptions.mappers.DataNotFoundExceptionMapper;
import org.pensions.profile.exceptions.mappers.ThrowableExceptionMapper;
import org.pensions.profile.exceptions.mappers.UnAuthorizedExceptionMapper;
import org.pensions.profile.exceptions.mappers.UserNotFoundExceptionMapper;
import org.pensions.profile.filters.CorsFilter;

import io.swagger.jaxrs.config.BeanConfig;

@ApplicationPath("api")
public class Main extends Application {
	Logger LOGGER = Logger.getLogger(Main.class.getName());

	public Main() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("PENSIONS PROFILE API");
		beanConfig.setVersion("1.0");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("org.pensions.profile.resources");
		beanConfig.setScan(true);
		
	}

	@Override
	public Set<Class<?>> getClasses() {
		
		Set<Class<?>> resources = new HashSet<Class<?>>();

		//resources.add(AuthorizationResource.class);
		

		resources.add(CorsFilter.class);
		
		/*
		 * exception mappers
		 */
		resources.add(ThrowableExceptionMapper.class);
		resources.add(DataNotFoundExceptionMapper.class);
		resources.add(UnAuthorizedExceptionMapper.class);
		resources.add(UserNotFoundExceptionMapper.class);
		

		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

		return resources;
	}

}

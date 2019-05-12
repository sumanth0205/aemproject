package com.aem.aftergap.core.servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@SlingServlet(paths = "/bin/services/local", methods = "GET")
/*@Reference
OsgiService service;
*/

public class ServiceServlet extends SlingSafeMethodsServlet {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {

		/*service.addNodesFromService("/content/new/jcr:content", "service");
		service.addPropertiesFromService("/content/new/jcr:content", "service", " value");*/
	}

}

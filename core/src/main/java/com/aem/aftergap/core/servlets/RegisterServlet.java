package com.aem.aftergap.core.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SlingServlet(paths = "/bin/custom/cus", methods = "GET"

)

public class RegisterServlet extends SlingSafeMethodsServlet {
	Logger log = LoggerFactory.getLogger(this.getClass());
	

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		ResourceResolver reslover = request.getResourceResolver();
		Resource resource = reslover.getResource("/content/new/jcr:content");
		log.info("Resource is "+resource.getPath());
		log.info("Parent resource is "+resource.getParent().toString());
		Node node = resource.adaptTo(Node.class);
		Session session = reslover.adaptTo(Session.class);
		try {
			log.info("Node path is ::"+node.getPath());
			
			node.setProperty("backend", "value");
			node.addNode("bakend", "cq:PageContent");
			session.save();
			log.info("proprty add :: "+node.getProperty("backend").getString());

			
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		log.info("your servlet is triggered");
		
		
		

	}

}

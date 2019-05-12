package com.aem.aftergap.core.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aftergap.core.QueryBean;
import com.aem.aftergap.core.QueryService;

@SlingServlet(
		paths="/bin/query",
		methods="GET"
		
		)



public class QueryServlet extends SlingSafeMethodsServlet {
	
	@Reference
	QueryService service;
	Logger log=LoggerFactory.getLogger(this.getClass());
	
	
	@Override
	public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		List<QueryBean> tagList = service.getTagSearchResults("/content/screens/we-retail/appa/virtual-showroom/en/eqipment", "we-retail:season/summer");
		
		log.info("query servlet is triggerd ");
		Iterator<QueryBean> itr = tagList.iterator();
		log.info("this is after the ieterator");
		boolean ii = itr.hasNext();
		log.info("this is after hasnext");
		while(ii) {
			log.info("this is into the sevlet ");
			QueryBean bean = itr.next();
			log.info("this is path :: "+bean.getPagePath());
			log.info("this is tag:: "+bean.getTag());
			log.info("this is title:: "+bean.getTitle());
			
		}
	
	}

}

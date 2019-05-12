package com.aem.aftergap.core.listeners;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.UnsupportedRepositoryOperationException;
import javax.jcr.Workspace;
import javax.jcr.observation.Event;
import javax.jcr.observation.EventIterator;
import javax.jcr.observation.EventListener;
import javax.jcr.observation.ObservationManager;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class EventListenersCheck implements EventListener{
	
	@Reference
	ResourceResolverFactory factory;
	Logger log= LoggerFactory.getLogger(this.getClass());
	String nodeTypeName[]= {"cq:Page","cq:PageContent"};
	
	@Activate
	public void activate(ComponentContext context) {
		
		Map<String, Object> maps = new HashMap<String, Object>();

		maps.put(ResourceResolverFactory.SUBSERVICE, "getReslover");
		
			try {
				ResourceResolver reslover = factory.getServiceResourceResolver(maps);
				
				Session session = reslover.adaptTo(Session.class);
				Workspace workspace = session.getWorkspace();
				ObservationManager observationManger = workspace.getObservationManager();
				observationManger.addEventListener(this,
						Event.PROPERTY_ADDED | Event.NODE_ADDED,
						"/content",
						true,
						null,
						nodeTypeName,
						false);
				log.info("event registerd");
				
				
			
				
			} catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedRepositoryOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		// TODO Auto-generated method stub

	}

	@Override
	public void onEvent(EventIterator events) {
		
		log.info("event occured ");
		while (events.hasNext()) {
			try {
				log.info("event at :: "+events.nextEvent().getPath());
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		
		// TODO Auto-generated method stub
		
	}

}

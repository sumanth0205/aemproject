package com.aem.aftergap.core;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.AccessDeniedException;
import javax.jcr.InvalidItemStateException;
import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.ReferentialIntegrityException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.nodetype.NoSuchNodeTypeException;
import javax.jcr.version.VersionException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.installer.api.OsgiInstaller;

@Component
@Service(value = OagiServiceInterface.class)

public class OsgiService implements OagiServiceInterface{

	@Reference
	ResourceResolverFactory factory;

	public void addNodesFromService(String path, String nodeName) {
		Map<String, Object> maps = new HashMap<String, Object>();

		maps.put(ResourceResolverFactory.SUBSERVICE, "getReslover");
		try {
			ResourceResolver reslover = factory.getServiceResourceResolver(maps);
			Resource resource = reslover.getResource(path);
			Session session = reslover.adaptTo(Session.class);
			Node node = resource.adaptTo(Node.class);
			node.addNode(nodeName);
			session.save();

		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ItemExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferentialIntegrityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		} catch (InvalidItemStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchNodeTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addPropertiesFromService(String path, String name, String value) {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put(ResourceResolverFactory.SUBSERVICE, "getReslover");
		try {
			ResourceResolver reslover = factory.getServiceResourceResolver(map);
			Resource resource = reslover.getResource(path);

			Node node = resource.adaptTo(Node.class);
			node.setProperty(name, value);

			reslover.adaptTo(Session.class).save();

		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ItemExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferentialIntegrityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidItemStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchNodeTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String getPropertyFromService(String path) {
		
		String value=null;
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put(ResourceResolverFactory.SUBSERVICE, "getReslover");
		try {
			ResourceResolver reslover = factory.getServiceResourceResolver(map);
			Resource resource = reslover.getResource(path);

			Node node = resource.adaptTo(Node.class);
			value=node.getProperty("backend").getString();

		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ItemExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ReferentialIntegrityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidItemStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchNodeTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
		
	}

}

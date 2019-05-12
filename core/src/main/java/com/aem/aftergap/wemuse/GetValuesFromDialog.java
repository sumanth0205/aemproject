package com.aem.aftergap.wemuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;

public class GetValuesFromDialog extends WCMUsePojo{
	Logger log  = LoggerFactory.getLogger(this.getClass());

	
	private String text;
	private String path;
	private String contentName;
	private String resourceType;
	

	public String getText() {
		return text;
	}


	public String getPath() {
		return path;
	}


	public String getContentName() {
		return contentName;
	}


	public String getResourceType() {
		return resourceType;
	}


	@Override
	public void activate() throws Exception {

		text= getProperties().get("./desc").toString();
		path= getProperties().get("./path", "NULL").toString();
		contentName= getComponent().getName();
		resourceType= getPageProperties().get("./sling:resourceType", "NULL1");
		log.info("values from dialog ::"+path+text+contentName);
		
		
	}

}

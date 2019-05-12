package com.aem.aftergap.core;

public interface OagiServiceInterface {
	public void addPropertiesFromService(String path, String name, String value) ;
	public void addNodesFromService(String path, String nodeName) ;

	public String getPropertyFromService(String path);


}

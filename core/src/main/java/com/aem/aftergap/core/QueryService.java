package com.aem.aftergap.core;

import java.util.List;

public interface QueryService {
	
	
	public List<QueryBean> getTagSearchResults(String path,String tag);

}

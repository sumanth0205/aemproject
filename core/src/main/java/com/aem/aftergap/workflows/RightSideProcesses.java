package com.aem.aftergap.workflows;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.aem.aftergap.core.OsgiService;
@Component
@Service
public class RightSideProcesses implements WorkflowProcess{

	@Reference
	OsgiService service;
	@Override
	public void execute(WorkItem wi, WorkflowSession wfs, MetaDataMap mdm) throws WorkflowException {
	
		
		WorkflowData wdata = wi.getWorkflowData();
		String path = wdata.getPayload().toString();
		service.addPropertiesFromService(path, "right", "processes");
		
		
	}

}

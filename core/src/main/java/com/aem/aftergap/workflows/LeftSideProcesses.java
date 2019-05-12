package com.aem.aftergap.workflows;



import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

import com.aem.aftergap.core.OsgiService;
import com.day.cq.workflow.WorkflowException;
import com.day.cq.workflow.WorkflowSession;
import com.day.cq.workflow.exec.WorkItem;
import com.day.cq.workflow.exec.WorkflowData;
import com.day.cq.workflow.exec.WorkflowProcess;
import com.day.cq.workflow.metadata.MetaDataMap;
@Component
@Service
public class LeftSideProcesses implements WorkflowProcess{

	@Reference
	OsgiService service;
	@Override
	public void execute(WorkItem wi, WorkflowSession wfs, MetaDataMap mdm) throws WorkflowException {
		
		
		WorkflowData workdata = wi.getWorkflowData();
		String path = workdata.getPayload().toString();
		service.addNodesFromService(path, "left");
		
		
		
	}

}

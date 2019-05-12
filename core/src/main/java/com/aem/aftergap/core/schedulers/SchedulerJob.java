package com.aem.aftergap.core.schedulers;



import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.aftergap.core.OagiServiceInterface;




@Component(immediate=true,metatype=true

		,label="Scheduler API",
		description="Sheduler class which triggers for every 1 minute"
		)
@Service(value=Runnable.class)
@Property(
		name="scheduler.expression",
		value="0 0 12 1/1 * ? *" 
				
		
		)
public class SchedulerJob implements Runnable{
	Logger log= LoggerFactory.getLogger(this.getClass());

	
@Reference
OagiServiceInterface osgiService;

	@Override
	public void run() {
	
		log.info("this is from shuduler to service::  "+osgiService.getPropertyFromService("/content/new/jcr:content"));
		
	}

}

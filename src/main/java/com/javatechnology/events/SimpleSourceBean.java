package com.javatechnology.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.javatechnology.utils.UserContextHolder;

@Component
public class SimpleSourceBean {
	
	private Source source;
	private static final Logger logger=LoggerFactory.getLogger(SimpleSourceBean.class);
	
	@Autowired
	public SimpleSourceBean(Source source) {
		this.source=source;
				
	}
	public void publishOranizationChanges(String action,String orgId) {
		logger.debug("sending kafka message {} for Organization Id {}",action,orgId);
		OrganizationServiceModel change=new OrganizationServiceModel(OrganizationServiceModel.class.getTypeName(),action,orgId,UserContextHolder.getContext().getCorrelationId());
		source.output().send(MessageBuilder.withPayload(change).build());
	}

}

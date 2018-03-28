package com.frame.db.wr;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceAspect {
	
	private List<String> readMethods;
	
	public void setReadMethods(List<String> readMethods) {
		this.readMethods = readMethods;
	}

	public void before(JoinPoint point) {
		String methodName = point.getSignature().getName();  
        if (isSlave(methodName)) {  
        	log.info("slave : "+ methodName);
        	HandleDataSource.markSlave();  
        } else {  
        	log.info("master : "+ methodName);
        	HandleDataSource.markMaster();  
        }  
    }
	
	private Boolean isSlave(String methodName) {  
		return StringUtils.startsWithAny(methodName, readMethods.toArray(new String[0]));
	}
	
}

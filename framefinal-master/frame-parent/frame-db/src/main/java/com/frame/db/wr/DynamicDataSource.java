package com.frame.db.wr;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

	protected Object determineCurrentLookupKey() {
		String key = HandleDataSource.getDataSourceKey();
		log.info("DynamicDataSource : "+ key);
		return key;
	}

}

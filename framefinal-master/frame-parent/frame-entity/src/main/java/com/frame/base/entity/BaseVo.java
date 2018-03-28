package com.frame.base.entity;

import java.io.Serializable;
import lombok.Data;

@Data
public class BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected int id;
	protected int sortBy;
	protected boolean delFlag;// 0 false 1 true
}

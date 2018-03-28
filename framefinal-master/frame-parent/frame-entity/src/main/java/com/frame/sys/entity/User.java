package com.frame.sys.entity;

import com.frame.base.entity.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
public class User extends BaseVo {

	private static final long serialVersionUID = 1L;
	
	protected String loginId;
	protected String userName;
	protected String password;
	protected String salt; 
	protected Boolean locked = Boolean.FALSE;
    
	public String getCredentialsSalt() {
        return loginId + salt;
    }
}

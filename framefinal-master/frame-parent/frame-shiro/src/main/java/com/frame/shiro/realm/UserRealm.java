package com.frame.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import com.frame.sys.entity.User;
import com.frame.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRealm extends AuthorizingRealm {

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserRealm(CredentialsMatcher credentialsMatcher) {
		super(credentialsMatcher);
		log.info("UserRealm(CredentialsMatcher)");
	}
	
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("UserRealm doGetAuthorizationInfo");
		String loginId = (String)principals.getPrimaryPrincipal();
		log.info("loginId: AuthorizationInfo"+loginId);
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRole("user");
		//authorizationInfo.setRoles(new HashSet<String>());
        return authorizationInfo;
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String loginId = (String)token.getPrincipal();
		log.info(" UserRealm loginId ---- :"+loginId);
        User user = userService.queryByLoginId(loginId);
        log.info(" UserRealm queryByLoginId ---- :"+loginId);
        if(user == null) {
            throw new UnknownAccountException();
        }
        if(Boolean.TRUE.equals(user.isDelFlag())) {
            throw new LockedAccountException(); 
        }
        
        log.info(" UserRealm isDelFlag ---- :"+user.isDelFlag());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getLoginId(), 
                user.getPassword(), 
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );
        return authenticationInfo;
	}

}

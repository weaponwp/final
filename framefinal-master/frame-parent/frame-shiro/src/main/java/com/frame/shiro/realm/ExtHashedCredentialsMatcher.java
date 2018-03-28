package com.frame.shiro.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtHashedCredentialsMatcher extends HashedCredentialsMatcher {
	
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        boolean matches = super.doCredentialsMatch(token, info);
        log.info("doCredentialsMatch "+matches);
        return matches;
    }
	
}

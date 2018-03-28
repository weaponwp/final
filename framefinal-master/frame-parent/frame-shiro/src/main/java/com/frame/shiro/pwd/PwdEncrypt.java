package com.frame.shiro.pwd;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import com.frame.sys.entity.User;

public final class PwdEncrypt {

	private PwdEncrypt() {}

	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

	private String encrypttype;
	private int hashIterations;

	public void setEncrypttype(String encrypttype) {
		this.encrypttype = encrypttype;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

	public void encryptPassword(User user) {
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(encrypttype, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		user.setPassword(newPassword);
	}
}

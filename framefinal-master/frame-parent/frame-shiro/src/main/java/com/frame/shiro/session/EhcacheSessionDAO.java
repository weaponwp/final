package com.frame.shiro.session;

import java.io.Serializable;
import java.util.Collection;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

public class EhcacheSessionDAO extends AbstractSessionDAO {

	private EhCacheManager shiroCacheManager;
	
	public void setShiroCacheManager(EhCacheManager shiroCacheManager) {
		this.shiroCacheManager = shiroCacheManager;
	}

	public void update(Session session) throws UnknownSessionException {
		shiroCacheManager.getCache("shiro-activeSessionCache").put(session.getId(), session);
	}

	public void delete(Session session) {
		shiroCacheManager.getCache("shiro-activeSessionCache").remove(session.getId());
	}

	public Collection<Session> getActiveSessions() {
		return null;
	}

	protected Serializable doCreate(Session session) {
		return null;
	}

	protected Session doReadSession(Serializable sessionId) {
		return null;
	}

}

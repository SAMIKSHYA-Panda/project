package com.infinite.jsf.util;

import org.hibernate.Session;

public class SubscriptionIdGenerator {
	public static String getNextSubscriptionId(Session session) {
        String prefix = "S";
        String hql = "select max(subscriptionId) from Subscription";
        String maxId = (String) session.createQuery(hql).uniqueResult();

        if (maxId == null) {
            return prefix + "001";
        }

        int id = Integer.parseInt(maxId.substring(prefix.length()));
        id++;
        return String.format("%s%03d", prefix, id);
    }
	
	public static String getNextMemberId(Session session) {
		String prefix = "M";
		String hql = "select max(memberId) from SubscribedMember";
		String maxId = (String) session.createQuery(hql).uniqueResult();
		
		if (maxId == null) {
			return prefix + "001";
		}
		
		int id = Integer.parseInt(maxId.substring(prefix.length()));
		id++;
		return String.format("%s%03d", prefix, id);
	}
}

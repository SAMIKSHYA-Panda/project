package com.infinite.jsf.insurance.daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.SubscribedMemberDao;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.insurance.model.Subscription;
import com.infinite.jsf.util.SessionHelper;

public class SubscribedMemberDaoImpl implements SubscribedMemberDao {

	public List<SubscribedMember> searchBySubscriptionIdOrHidAndDob(String subscriptionId, String hId, Date dob) {
	    List<SubscribedMember> resultList = new ArrayList<>();
	    Session session = null;

	    try {
	        session = SessionHelper.getSessionFactory().openSession();

	        StringBuilder hql = new StringBuilder("FROM SubscribedMember sm WHERE 1=1");

	        if (subscriptionId != null && !subscriptionId.trim().isEmpty()) {
	            hql.append(" AND sm.subscriptionId = :subId");  // 👈 NOTE: changed from sm.subscription.subscriptionId
	        }
	        if (hId != null && !hId.trim().isEmpty()) {
	            hql.append(" AND sm.hId = :hId"); // 👈 Changed to direct column
	        }
	        if (dob != null) {
	            hql.append(" AND sm.dob = :dob");
	        }

	        System.out.println("🔍 Final HQL: " + hql.toString());

	        Query query = session.createQuery(hql.toString());

	        if (subscriptionId != null && !subscriptionId.trim().isEmpty()) {
	            query.setParameter("subId", subscriptionId);
	        }
	        if (hId != null && !hId.trim().isEmpty()) {
	            query.setParameter("hId", hId);
	        }
	        if (dob != null) {
	            query.setParameter("dob", dob);
	        }

	        resultList = query.list();
	        System.out.println("✅ Result count: " + resultList.size());

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) session.close();
	    }

	    return resultList;
	}
}
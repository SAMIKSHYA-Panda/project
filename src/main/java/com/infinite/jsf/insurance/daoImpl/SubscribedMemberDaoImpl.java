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
	    Session session = SessionHelper.getSessionFactory().openSession();
	    Transaction tx = null;
	    List<SubscribedMember> results = new ArrayList<>();

	    try {
	        tx = session.beginTransaction();

	        String hql = "FROM SubscribedMember sm " +
	                     "WHERE (sm.subscription.subscriptionId = :subscriptionId " +
	                     "OR (sm.recipient.hId = :hId AND sm.dob = :dob))";

	        Query query = session.createQuery(hql);
	        query.setParameter("subscriptionId", subscriptionId);
	        query.setParameter("hId", hId);
	        query.setParameter("dob", dob);

	        results = query.list();
	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

	    return results;
	}
}
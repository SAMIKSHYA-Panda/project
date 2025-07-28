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
		        String hql = "FROM SubscribedMember sm "
		                   + "WHERE sm.subscription.subscriptionId = :subId "
		                   + "AND sm.subscription.recipient.hId = :hId "
		                   + "AND sm.dob = :dob";

		        Query query = session.createQuery(hql);
		        query.setParameter("subId", subscriptionId);
		        query.setParameter("hId", hId);
		        query.setParameter("dob", dob);

		        resultList = query.list();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        if (session != null) session.close();
		    }
		    return resultList;
		}
}
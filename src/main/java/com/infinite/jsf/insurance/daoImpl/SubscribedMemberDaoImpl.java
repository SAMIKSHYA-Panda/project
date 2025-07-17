package com.infinite.jsf.insurance.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.infinite.jsf.insurance.dao.SubscribedMemberDao;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.util.SessionHelper;

public class SubscribedMemberDaoImpl implements SubscribedMemberDao {

	public void addSubscribedMember(SubscribedMember member) {
		Session session = SessionHelper.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(member);
		tx.commit();
		session.close();
	}
}
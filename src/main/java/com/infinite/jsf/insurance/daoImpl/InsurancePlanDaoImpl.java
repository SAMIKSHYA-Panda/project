package com.infinite.jsf.insurance.daoImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.infinite.jsf.insurance.dao.InsurancePlanDao;
import com.infinite.jsf.insurance.model.InsurancePlan;
import com.infinite.jsf.insurance.model.PlanType;
import com.infinite.jsf.util.SessionHelper;

public class InsurancePlanDaoImpl implements InsurancePlanDao {

    static SessionFactory factory = SessionHelper.getSessionFactory();

    @Override
    public String addInsurancePlan(InsurancePlan plan) {
        String planId = generateNextPlanId();
        plan.setPlanId(planId);
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        session.save(plan);
        trans.commit();
        session.close();
        return "success";
    }

    public String generateNextPlanId() {
        Session session = factory.openSession();
        String lastId = (String) session.createQuery(
            "SELECT p.planId FROM InsurancePlan p ORDER BY p.planId DESC")
            .setMaxResults(1)
            .uniqueResult();
        session.close();

        int nextNum = 1;
        if (lastId != null && lastId.toUpperCase().startsWith("PLA") && lastId.length() == 6) {
            String numPart = lastId.substring(3);
            if (numPart.matches("\\d{3}")) {
                nextNum = Integer.parseInt(numPart) + 1;
            }
        }

        return String.format("PLA%03d", nextNum);
    }

    @Override
    public InsurancePlan searchInsurancePlanById(String planId) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        InsurancePlan plan = (InsurancePlan) session.get(InsurancePlan.class, planId);
        trans.commit();
        session.close();
        return plan;
    }

    @Override
    public List<InsurancePlan> showAllPlans() {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(InsurancePlan.class);
        List<InsurancePlan> plans = criteria.list();
        trans.commit();
        session.close();
        return plans;
    }

    @Override
    public String updateInsurancePlan(InsurancePlan plan) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        session.update(plan);
        trans.commit();
        session.close();
        return "updated";
    }

    @Override
    public String deleteInsurancePlan(String planId) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        InsurancePlan plan = (InsurancePlan) session.get(InsurancePlan.class, planId);
        if (plan != null) {
            session.delete(plan);
            trans.commit();
            session.close();
            return "deleted";
        } else {
            trans.rollback();
            session.close();
            return "not found";
        }
    }

    @Override
    public List<InsurancePlan> searchByPlanType(String planType) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(InsurancePlan.class);

        // Convert String to Enum safely
        try {
            PlanType planTypeEnum = PlanType.valueOf(planType.toUpperCase());
            criteria.add(Restrictions.eq("planType", planTypeEnum));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid PlanType passed: " + planType);
            session.close();
            return new ArrayList<>();
        }

        List<InsurancePlan> planTypeList = criteria.list();
        trans.commit();
        session.close();
        return planTypeList;
    }

	@Override
	public List<InsurancePlan> searchByPolicyIdOrRecipient(String policyId, String hid, String dob) {
		List<InsurancePlan> results = new ArrayList<>();
	    try {
	        Session session = factory.openSession();
	        String hql = "SELECT DISTINCT ip FROM InsurancePlan ip " +
	                     "LEFT JOIN ip.coverageOptions co " +
	                     "LEFT JOIN Subscription s ON co.coverageId = s.insurancecoverageOption.coverageId " +
	                     "LEFT JOIN Recipient r ON s.recipient.hId = r.hId WHERE 1=1";

	        if (policyId != null && !policyId.trim().isEmpty()) {
	            hql += " AND ip.planId = :policyId";
	        }
	        if (hid != null && !hid.trim().isEmpty()) {
	            hql += " AND r.hId = :hid";
	        }
	        if (dob != null && !dob.trim().isEmpty()) {
	            hql += " AND r.dob = :dob";
	        }

	        org.hibernate.Query query = session.createQuery(hql);
	        if (policyId != null && !policyId.trim().isEmpty()) {
	            query.setParameter("policyId", policyId);
	        }
	        if (hid != null && !hid.trim().isEmpty()) {
	            query.setParameter("hid", hid);
	        }
	        if (dob != null && !dob.trim().isEmpty()) {
	            query.setParameter("dob", java.sql.Date.valueOf(dob));
	        }

	        results = query.list();
	        session.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return results;
	}
//=================
	@Override
	public List<InsurancePlan> getPlansByType(String planType) {
		        Session session = SessionHelper.getSessionFactory().openSession();
		        Query query = session.createQuery("from InsurancePlan where planType = :type");
		        query.setParameter("type", planType);
		        List<InsurancePlan> plans = query.list();
		        session.close();
		        return plans;
		    }

		    // other methods
		}
	

    

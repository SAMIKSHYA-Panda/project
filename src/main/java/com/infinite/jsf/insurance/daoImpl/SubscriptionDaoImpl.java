//package com.infinite.jsf.insurance.daoImpl;
// 
//import java.util.List;
// 
//import org.hibernate.Session;
//
//import org.hibernate.Transaction;
//
//import org.hibernate.Query;
// 
//import com.infinite.jsf.insurance.dao.SubscriptionDao;
//
//import com.infinite.jsf.insurance.model.Subscription;
//
//import com.infinite.jsf.util.SessionHelper;
//
//import com.infinite.jsf.util.SubscriptionIdGenerator;
// 
//public class SubscriptionDaoImpl implements SubscriptionDao {
// 
//    @Override
//
//    public String addSubscription(Subscription subscription) {
//
//        Transaction tx = null;
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
// 
//            // 🔧 Generate and set unique Subscription ID
//
//            String subscriptionId = SubscriptionIdGenerator.getNextSubscriptionId(session);
//
//            subscription.setSubscriptionId(subscriptionId);
// 
//            // 🔍 Debug log
//
//            System.out.println("=== Adding Subscription ===");
//
//            System.out.println("ID: " + subscriptionId);
//
//            System.out.println("Recipient: " + (subscription.getRecipient() != null ? subscription.getRecipient().gethId() : "null"));
//
//            System.out.println("Status: " + subscription.getStatus());
// 
//            tx = session.beginTransaction();
//
//            session.save(subscription);
//
//            tx.commit();
//
//            session.close();
// 
//            return "Subscription added successfully with ID: " + subscriptionId;
//
//        } catch (Exception e) {
//
//            if (tx != null) tx.rollback();
//
//            e.printStackTrace();
//
//            return "Error adding subscription: " + e.getMessage();
//
//        }
//
//    }
// 
//    @Override
//
//    public String updateSubscription(Subscription subscription) {
//
//        Transaction tx = null;
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
// 
//            // 🔍 Debug log
//
//            System.out.println("=== Updating Subscription ===");
//
//            System.out.println("ID: " + subscription.getSubscriptionId());
//
//            System.out.println("Status: " + subscription.getStatus());
// 
//            tx = session.beginTransaction();
//
//            session.update(subscription);
//
//            tx.commit();
//
//            session.close();
//
//            return "Subscription updated successfully.";
//
//        } catch (Exception e) {
//
//            if (tx != null) tx.rollback();
//
//            e.printStackTrace();
//
//            return "Error updating subscription: " + e.getMessage();
//
//        }
//
//    }
// 
//    @Override
//
//    public void deleteSubscription(Subscription subscription) {
//
//        Transaction tx = null;
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
//
//            tx = session.beginTransaction();
//
//            session.delete(subscription);
//
//            tx.commit();
//
//            session.close();
//
//        } catch (Exception e) {
//
//            if (tx != null) tx.rollback();
//
//            e.printStackTrace();
//
//        }
//
//    }
// 
//    @Override
//
//    public Subscription getSubscriptionById(String subscriptionId) {
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
//
//            Subscription subscription = (Subscription) session.get(Subscription.class, subscriptionId);
//
//            session.close();
//
//            return subscription;
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return null;
//
//        }
//
//    }
// 
//    @Override
//
//    public List<Subscription> getSubscriptionsByRecipientId(String recipientId) {
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
// 
//            // 🔧 FIXED: Correct field path using recipient.hId
//
//            Query query = session.createQuery("from Subscription where recipient.hId = :recipientId");
//
//            query.setParameter("recipientId", recipientId);
// 
//            List result = query.list();
//
//            session.close();
//
//            return result;
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return null;
//
//        }
//
//    }
// 
//    @Override
//
//    public List<Subscription> getAllSubscriptions() {
//
//        try {
//
//            Session session = SessionHelper.getSessionFactory().openSession();
//
//            Query query = session.createQuery("from Subscription");
//
//            List result = query.list();
//
//            session.close();
//
//            return result;
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            return null;
//
//        }
//
//    }
//
//}



package com.infinite.jsf.insurance.daoImpl;
 
import java.util.Date;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
 
import com.infinite.jsf.insurance.dao.SubscriptionDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.insurance.model.Recipient;
import com.infinite.jsf.insurance.model.Subscription;
import com.infinite.jsf.util.SessionHelper;
import com.infinite.jsf.util.SubscriptionIdGenerator;
 
public class SubscriptionDaoImpl implements SubscriptionDao {
 
  
   
    @Override
    public String addSubscription(Subscription subscription) {
        Transaction tx = null;
        Session session = null;
        try {
            session = SessionHelper.getSessionFactory().openSession();

            System.out.println("=== Adding Subscription ===");
            System.out.println("ID: " + subscription.getSubscriptionId());
            System.out.println("Recipient HId: " + (subscription.getRecipient() != null ? subscription.getRecipient().gethId() : "null"));
            System.out.println("Coverage ID: " + (subscription.getInsurancecoverageOption() != null ? subscription.getInsurancecoverageOption().getCoverageId() : "null"));

            tx = session.beginTransaction();

            // ✅ Get persistent Recipient
            Recipient persistentRecipient = (Recipient) session.get(
                Recipient.class, 
                subscription.getRecipient().gethId()
            );
            subscription.setRecipient(persistentRecipient);

            // ✅ Get persistent Coverage Option
            InsuranceCoverageOption persistentOption = (InsuranceCoverageOption) session.get(
                InsuranceCoverageOption.class,
                subscription.getInsurancecoverageOption().getCoverageId()
            );
            subscription.setInsurancecoverageOption(persistentOption);

            // ✅ Save the subscription
            session.save(subscription);
            tx.commit();

            return "Subscription added successfully with ID: " + subscription.getSubscriptionId();

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "Error adding subscription: " + e.getMessage();
        } finally {
            if (session != null) session.close();
        }
    }


 
    @Override
    public String updateSubscription(Subscription subscription) {
        Transaction tx = null;
        Session session = null;
        try {
            session = SessionHelper.getSessionFactory().openSession();

            System.out.println("=== Updating Subscription ===");
            System.out.println("ID: " + subscription.getSubscriptionId());
            System.out.println("Status: " + subscription.getStatus());

            tx = session.beginTransaction();
            session.update(subscription);
            tx.commit();

            return "Subscription updated successfully.";
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return "Error updating subscription: " + e.getMessage();
        } finally {
            if (session != null) session.close();
        }
    }

 
    @Override
    public void deleteSubscription(String subscriptionId) {
        Transaction tx = null;
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Subscription subscription = (Subscription) session.get(Subscription.class, subscriptionId);
            if (subscription != null) {
                tx = session.beginTransaction();
                session.delete(subscription);
                tx.commit();
            }
            session.close();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
 
    @Override
    public Subscription getSubscriptionById(String subscriptionId) {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Subscription subscription = (Subscription) session.get(Subscription.class, subscriptionId);
            session.close();
            return subscription;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    @Override
    public List<Subscription> getSubscriptionsByRecipientId(String recipientId) {
        try {
            Session session = SessionHelper.getSessionFactory().openSession();
            Query query = session.createQuery("from Subscription where recipient.hId = :recipientId");
            query.setParameter("recipientId", recipientId);
            List<Subscription> result = query.list();
            session.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 
    @Override
    public List<Subscription> getAllSubscriptions() {
        Session session = null;
        try {
            session = SessionHelper.getSessionFactory().openSession();

            Query query = session.createQuery(
                "SELECT s FROM Subscription s "
                + "JOIN FETCH s.recipient "
                + "JOIN FETCH s.insurancecoverageOption"
                +"ORDER BY s.subscriptionId"//order by used for showing in shorting wa
            );

            List<Subscription> result = query.list();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) session.close();
        }
    }



	@Override
	public String generateNextSubscriptionId() {
		 Session session = null;
		    try {
		        session = SessionHelper.getSessionFactory().openSession();
		        return SubscriptionIdGenerator.getNextSubscriptionId(session);
		    } finally {
		        if (session != null && session.isOpen()) {
		            session.close();
		        }
	}

}



	@Override
	public List<Subscription> getAllSubscriptionsSorted(String sortBy, boolean ascending) {
		 Session session = null;
		    try {
		        session = SessionHelper.getSessionFactory().openSession();

		        String order = ascending ? "asc" : "desc";
		        String hql = "SELECT s FROM Subscription s "
		                   + "JOIN FETCH s.recipient "
		                   + "JOIN FETCH s.insurancecoverageOption "
		                   + "ORDER BY s." + sortBy + " " + order;

		        Query query = session.createQuery(hql);
		        return query.list();

		    } catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    } finally {
		        if (session != null) session.close();
		    }
		}



	@Override
	public List<Subscription> searchByRecipientAndDob(String hid, Date dob) {
		 Session session = SessionHelper.getSessionFactory().openSession();

		    String hql = "FROM Subscription s WHERE s.recipient.hId = :hid";
		    if (dob != null) {
		        hql += " AND s.recipient.dob = :dob";
		    }

		    Query query = session.createQuery(hql);
		    query.setParameter("hid", hid);
		    if (dob != null) {
		        query.setParameter("dob", dob);
		    }

		    List<Subscription> list = query.list();
		    session.close();
		    return list;
		}

}
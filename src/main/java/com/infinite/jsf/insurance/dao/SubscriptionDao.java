//package com.infinite.jsf.insurance.dao;
//
//import java.util.List;
//
//import com.infinite.jsf.insurance.model.Subscription;
//
//public interface SubscriptionDao {
//	// add a new subscription
//    String addSubscription(Subscription subscription);
//
//    // update an existing subscription
//    String updateSubscription(Subscription subscription);
//
//    // delete a subscription by object
//    void deleteSubscription(Subscription subscription);
//
//    // get subscription by subscriptionId (primary key)
//    Subscription getSubscriptionById(String subscriptionId);
//
//    // get all subscriptions for a specific recipient (by hId)
//    List<Subscription> getSubscriptionsByRecipientId(String recipientId);
//
//    // get all subscriptions (admin/reporting)
//    List<Subscription> getAllSubscriptions();
//}
package com.infinite.jsf.insurance.dao;
 
import java.util.Date;
import java.util.List;
import com.infinite.jsf.insurance.model.Subscription;
 
public interface SubscriptionDao {
 
    String addSubscription(Subscription subscription);
 
    String updateSubscription(Subscription subscription);
 
    void deleteSubscription(String subscriptionId);
 
    Subscription getSubscriptionById(String subscriptionId);
 
    List<Subscription> getSubscriptionsByRecipientId(String hId);
 
    List<Subscription> getAllSubscriptions();
    public List<Subscription> getAllSubscriptionsSorted(String sortBy, boolean ascending);

    String generateNextSubscriptionId();
    public List<Subscription> searchByRecipientAndDob(String hid, Date dob);

}
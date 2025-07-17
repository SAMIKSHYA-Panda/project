//package com.infinite.jsf.insurance.dao;
//
//import com.infinite.jsf.insurance.model.Recipient;
//
//public interface RecipientDao {
//	public String addRecipient(Recipient recipient);
//	public String generatePassword(String user, int otp);
//}
package com.infinite.jsf.insurance.dao;
 
import java.util.List;
import com.infinite.jsf.insurance.model.Recipient;
 
public interface RecipientDao {
 
    String addRecipient(Recipient recipient);
 
    String generatePassword(String userName, int otp);
 
    Recipient findByHid(String hId);
 
    List<Recipient> findAllRecipients();
}
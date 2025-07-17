//package com.infinite.jsf.insurance.daoImpl;
//
//import java.util.Random;
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import com.infinite.jsf.insurance.dao.RecipientDao;
//import com.infinite.jsf.insurance.model.Otp;
//import com.infinite.jsf.insurance.model.OtpStatus;
//import com.infinite.jsf.insurance.model.Purpose;
//import com.infinite.jsf.insurance.model.Recipient;
//import com.infinite.jsf.insurance.model.Status;
//import com.infinite.jsf.util.MailSend;
//import com.infinite.jsf.util.RecipientIdGenerator;
//import com.infinite.jsf.util.SessionHelper;
//
//
//public class RecipientDaoImpl implements RecipientDao {
//
//    Session session;
//
//    public int generateOtp() {
//        Random r = new Random(System.currentTimeMillis());
//        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000)); // 10000–29999
//    }
//
//    public String addRecipient(Recipient recipient) {
//        session = SessionHelper.getSessionFactory().openSession();
//
//        String hId = RecipientIdGenerator.getNextRecipientId(session);
//        recipient.sethId(hId);
//        recipient.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
//        recipient.setStatus(Status.ACTIVE);
//
//        Transaction trans = session.beginTransaction();
//        session.save(recipient);
//        trans.commit();
//
//        int code = generateOtp();
//        Otp otp = new Otp();
//        otp.setOtpCode(code);
//        otp.setStatus(OtpStatus.PENDING);
//        otp.setPurpose(Purpose.REGISTER);
//        otp.setUserName(recipient.getUserName());
//
//        java.util.Calendar calendar = java.util.Calendar.getInstance();
//        calendar.add(java.util.Calendar.MINUTE, 10);
//        otp.setExpiresAt(calendar.getTime());
//
//        trans = session.beginTransaction();
//        session.save(otp);
//        trans.commit();
//
//        String subject = "Hii " + recipient.getUserName() + ", Congratulations!! you are now a member of our Hospital Management System";
//        String body = "Your OTP code is " + code + ". Please use it for password generation";
//        MailSend.sendInfo(recipient.getEmail(), subject, body);
//
//        session.close();
//        return "Recipient record added and OTP sent via email.";
//    }
//
//    public String getAlphaNumericString() {
//        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
//        StringBuilder sb = new StringBuilder(10);
//        for (int i = 0; i < 10; i++) {
//            int index = (int) (alphaNum.length() * Math.random());
//            sb.append(alphaNum.charAt(index));
//        }
//        return sb.toString();
//    }
//
//    @Override
//    public String generatePassword(String user, int otpCode) {
//        session = SessionHelper.getSessionFactory().openSession();
//
//        String hql = "FROM Otp WHERE user_name = :user AND otp_code = :otp AND status = 'PENDING'";
//        Query query = session.createQuery(hql);
//        query.setParameter("user", user);
//        query.setParameter("otp", otpCode);
//        Otp objOtp = (Otp) query.uniqueResult();
//
//        if (objOtp != null) {
//            Query empQuery = session.createQuery("FROM Recipient WHERE user_name = :userName");
//            empQuery.setParameter("userName", user);
//            Recipient recipient = (Recipient) empQuery.uniqueResult();
//
//            String pwd = getAlphaNumericString();
//            objOtp.setStatus(OtpStatus.VERIFIED);
//            objOtp.setNewPassword(pwd);
//
//            Transaction trans = session.beginTransaction();
//            session.update(objOtp);
//            trans.commit();
//
//            String body = "Your one-time password for login is: " + pwd;
//            MailSend.sendInfo(recipient.getEmail(), "One-Time Password", body);
//
//            session.close();
//            return "Your One-Time password has been generated and emailed to you.";
//        }
//
//        session.close();
//        return "Recipient record not found — OTP or username may be incorrect.";
//    }
//}


package com.infinite.jsf.insurance.daoImpl;
 
import java.util.List;
import java.util.Random;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.infinite.jsf.insurance.dao.RecipientDao;
import com.infinite.jsf.insurance.model.Otp;
import com.infinite.jsf.insurance.model.OtpStatus;
import com.infinite.jsf.insurance.model.Purpose;
import com.infinite.jsf.insurance.model.Recipient;
import com.infinite.jsf.insurance.model.Status;
import com.infinite.jsf.util.MailSend;
import com.infinite.jsf.util.RecipientIdGenerator;
import com.infinite.jsf.util.SessionHelper;
 
public class RecipientDaoImpl implements RecipientDao {
 
    Session session;
 
    public int generateOtp() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000)); // 10000–29999
    }
 
    @Override
    public String addRecipient(Recipient recipient) {
        session = SessionHelper.getSessionFactory().openSession();
 
        String hId = RecipientIdGenerator.getNextRecipientId(session);
        recipient.sethId(hId);
        recipient.setCreatedAt(new java.util.Date());
        recipient.setStatus("ACTIVE"); // ✅ matches String type in Recipient.java
 
        Transaction trans = session.beginTransaction();
        session.save(recipient);
        trans.commit();
 
        int code = generateOtp();
        Otp otp = new Otp();
        otp.setOtpCode(code);
        otp.setStatus(OtpStatus.PENDING);
        otp.setPurpose(Purpose.REGISTER);
        otp.setUserName(recipient.getUserName());
 
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(java.util.Calendar.MINUTE, 10);
        otp.setExpiresAt(calendar.getTime());
 
        trans = session.beginTransaction();
        session.save(otp);
        trans.commit();
 
        String subject = "Hi " + recipient.getUserName() + ", Welcome to our Hospital Management System";
        String body = "Your OTP code is " + code + ". Please use it to generate your password.";
        MailSend.sendInfo(recipient.getEmail(), subject, body);
 
        session.close();
        return "Recipient record added and OTP sent via email.";
    }
 
    public String getAlphaNumericString() {
        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            int index = (int) (alphaNum.length() * Math.random());
            sb.append(alphaNum.charAt(index));
        }
        return sb.toString();
    }
 
    @Override
    public String generatePassword(String user, int otpCode) {
        session = SessionHelper.getSessionFactory().openSession();
 
        String hql = "FROM Otp WHERE user_name = :user AND otp_code = :otp AND status = 'PENDING'";
        Query query = session.createQuery(hql);
        query.setParameter("user", user);
        query.setParameter("otp", otpCode);
        Otp objOtp = (Otp) query.uniqueResult();
 
        if (objOtp != null) {
            Query empQuery = session.createQuery("FROM Recipient WHERE user_name = :userName");
            empQuery.setParameter("userName", user);
            Recipient recipient = (Recipient) empQuery.uniqueResult();
 
            String pwd = getAlphaNumericString();
            objOtp.setStatus(OtpStatus.VERIFIED);
            objOtp.setNewPassword(pwd);
 
            Transaction trans = session.beginTransaction();
            session.update(objOtp);
            trans.commit();
 
            String body = "Your one-time password for login is: " + pwd;
            MailSend.sendInfo(recipient.getEmail(), "One-Time Password", body);
 
            session.close();
            return "Your One-Time password has been generated and emailed to you.";
        }
 
        session.close();
        return "Recipient record not found — OTP or username may be incorrect.";
    }
 
    @Override
    public Recipient findByHid(String hId) {
        session = SessionHelper.getSessionFactory().openSession();
        Recipient recipient = (Recipient) session.get(Recipient.class, hId);
        session.close();
        return recipient;
    }
 
    @Override
    public List<Recipient> findAllRecipients() {
        session = SessionHelper.getSessionFactory().openSession();
        List<Recipient> recipients = session.createQuery("FROM Recipient").list();
        session.close();
        return recipients;
    }
}

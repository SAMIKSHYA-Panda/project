
package com.infinite.jsf.insurance.daoImpl;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.NativeQuery;
 
import com.infinite.jsf.insurance.dao.InsuranceCoverageOptionDao;
import com.infinite.jsf.insurance.model.InsuranceCoverageOption;
import com.infinite.jsf.util.SessionHelper;
 
public class InsuranceCoverageOptionDaoImpl implements InsuranceCoverageOptionDao {
 
    static SessionFactory factory;
    static {
        factory = SessionHelper.getSessionFactory();
    }
 
    @Override
    public String addInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        session.save(coverageOption);
        trans.commit();
        session.close();
        return "success";
    }
 
    @Override
    public String deleteInsuranceCoverageOption(String coverageId) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        InsuranceCoverageOption coverageOption = (InsuranceCoverageOption) session.get(InsuranceCoverageOption.class, coverageId);
        if (coverageOption != null) {
            session.delete(coverageOption);
            trans.commit();
            session.close();
            return "deleted";
        } else {
            trans.rollback();
            session.close();
            return "coverage not found";
        }
    }
 
    @Override
    public List<InsuranceCoverageOption> findAllCoverageOption() {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        Criteria criteria = session.createCriteria(InsuranceCoverageOption.class);
        List<InsuranceCoverageOption> coverageOptions = criteria.list();
        trans.commit();
        session.close();
        return coverageOptions;
    }
 
    @Override
    public String updateInsuranceCoverageOption(InsuranceCoverageOption coverageOption) {
        Session session = factory.openSession();
        Transaction trans = session.beginTransaction();
        session.update(coverageOption);
        trans.commit();
        session.close();
        return "updated";
    }
 
    @Override
    public InsuranceCoverageOption findByCoverageId(String coverageId) {
        Session session = factory.openSession();
        InsuranceCoverageOption option = (InsuranceCoverageOption) session.get(InsuranceCoverageOption.class, coverageId);
        session.close();
        return option;
    }
 
    @Override

    public List<InsuranceCoverageOption> searchByPlanType(String planType) {

        Session session = factory.openSession();

        Transaction trans = session.beginTransaction();

        String sql = "SELECT c.* FROM insurance_coverage_option c "

                   + "JOIN insurance_plan p ON p.plan_id = c.plan_id "

                   + "WHERE p.plan_type = :planType";

        org.hibernate.SQLQuery query = session.createSQLQuery(sql);

        query.addEntity(InsuranceCoverageOption.class);

        query.setParameter("planType", planType.toUpperCase());
     
        List<InsuranceCoverageOption> coverageOptions = query.list();

        trans.commit();

        session.close();

        return coverageOptions;

    }

    @Override
    public List<InsuranceCoverageOption> getOptionsByPlanId(String planId) {
        Session session = factory.openSession();
        String hql = "FROM InsuranceCoverageOption WHERE insurancePlan.planId = :planId";
        org.hibernate.Query query = session.createQuery(hql);
        query.setParameter("planId", planId);
        List<InsuranceCoverageOption> options = query.list();
        session.close();
        return options;
    }

}
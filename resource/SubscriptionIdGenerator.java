

import org.hibernate.Session;

public class SubscriptionIdGenerator {
	public static String getNextSubscriptionId(Session session) {
        String prefix = "SUB";
        String hql = "select max(subscriptionId) from Subscription";
        String maxId = (String) session.createQuery(hql).uniqueResult();

        if (maxId == null) {
            return prefix + "001";
        }

        int id = Integer.parseInt(maxId.substring(prefix.length()));
        id++;
        return String.format("%s%03d", prefix, id);
    }
}

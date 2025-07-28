package com.infinite.jsf.insurance.dao;

import java.util.Date;
import java.util.List;
import com.infinite.jsf.insurance.model.SubscribedMember;

public interface SubscribedMemberDao {
	List<SubscribedMember> searchBySubscriptionIdOrHidAndDob(String subscriptionId, String hId, Date dob);

}

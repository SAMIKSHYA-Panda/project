package com.infinite.jsf.insurance.controller;

import java.io.Serializable;
import java.util.List;

import com.infinite.jsf.insurance.daoImpl.SubscribedMemberDaoImpl;
import com.infinite.jsf.insurance.model.SubscribedMember;
import com.infinite.jsf.insurance.model.Subscription;

public class SubscribedMemberController implements Serializable {

    private SubscribedMember member = new SubscribedMember();
    private String useExistingSubscription = "yes"; // "yes" or "no"
    private String selectedSubscriptionId;          // comes from UI
    private List<SubscribedMember> memberList;

    SubscribedMemberDaoImpl dao = new SubscribedMemberDaoImpl();

    public String save() {
        try {
            if ("yes".equalsIgnoreCase(useExistingSubscription)) {
                Subscription s = new Subscription();
                s.setSubscriptionId(selectedSubscriptionId); // link existing subscription
                member.setSubscription(s);
            } else {
                Subscription newSub = new Subscription();
                newSub.setSubscriptionId("S00X"); // You should generate dynamically or get from service
                member.setSubscription(newSub);
            }

            dao.addSubscribedMember(member);
            return "ConfirmationSelf.jsp"; // success navigation
        } catch (Exception e) {
            e.printStackTrace();
            return "Error.jsp"; // fallback page on failure
        }
    }

    // Getters and Setters
    public SubscribedMember getMember() {
        return member;
    }

    public void setMember(SubscribedMember member) {
        this.member = member;
    }

    public String getUseExistingSubscription() {
        return useExistingSubscription;
    }

    public void setUseExistingSubscription(String useExistingSubscription) {
        this.useExistingSubscription = useExistingSubscription;
    }

    public String getSelectedSubscriptionId() {
        return selectedSubscriptionId;
    }

    public void setSelectedSubscriptionId(String selectedSubscriptionId) {
        this.selectedSubscriptionId = selectedSubscriptionId;
    }

    public List<SubscribedMember> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<SubscribedMember> memberList) {
        this.memberList = memberList;
    }
}
package com.infinite.jsf.insurance.model;

import java.util.Date;
import java.util.Set;

public class Subscription {
	private String subscriptionId;
    private Recipient recipient;
    private InsuranceCoverageOption insurancecoverageOption;
    private Date subscribeDate;
    private Date expiryDate;
    private String status;
    private double totalPremium;
    private double amountPaid;
    private Set<SubscribedMember> members;  // One-to-many

    public Subscription() {
        super();
    }

    public Subscription(String subscriptionId, Recipient recipient, InsuranceCoverageOption insurancecoverageOption,
                        Date subscribeDate, Date expiryDate, String status, double totalPremium,
                        double amountPaid, Set<SubscribedMember> members) {
        this.subscriptionId = subscriptionId;
        this.recipient = recipient;
        this.insurancecoverageOption = insurancecoverageOption;
        this.subscribeDate = subscribeDate;
        this.expiryDate = expiryDate;
        this.status = status;
        this.totalPremium = totalPremium;
        this.amountPaid = amountPaid;
        this.members = members;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public InsuranceCoverageOption getInsurancecoverageOption() {
        return insurancecoverageOption;
    }

    public void setInsurancecoverageOption(InsuranceCoverageOption insurancecoverageOption) {
        this.insurancecoverageOption = insurancecoverageOption;
    }

    public Date getSubscribeDate() {
        return subscribeDate;
    }

    public void setSubscribeDate(Date subscribeDate) {
        this.subscribeDate = subscribeDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(double totalPremium) {
        this.totalPremium = totalPremium;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Set<SubscribedMember> getMembers() {
        return members;
    }

    public void setMembers(Set<SubscribedMember> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Subscription [subscriptionId=" + subscriptionId + ", recipient=" + recipient
                + ", insurancecoverageOption=" + insurancecoverageOption + ", subscribeDate=" + subscribeDate
                + ", expiryDate=" + expiryDate + ", status=" + status + ", totalPremium=" + totalPremium
                + ", amountPaid=" + amountPaid + ", members=" + members + "]";
    }
}

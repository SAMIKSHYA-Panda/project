package com.infinite.jsf.insurance.model;

import java.util.Date;

public class SubscribedMember {

	private String memberId;
	private String hId;
    private String subscriptionId;
	private String fullName;
	private Date dob;
	private int age;
	private String gender;
	private String relationWithProposer;
	private String aadharNo;
	private Subscription subscription; // mapped as many-to-one

	// Getters & Setters

	
	public String getFullName() {
		return fullName;
	}

	public String gethId() {
		return hId;
	}

	public void sethId(String hId) {
		this.hId = hId;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationWithProposer() {
		return relationWithProposer;
	}

	public void setRelationWithProposer(String relationWithProposer) {
		this.relationWithProposer = relationWithProposer;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public Subscription getSubscription() {
		return subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
}
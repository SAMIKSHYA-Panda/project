<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<html lang="en">
<f:view>
  <head>
    <meta charset="UTF-8" />
    <title>Enroll in Super Elite Plan</title>
    <style>
      body {
        font-family: 'Segoe UI', sans-serif;
        background-color: #f1f5f9;
        padding: 2rem;
      }

      .form-container {
        max-width: 700px;
        margin: auto;
        background-color: #ffffff;
        padding: 2rem;
        border-radius: 10px;
        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.1);
      }

      h2 {
        text-align: center;
        color: #1d3557;
        margin-bottom: 1.5rem;
      }

      .form-group {
        margin-bottom: 1.2rem;
      }

      label {
        font-weight: 600;
        margin-bottom: 0.3rem;
        display: block;
      }

      input, select {
        width: 100%;
        padding: 0.7rem;
        font-size: 1rem;
        border: 1px solid #ccc;
        border-radius: 6px;
      }

      .submit-btn {
        background-color: #1d4ed8;
        color: #fff;
        border: none;
        padding: 0.8rem 2rem;
        font-size: 1rem;
        border-radius: 6px;
        cursor: pointer;
        margin-top: 1rem;
      }

      .submit-btn:hover {
        background-color: #153bb1;
      }
    </style>
  </head>
  <body>
    <h2>Super Elite Insurance Application</h2>

    <h:form styleClass="form-container">
      <!-- Hidden Plan ID -->
      <h:inputHidden value="#{subscriptionBean.planId}" />

      <div class="form-group">
        <h:outputLabel for="recipientId" value="Recipient ID (h_id):" />
        <h:inputText id="recipientId" value="#{subscriptionBean.hid}" required="true" />
      </div>

      <div class="form-group">
        <h:outputLabel for="coverageId" value="Select Coverage Option:" />
        <h:selectOneMenu id="coverageId" value="#{subscriptionBean.coverageId}">
          <f:selectItems value="#{subscriptionBean.coverageOptions}" var="cov"
                         itemValue="#{cov.coverageId}" itemLabel="#{cov.coverageAmount} (₹#{cov.premiumAmount}/yr)" />
        </h:selectOneMenu>
      </div>

      <div class="form-group">
        <h:outputLabel for="fullName" value="Applicant Full Name:" />
        <h:inputText id="fullName" value="#{subscriptionBean.fullName}" required="true" />
      </div>

      <div class="form-group">
        <h:outputLabel for="dob" value="Date of Birth:" />
        <h:inputText id="dob" value="#{subscriptionBean.dob}" required="true" />
      </div>

      <div class="form-group">
        <h:outputLabel for="age" value="Age:" />
        <h:inputText id="age" value="#{subscriptionBean.age}" required="true" />
      </div>

      <div class="form-group">
        <h:outputLabel for="gender" value="Gender:" />
        <h:selectOneMenu id="gender" value="#{subscriptionBean.gender}">
          <f:selectItem itemLabel="-- Select --" itemValue="" />
          <f:selectItem itemLabel="Male" itemValue="MALE" />
          <f:selectItem itemLabel="Female" itemValue="FEMALE" />
        </h:selectOneMenu>
      </div>

      <div class="form-group">
        <h:outputLabel for="aadhar" value="Aadhar Number:" />
        <h:inputText id="aadhar" value="#{subscriptionBean.aadhar}" required="true" />
      </div>

      <div class="form-group">
        <h:outputLabel for="agree" value="Medical Checkup Consent:" />
        <h:selectBooleanCheckbox id="agree" value="#{subscriptionBean.medicalConsent}" />
      </div>

      <h:commandButton value="Submit Enrollment" action="#{subscriptionBean.submit}" styleClass="submit-btn" />
    </h:form>
  </body>
</f:view>
</html>

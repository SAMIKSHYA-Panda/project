<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<!DOCTYPE html>
<html>
<head>
    <title>Subscribe to Insurance Plan</title>
    <style>
        body { background-color: #f0f8ff; font-family: Arial; }
        .container { width: 70%; margin: auto; background: #fff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px #ccc; }
        h2 { color: #0077cc; }
        .form-row { margin: 10px 0; }
        .field-label { font-weight: bold; }
        .error-message { color: red; font-size: small; }
    </style>
</head>
<body>
<f:view>
    <div class="container">
        <h2>Subscribe to Insurance Plan</h2>
        <h:form>
            <h:messages globalOnly="true" styleClass="error-message" />

            <!-- Recipient ID -->
            <div class="form-row">
                <span class="field-label">Recipient Health ID (h_id):</span><br/>
                <h:inputText id="hId" value="#{subscriptionController.recipient.hId}" />
                <h:message for="hId" styleClass="error-message" />
            </div>

            <!-- First Name -->
            <div class="form-row">
                <span class="field-label">First Name:</span><br/>
                <h:inputText id="firstName" value="#{subscriptionController.recipient.firstName}" />
                <h:message for="firstName" styleClass="error-message" />
            </div>

            <!-- Last Name -->
            <div class="form-row">
                <span class="field-label">Last Name:</span><br/>
                <h:inputText id="lastName" value="#{subscriptionController.recipient.lastName}" />
                <h:message for="lastName" styleClass="error-message" />
            </div>

            <!-- Mobile -->
            <div class="form-row">
                <span class="field-label">Mobile:</span><br/>
                <h:inputText id="mobile" value="#{subscriptionController.recipient.mobile}" />
                <h:message for="mobile" styleClass="error-message" />
            </div>

            <!-- UserName -->
            <div class="form-row">
                <span class="field-label">User Name:</span><br/>
                <h:inputText id="userName" value="#{subscriptionController.recipient.userName}" />
                <h:message for="userName" styleClass="error-message" />
            </div>

            <!-- Gender -->
            <div class="form-row">
                <span class="field-label">Gender:</span><br/>
                <h:selectOneMenu id="gender" value="#{subscriptionController.recipient.gender}">
                    <f:selectItem itemLabel="--Select--" itemValue="" />
                    <f:selectItem itemLabel="Male" itemValue="MALE" />
                    <f:selectItem itemLabel="Female" itemValue="FEMALE" />
                </h:selectOneMenu>
                <h:message for="gender" styleClass="error-message" />
            </div>

            <!-- DOB as String (yyyy-MM-dd) -->
            <div class="form-row">
                <span class="field-label">Date of Birth (yyyy-MM-dd):</span><br/>
                <h:inputText id="dob" value="#{subscriptionController.recipientDob}" />
                <h:message for="dob" styleClass="error-message" />
            </div>

            <!-- Email -->
            <div class="form-row">
                <span class="field-label">Email:</span><br/>
                <h:inputText id="email" value="#{subscriptionController.recipient.email}" />
                <h:message for="email" styleClass="error-message" />
            </div>

            <!-- Address -->
            <div class="form-row">
                <span class="field-label">Address:</span><br/>
                <h:inputTextarea id="address" value="#{subscriptionController.recipient.address}" rows="3" cols="40" />
                <h:message for="address" styleClass="error-message" />
            </div>

            <!-- Coverage Option -->
            <div class="form-row">
                <span class="field-label">Select Coverage Option:</span><br/>
                <h:selectOneMenu id="selectedCoverageId" value="#{subscriptionController.selectedCoverageId}">
                    <f:selectItem itemLabel="-- Select Coverage --" itemValue="" />
                    <f:selectItems value="#{subscriptionController.coverageOptions}"
                                   var="option"
                                   itemValue="#{option.coverageId}"
                                   itemLabel="#{option.coverageAmount} (₹#{option.premiumAmount})" />
                </h:selectOneMenu>
                <h:message for="selectedCoverageId" styleClass="error-message" />
            </div>

            <!-- Submit Buttons -->
            <div class="form-row">
                <h:commandButton value="Submit" action="#{subscriptionController.saveSubscription}" />
                <h:commandButton value="Cancel" action="NExploreInsuranceplan?faces-redirect=true" immediate="true"/>
            </div>

        </h:form>
    </div>
</f:view>
</body>
</html>
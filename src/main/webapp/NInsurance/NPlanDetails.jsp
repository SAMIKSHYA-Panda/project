<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Plan Details</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f4f6f9;
            padding: 30px;
        }
        .details-box {
            background-color: white;
            padding: 25px;
            max-width: 700px;
            margin: auto;
            border: 1px solid #ccc;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .label {
            font-weight: bold;
        }
        .value {
            color: #444;
        }
        .button {
            margin-top: 20px;
            display: block;
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            text-align: center;
            cursor: pointer; /* This makes the cursor a hand on hover */
        }
    </style>
</head>
<body>
    <h:form styleClass="details-box">
        <h2>Insurance Plan Details</h2>

        <h:panelGrid columns="2" columnClasses="label,value" cellpadding="8">
            <h:outputText value="Plan ID:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.planId}" />

            <h:outputText value="Plan Name:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.planName}" />

            <h:outputText value="Company:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.insuranceCompany.name}" />

            <h:outputText value="Plan Type:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.planType}" />

            <h:outputText value="Min Entry Age:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.minEntryAge}" />

            <h:outputText value="Max Entry Age:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.maxEntryAge}" />

            <h:outputText value="Cover Amounts:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.availableCoverAmounts}" />

            <h:outputText value="Waiting Period:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.waitingPeriod}" />

            <h:outputText value="Description:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.description}" />

            <h:outputText value="Periodic Diseases:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.periodicDiseases}" />

            <h:outputText value="Created On:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.createdOn}" />

            <h:outputText value="Active On:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.activeOn}" />

            <h:outputText value="Expire Date:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.expireDate}" />
        </h:panelGrid>

        <h:commandButton value="Subscribe Now" styleClass="button"
            action="#{subscriptionController.prepareSubscriptionPage(insurancePlanController.insurancePlan)}" />

    </h:form>
</body>
</html>
</f:view>
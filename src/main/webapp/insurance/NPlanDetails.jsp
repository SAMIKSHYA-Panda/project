<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Plan Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fafc;
            padding: 30px;
        }

        .details-container {
            background-color: #ffffff;
            border: 1px solid #ccc;
            padding: 25px;
            max-width: 600px;
            margin: auto;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .label {
            font-weight: bold;
            padding-right: 10px;
        }

        .value {
            color: #555;
        }

        .back-link {
            margin-top: 25px;
            text-align: center;
        }

        .back-link a {
            text-decoration: none;
            color: #0077cc;
            font-weight: bold;
        }

        .subscribe-btn {
            display: block;
            margin: 25px auto 0;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-align: center;
        }

        .subscribe-btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
    <h:form styleClass="details-container">
        <h2>Insurance Plan Details</h2>

        <h:panelGrid columns="2" columnClasses="label,value" cellpadding="8" cellspacing="2" width="100%">
            <h:outputText value="Plan ID:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.planId}" />

            <h:outputText value="Plan Name:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.planName}" />

            <h:outputText value="Plan Type:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.planType}" />

            <h:outputText value="Company Name:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.insuranceCompany.name}" />

            <h:outputText value="Min Entry Age:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.minEntryAge}" />

            <h:outputText value="Max Entry Age:" />
            <h:outputText value="#{insurancePlanController.insurancePlan.maxEntryAge}" />

            <h:outputText value="Available Cover Amounts:" />
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

        <!-- Subscribe Button -->
        <h:commandButton value="Subscribe Now" styleClass="subscribe-btn"
    action="#{subscriptionController.navigateToSubscribe1(insurancePlanController.insurancePlan)}" />

        <!-- Back link -->
        <div class="back-link">
            <h:outputLink value="NExploreInsurancePlan.jsp"> Back to Plans</h:outputLink>
        </div>
    </h:form>
</body>
</html>
</f:view>

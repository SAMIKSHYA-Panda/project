<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
 
<f:view>
<html>
<head>
<title>Explore Insurance Plans</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9fafb;
            padding: 30px;
        }
 
        h2 {
            color: #222;
            margin-bottom: 20px;
        }
 
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #ffffff;
            border: 1px solid #d1d5db;
        }
 
        th, td {
            padding: 12px 16px;
            border: 1px solid #d1d5db;
            text-align: left;
        }
 
        th {
            background-color: #e2e8f0;
            font-weight: bold;
        }
 
        .action-link {
            color: #007bff;
            text-decoration: none;
        }
 
        .action-link:hover {
            text-decoration: underline;
        }
</style>
</head>
 
<body>
<h:form>
<h2>Explore Insurance Plans</h2>
 
    <h:dataTable value="#{insurancePlanController.findAllPlan()}" var="plan" styleClass="plan-table" border="1">
 
        <h:column>
<f:facet name="header">
<h:outputLabel value="Plan ID" />
</f:facet>
<h:outputText value="#{plan.planId}" />
</h:column>
 
        <h:column>
<f:facet name="header">
<h:outputLabel value="Plan Name" />
</f:facet>
<h:outputText value="#{plan.planName}" />
</h:column>
 
        <h:column>
<f:facet name="header">
<h:outputLabel value="Company" />
</f:facet>
<h:outputText value="#{plan.insuranceCompany.name}" />
</h:column>
 
        <h:column>
<f:facet name="header">
<h:outputLabel value="Actions" />
</f:facet>
<h:commandLink value="View Details"
                           action="#{insurancePlanController.searchPlanById(plan.planId)}"
                           styleClass="action-link"/>
</h:column>
 
    </h:dataTable>
</h:form>
</body>
</html>
</f:view>
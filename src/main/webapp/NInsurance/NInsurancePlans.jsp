<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
<f:view>
<head>
    <title>Insurance Plans</title>
    <style>
        table {
            margin: 2rem auto;
            width: 90%;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #0277bd;
            color: white;
        }
        .actions {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>

    <h2 style="text-align:center">Available Insurance Plans</h2>

    <h:form>
        <h:dataTable value="#{insuranceBean.filteredPlans}" var="plan" border="1">
            <h:column>
                <f:facet name="header">Plan ID</f:facet>
                <h:outputText value="#{plan.planId}" />
            </h:column>
            <h:column>
                <f:facet name="header">Plan Name</f:facet>
                <h:outputText value="#{plan.planName}" />
            </h:column>
            <h:column>
                <f:facet name="header">Type</f:facet>
                <h:outputText value="#{plan.planType}" />
            </h:column>
            <h:column>
                <f:facet name="header">Premium</f:facet>
                <h:outputText value="#{plan.premium}" />
            </h:column>
            <h:column>
                <f:facet name="header">Details</f:facet>
                <h:commandButton value="View" action="#{insuranceBean.viewPlanDetails(plan.planId)}" />
            </h:column>
        </h:dataTable>
    </h:form>

</body>
</f:view>
</html>
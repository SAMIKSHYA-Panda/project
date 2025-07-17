<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>All Subscriptions</title>
</head>
<body>
<f:view>
    <h:form>
        <h2>📋 Subscription List</h2>
        
        <h:dataTable value="#{subscriptionController.subscriptionList}" var="sub" border="1" cellpadding="5">
            <h:column>
                <f:facet name="header">Subscription ID</f:facet>
                <h:outputText value="#{sub.subscriptionId}" />
            </h:column>
            
            <h:column>
                <f:facet name="header">Recipient ID</f:facet>
                <h:outputText value="#{sub.recipient.hId}" />
            </h:column>
            
            <h:column>
                <f:facet name="header">Coverage ID</f:facet>
                <h:outputText value="#{sub.insurancecoverageOption.coverageId}" />
            </h:column>
            
            <h:column>
                <f:facet name="header">Status</f:facet>
                <h:outputText value="#{sub.status}" />
            </h:column>
            
            <h:column>
                <f:facet name="header">Premium</f:facet>
                <h:outputText value="#{sub.totalPremium}" />
            </h:column>
            
            <h:column>
                <f:facet name="header">Actions</f:facet>
                <h:commandLink value="Edit" action="#{subscriptionController.editSubscription(sub)}" />
                <h:outputText value=" | " />
                <h:commandLink value="Delete" action="#{subscriptionController.deleteSubscription(sub)}" />
            </h:column>
        </h:dataTable>
        
        <br/><br/>
        <h:commandLink value="➕ New Subscription" action="#{subscriptionController.newSubscription}" />
    </h:form>
</f:view>
</body>
</html>

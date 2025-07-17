<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Search Insurance Plan</title>
</head>
<body>
<f:view>
    <h:form>
        <h2>Search Insurance Plan</h2>

        <h:panelGrid columns="2" cellpadding="5">
            <h:outputLabel value="Policy ID:" />
            <h:inputText value="#{insurancePlanController.searchPolicyId}" />

            <h:outputLabel value="Recipient HID:" />
            <h:inputText value="#{insurancePlanController.searchHid}" />

            <h:outputLabel value="Date of Birth (yyyy-MM-dd):" />
            <h:inputText value="#{insurancePlanController.searchDob}" />
        </h:panelGrid>

        <h:commandButton value="Search" action="#{insurancePlanController.searchPlanByPolicyOrRecipient}" />

        <h:messages globalOnly="true" style="color:red;" />

        <h:panelGroup rendered="#{not empty insurancePlanController.searchResults}">
            <h3>
                <h:outputText value="Search Results:"/>
            </h3>
            <h:dataTable value="#{insurancePlanController.searchResults}" var="plan" border="1">
                <h:column>
                    <f:facet name="header">Plan ID</f:facet>
                    <h:outputText value="#{plan.planId}" />
                </h:column>
                <h:column>
                    <f:facet name="header">Plan Name</f:facet>
                    <h:outputText value="#{plan.planName}" />
                </h:column>
                <h:column>
                    <f:facet name="header">Plan Type</f:facet>
                    <h:outputText value="#{plan.planType}" />
                </h:column>
                <h:column>
                    <f:facet name="header">Company</f:facet>
                    <h:outputText value="#{plan.insuranceCompany.name}" />
                </h:column>
            </h:dataTable>
        </h:panelGroup>
    </h:form>
</f:view>
</body>
</html>
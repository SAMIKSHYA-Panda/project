<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<f:view>
    <h:form>
        <h2>Available Insurance Plans</h2>

        <h:dataTable value="#{subscriptionController.planList}" var="plan" border="1">
            <h:column>
                <f:facet name="header">Plan ID</f:facet>
                <h:outputText value="#{plan.planId}" />
            </h:column>

            <h:column>
                <f:facet name="header">Plan Name</f:facet>
                <h:outputText value="#{plan.planName}" />
            </h:column>

            <h:column>
                <f:facet name="header">Subscribe</f:facet>
                <h:commandButton value="Subscribe" action="#{subscriptionController.navigateToSubscribe(plan)}" />
            </h:column>
        </h:dataTable>
    </h:form>
</f:view>
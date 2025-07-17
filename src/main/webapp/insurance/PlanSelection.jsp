<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head><title>Select Insurance Plan</title></head>
<body>
<f:view>
  <h:form>
    <h2>Select an Insurance Plan</h2>

    <h:panelGrid columns="2">
      <h:outputLabel value="Plan Type" for="planType"/>
      <h:selectOneMenu id="planType" value="#{subscriptionController.selectedPlanType}">
        <f:selectItem itemLabel="-- Select --" itemValue="" />
        <f:selectItem itemLabel="SELF" itemValue="SELF" />
        <f:selectItem itemLabel="FAMILY" itemValue="FAMILY" />
        <f:selectItem itemLabel="SENIOR" itemValue="SENIOR" />
        <f:selectItem itemLabel="CRITICAL_ILLNESS" itemValue="CRITICAL_ILLNESS" />
        <f:selectItem itemLabel="SUPER_ELITE" itemValue="SUPER_ELITE" />
        <f:selectItem itemLabel="EPIDEMIC_PROTECT" itemValue="EPIDEMIC_PROTECT" />
      </h:selectOneMenu>
    </h:panelGrid>

    <br/>
    <h:commandButton value="Show Plans" action="#{subscriptionController.loadPlans}" />
    <br/><br/>

    <h:dataTable value="#{subscriptionController.filteredPlans}" var="plan" border="1"
                 rendered="#{not empty subscriptionController.filteredPlans}">
      <h:column>
        <f:facet name="header"><h:outputText value="Plan ID"/></f:facet>
        <h:outputText value="#{plan.planId}" />
      </h:column>
      <h:column>
        <f:facet name="header"><h:outputText value="Plan Name"/></f:facet>
        <h:outputText value="#{plan.planName}" />
      </h:column>
      <h:column>
        <f:facet name="header"><h:outputText value="Company"/></f:facet>
        <h:outputText value="#{plan.insuranceCompany.name}" />
      </h:column>
      <h:column>
        <f:facet name="header"><h:outputText value="Select"/></f:facet>
        <h:commandLink value="Choose" action="#{subscriptionController.selectPlan(plan)}" />
      </h:column>
    </h:dataTable>

  </h:form>
</f:view>
</body>
</html>

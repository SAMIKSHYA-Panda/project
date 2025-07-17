<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head><title>Choose a Plan</title></head>
<body>
<h:form>
    <h:dataTable value="#{subscriptionController.planList}" var="plan" border="1">
        <h:column><f:facet name="header">Plan Name</f:facet>#{plan.planName}</h:column>
        <h:column><f:facet name="header">Type</f:facet>#{plan.planType}</h:column>
        <h:column><f:facet name="header">Company</f:facet>#{plan.company.name}</h:column>
        <h:column><f:facet name="header">Action</f:facet>
            <h:commandLink value="Subscribe" action="#{subscriptionController.navigateToSubscribe(plan)}" />
        </h:column>
    </h:dataTable>
</h:form>
</body>
</html>

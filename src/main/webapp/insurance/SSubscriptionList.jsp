<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
<head><title>Subscription List</title></head>
<body>

<f:view>
    <h:form>
        <h2>Subscribed Members</h2>

        <h:dataTable value="#{subscriptionController.subscriptionList}" var="sub" border="1">
            <h:column>
                <f:facet name="header">Subscription ID</f:facet>
                #{sub.subscriptionId}
            </h:column>
            <h:column>
                <f:facet name="header">Recipient</f:facet>
                #{sub.recipient.name}
            </h:column>
            <h:column>
                <f:facet name="header">Plan</f:facet>
                #{sub.insurancePlan.planName}
            </h:column>
        </h:dataTable>
    </h:form>
</f:view>

</body>
</html>
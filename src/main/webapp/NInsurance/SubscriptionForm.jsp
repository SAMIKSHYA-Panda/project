<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
<head>
    <title>Subscription Form</title>
</head>
<body>
<f:view>
    <h:form>
        <h:messages globalOnly="true" />

        <h:panelGrid columns="2">
            <h:outputLabel value="Subscription ID:" />
            <h:inputText value="#{subscriptionController.subscription.subscriptionId}" />

            <h:outputLabel value="Recipient ID:" />
            <h:inputText value="#{subscriptionController.recipient.hid}" />

            <h:outputLabel value="Coverage Option:" />
            <h:inputText value="#{subscriptionController.subscription.insurancecoverageOption.coverageId}" />

            <h:outputLabel value="Subscribe Date:" />
            <h:inputText value="#{subscriptionController.subscription.subscribeDate}" />

            <h:outputLabel value="Expiry Date:" />
            <h:inputText value="#{subscriptionController.subscription.expiryDate}" />

            <h:outputLabel value="Status:" />
            <h:inputText value="#{subscriptionController.subscription.status}" />

            <h:outputLabel value="Total Premium:" />
            <h:inputText value="#{subscriptionController.subscription.totalPremium}" />

            <h:outputLabel value="Amount Paid:" />
            <h:inputText value="#{subscriptionController.subscription.amountPaid}" />
        </h:panelGrid>

        <h:commandButton value="Save" action="#{subscriptionController.saveSubscription}" />
        <h:commandButton value="Back to List" action="SubscriptionList?faces-redirect=true" />
    </h:form>
</f:view>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Subscription List</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f9f9f9;
            padding: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #e5e7eb;
        }
        .btn {
            padding: 6px 12px;
            margin: 2px;
        }
        .table-header {
            font-size: 1.2em;
            font-weight: bold;
        }
    </style>
</head>
<body>

<f:view>
    <h:form>

        <h2>All Subscriptions</h2>
        <hr/>

        <h:messages globalOnly="true" style="color:red;" />

        <h:dataTable value="#{subscriptionController.subscriptionList}" var="sub" rendered="#{not empty subscriptionController.subscriptionList}">
            <h:column>
                <f:facet name="header"><h:outputText value="Subscription ID" styleClass="table-header" /></f:facet>
                <h:outputText value="#{sub.subscriptionId}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Recipient Name" styleClass="table-header" /></f:facet>
                <h:outputText value="#{sub.recipient.firstName} #{sub.recipient.lastName}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Coverage ID" styleClass="table-header" /></f:facet>
                <h:outputText value="#{sub.insurancecoverageOption.coverageId}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Coverage Amount" styleClass="table-header" /></f:facet>
                <h:outputText value="₹#{sub.insurancecoverageOption.coverageAmount}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Premium" styleClass="table-header" /></f:facet>
                <h:outputText value="₹#{sub.totalPremium}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Paid" styleClass="table-header" /></f:facet>
                <h:outputText value="₹#{sub.amountPaid}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Start Date" styleClass="table-header" /></f:facet>
                <h:outputText value="#{sub.subscribeDate}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Expiry Date" styleClass="table-header" /></f:facet>
                <h:outputText value="#{sub.expiryDate}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Status" styleClass="table-header" /></f:facet>
                <h:outputText value="#{sub.status}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Renew" styleClass="table-header" /></f:facet>
                <h:commandButton value="Renew" action="#{subscriptionController.renewSubscription(sub.subscriptionId)}" styleClass="btn" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Delete" styleClass="table-header" /></f:facet>
                <h:commandButton value="Delete" action="#{subscriptionController.deleteSubscription(sub)}" styleClass="btn" />
            </h:column>
        </h:dataTable>

        <!-- Display message if list is empty -->
        <h:panelGroup rendered="#{empty subscriptionController.subscriptionList}">
            <h:outputText value="No subscriptions found." style="color: gray; font-style: italic;" />
        </h:panelGroup>

        <br/><br/>
        <h:commandButton value="Back to Explore Plans" action="ExploreInsurance2" styleClass="btn" />

    </h:form>
</f:view>

</body>
</html>

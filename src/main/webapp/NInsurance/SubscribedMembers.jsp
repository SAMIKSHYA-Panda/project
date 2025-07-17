<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
<head>
    <title>Subscribed Members</title>
</head>
<body>
<f:view>

    <h:form>
        <h:messages globalOnly="true" />

        <h2>List of Subscribed Members</h2>

        <h:dataTable value="#{subscribedMemberController.memberList}" var="m" border="1">

            <h:column>
                <f:facet name="header">Recipient ID</f:facet>
                <h:outputText value="#{m.recipientId}" />
            </h:column>

            <h:column>
                <f:facet name="header">Full Name</f:facet>
                <h:outputText value="#{m.fullName}" />
            </h:column>

            <h:column>
                <f:facet name="header">Gender</f:facet>
                <h:outputText value="#{m.gender}" />
            </h:column>

            <h:column>
                <f:facet name="header">Age</f:facet>
                <h:outputText value="#{m.age}" />
            </h:column>

            <h:column>
                <f:facet name="header">Relation</f:facet>
                <h:outputText value="#{m.relationWithProposer}" />
            </h:column>

            <h:column>
                <f:facet name="header">Aadhar No</f:facet>
                <h:outputText value="#{m.aadharNo}" />
            </h:column>

            <h:column>
                <f:facet name="header">Actions</f:facet>
                <h:commandLink value="Edit" action="#{subscribedMemberController.editMember(m)}" />
                |
                <h:commandLink value="Delete" action="#{subscribedMemberController.deleteMember(m)}"
                               onclick="return confirm('Are you sure you want to delete this member?')" />
            </h:column>

        </h:dataTable>

        <br/>
        <h:commandButton value="Add New Member" action="#{subscribedMemberController.newMember}" />
    </h:form>

</f:view>
</body>
</html>

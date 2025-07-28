<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Add Subscribed Member</title>
</head>
<body>
<f:view>
    <h:form>
        <h2>Add Subscribed Member</h2>

        <h:panelGrid columns="2" cellpadding="5">

            <h:outputLabel value="Full Name:" />
            <h:inputText value="#{subscribedMemberController.subscribedMember.fullName}" required="true" />

            <h:outputLabel value="Date of Birth:" />
            <h:inputText value="#{subscribedMemberController.subscribedMember.dob}" required="true">
              <f:convertDateTime pattern="yyyy-MM-dd" />
            </h:inputText>

            <h:outputLabel value="Age:" />
            <h:inputText value="#{subscribedMemberController.subscribedMember.age}" required="true" />

            <h:outputLabel value="Gender:" />
            <h:selectOneMenu value="#{subscribedMemberController.subscribedMember.gender}">
                <f:selectItem itemLabel="--Select--" itemValue="" />
                <f:selectItem itemLabel="MALE" itemValue="MALE" />
                <f:selectItem itemLabel="FEMALE" itemValue="FEMALE" />
            </h:selectOneMenu>

            <h:outputLabel value="Relation with Proposer:" />
            <h:inputText value="#{subscribedMemberController.subscribedMember.relationWithProposer}" required="true" />

            <h:outputLabel value="Aadhar No:" />
            <h:inputText value="#{subscribedMemberController.subscribedMember.aadharNo}" required="true" />

            <h:outputLabel value="Subscription ID:" />
            <h:inputText value="#{subscribedMemberController.subscription.subscriptionId}" required="true" />

        </h:panelGrid>

        <br/>

        <h:commandButton value="Add Member" action="#{subscribedMemberController.addMember}" />
        <h:commandButton value="Reset" type="reset" />

    </h:form>
</f:view>
</body>
</html>
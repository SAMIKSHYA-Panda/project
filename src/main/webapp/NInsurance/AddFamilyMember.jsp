<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<html>
<head>
    <title>Add Family Member</title>
</head>
<body>
    <f:view>
        <h:form>
            <h2>Add Subscribed Member</h2>

            <h:outputLabel value="Full Name:" />
            <h:inputText value="#{subscribedMemberController.member.fullName}" /><br/>

            <h:outputLabel value="DOB:" />
            <h:inputText value="#{subscribedMemberController.member.dob}" /><br/>

            <h:outputLabel value="Age:" />
            <h:inputText value="#{subscribedMemberController.member.age}" /><br/>

            <h:outputLabel value="Gender:" />
            <h:inputText value="#{subscribedMemberController.member.gender}" /><br/>

            <h:outputLabel value="Relation:" />
            <h:selectOneMenu value="#{subscribedMemberController.member.relationWithProposer}">
                <f:selectItem itemValue="Self" itemLabel="Self" />
                <f:selectItem itemValue="Spouse" itemLabel="Spouse" />
                <f:selectItem itemValue="Child" itemLabel="Child" />
                <f:selectItem itemValue="Parent" itemLabel="Parent" />
            </h:selectOneMenu><br/>

            <h:outputLabel value="Aadhar No:" />
            <h:inputText value="#{subscribedMemberController.member.aadharNo}" /><br/>

            <h:outputLabel value="Use Existing Policy?" />
            <h:selectOneMenu value="#{subscribedMemberController.useExistingSubscription}">
                <f:selectItem itemValue="yes" itemLabel="Yes (Use Existing)" />
                <f:selectItem itemValue="no" itemLabel="No (Create New)" />
            </h:selectOneMenu><br/>

            <h:outputLabel value="If Yes, Enter Subscription ID:" />
            <h:inputText value="#{subscribedMemberController.selectedSubscriptionId}" /><br/>

            <h:commandButton value="Submit" action="#{subscribedMemberController.save}" />
        </h:form>
    </f:view>
</body>
</html>
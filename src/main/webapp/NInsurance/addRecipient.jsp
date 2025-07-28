<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Add Recipient</title>
</head>
<body>
    <f:view>
        <h:form>
            <h3>Add New Recipient</h3>

            <h:outputLabel value="First Name:" for="firstName" />
            <h:inputText id="firstName" value="#{recipientController.recipient.firstName}" /><br/>

            <h:outputLabel value="Last Name:" for="lastName" />
            <h:inputText id="lastName" value="#{recipientController.recipient.lastName}" /><br/>

            <h:outputLabel value="Gender:" for="gender" />
            <h:selectOneMenu id="gender" value="#{recipientController.recipient.gender}">
                <f:selectItem itemValue="Male" itemLabel="Male"/>
                <f:selectItem itemValue="Female" itemLabel="Female"/>
                <f:selectItem itemValue="Other" itemLabel="Other"/>
            </h:selectOneMenu><br/>

            <h:outputLabel value="Date of Birth:" for="dob" />
            <h:inputText id="dob" value="#{recipientController.recipient.dob}" /><br/>

            <h:outputLabel value="Mobile:" for="mobile" />
            <h:inputText id="mobile" value="#{recipientController.recipient.mobile}" /><br/>

            <h:outputLabel value="Username:" for="userName" />
            <h:inputText id="userName" value="#{recipientController.recipient.userName}" /><br/>

            <h:outputLabel value="Password:" for="password" />
            <h:inputSecret id="password" value="#{recipientController.recipient.password}" /><br/>

            <h:outputLabel value="Email:" for="email" />
            <h:inputText id="email" value="#{recipientController.recipient.email}" /><br/>

            <h:outputLabel value="Address:" for="address" />
            <h:inputTextarea id="address" value="#{recipientController.recipient.address}" /><br/>

            <h:outputLabel value="Status:" for="status" />
            <h:selectOneMenu id="status" value="#{recipientController.recipient.status}">
                <f:selectItem itemValue="Active" itemLabel="Active"/>
                <f:selectItem itemValue="Inactive" itemLabel="Inactive"/>
            </h:selectOneMenu><br/>

            <h:commandButton value="Save Recipient" action="#{recipientController.saveRecipient}" />
        </h:form>
    </f:view>
</body>
</html>
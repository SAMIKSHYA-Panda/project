<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head><title>Subscribed Member Form</title></head>
<body>
<f:view>
    <h:form>
        <h3>Member Details</h3>
        <table>
            <tr>
                <td>Recipient ID:</td>
                <td><h:inputText value="#{memberController.member.recipientId}" required="true" /></td>
            </tr>
            <tr>
                <td>Subscription ID:</td>
                <td><h:inputText value="#{memberController.member.subscription.subscriptionId}" required="true" /></td>
            </tr>
            <tr>
                <td>Full Name:</td>
                <td><h:inputText value="#{memberController.member.fullName}" /></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><h:inputText value="#{memberController.member.age}" /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <h:selectOneMenu value="#{memberController.member.gender}">
                        <f:selectItem itemLabel="Male" itemValue="MALE" />
                        <f:selectItem itemLabel="Female" itemValue="FEMALE" />
                        <f:selectItem itemLabel="Other" itemValue="OTHER" />
                    </h:selectOneMenu>
                </td>
            </tr>
            <tr>
                <td>Relation:</td>
                <td><h:inputText value="#{memberController.member.relationWithProposer}" /></td>
            </tr>
            <tr>
                <td>Aadhar No:</td>
                <td><h:inputText value="#{memberController.member.aadharNo}" /></td>
            </tr>
        </table>
        <br/>
        <h:commandButton value="Save Member" action="#{memberController.saveMember}" />
    </h:form>
</f:view>
</body>
</html>

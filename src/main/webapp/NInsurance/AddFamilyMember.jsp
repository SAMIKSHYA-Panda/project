<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Add Subscribed Member</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f7;
            padding: 20px;
        }
        .form-container {
            background-color: #fff;
            padding: 25px;
            border-radius: 12px;
            width: 500px;
            margin: auto;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .form-container h2 {
            text-align: center;
            margin-bottom: 25px;
        }
        .form-field {
            margin-bottom: 15px;
        }
        .form-field label {
            display: block;
            font-weight: bold;
        }
        .form-field input, .form-field select {
            width: 100%;
            padding: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
        }
        .submit-button {
            text-align: center;
        }
        .submit-button h:commandButton {
            background-color: #2e86de;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <f:view>
        <h:form>
            <div class="form-container">
                <h2>Add Member to Subscription</h2>

                <div class="form-field">
                    <h:outputLabel value="Recipient ID (hId):" />
                    <h:inputText value="#{subscribedMemberController.recipientId}" />
                </div>

                <div class="form-field">
                    <h:outputLabel value="Subscription ID:" />
                    <h:inputText value="#{subscribedMemberController.subscriptionId}" />
                </div>

                <div class="form-field">
                    <h:outputLabel value="Full Name:" />
                    <h:inputText value="#{subscribedMemberController.member.fullName}" />
                </div>

                <div class="form-field">
                    <h:outputLabel value="Date of Birth:" />
                    <h:inputText value="#{subscribedMemberController.member.dob}" />
                </div>

                <div class="form-field">
                    <h:outputLabel value="Age:" />
                    <h:inputText value="#{subscribedMemberController.member.age}" />
                </div>

                <div class="form-field">
                    <h:outputLabel value="Gender:" />
                    <h:selectOneMenu value="#{subscribedMemberController.member.gender}">
                        <f:selectItem itemValue="Male" itemLabel="Male"/>
                        <f:selectItem itemValue="Female" itemLabel="Female"/>
                        <f:selectItem itemValue="Other" itemLabel="Other"/>
                    </h:selectOneMenu>
                </div>

                <div class="form-field">
                    <h:outputLabel value="Relation with Proposer:" />
                    <h:selectOneMenu value="#{subscribedMemberController.member.relationWithProposer}">
                        <f:selectItems value="#{subscribedMemberController.relationOptions}" />
                    </h:selectOneMenu>
                </div>

                <div class="form-field">
                    <h:outputLabel value="Aadhar Number:" />
                    <h:inputText value="#{subscribedMemberController.member.aadharNo}" />
                </div>

                <div class="submit-button">
                    <h:commandButton value="Add Member" action="#{subscribedMemberController.save}" />
                </div>
            </div>
        </h:form>
    </f:view>
</body>
</html>
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
            background-color: white;
            padding: 20px;
            width: 600px;
            margin: auto;
            border-radius: 8px;
            box-shadow: 0 0 10px #ccc;
        }
        .form-container h2 {
            text-align: center;
        }
        .field {
            margin-bottom: 12px;
        }
        .field label {
            display: block;
            font-weight: bold;
            margin-bottom: 4px;
        }
        .button {
            text-align: center;
        }
    </style>
</head>

<body>
    <f:view>
        <h:form>
            <div class="form-container">
                <h2>Register Subscribed Member</h2>

                <div class="field">
                    <label>Recipient ID (HID):</label>
                    <h:inputText value="#{subscribedMemberController.recipientId}" required="true" />
                </div>

                <div class="field">
                    <label>Subscription ID:</label>
                    <h:inputText value="#{subscribedMemberController.subscriptionId}" required="true" />
                </div>

                <div class="field">
                    <label>Full Name:</label>
                    <h:inputText value="#{subscribedMemberController.member.fullName}" required="true" />
                </div>

                <div class="field">
                    <label>Date of Birth:</label>
                    <h:inputText value="#{subscribedMemberController.member.dob}" required="true">
                        <f:convertDateTime pattern="yyyy-MM-dd" />
                    </h:inputText>
                </div>

                <div class="field">
                    <label>Age:</label>
                    <h:inputText value="#{subscribedMemberController.member.age}" required="true" />
                </div>

                <div class="field">
                    <label>Gender:</label>
                    <h:selectOneMenu value="#{subscribedMemberController.member.gender}">
                        <f:selectItem itemLabel="--Select--" itemValue="" />
                        <f:selectItem itemLabel="Male" itemValue="Male" />
                        <f:selectItem itemLabel="Female" itemValue="Female" />
                        <f:selectItem itemLabel="Other" itemValue="Other" />
                    </h:selectOneMenu>
                </div>

                <div class="field">
                    <label>Relation With Proposer:</label>
                    <h:selectOneMenu value="#{subscribedMemberController.member.relationWithProposer}">
                        <f:selectItem itemLabel="--Select--" itemValue="" />
                        <f:selectItems value="#{subscribedMemberController.relationOptions}" />
                    </h:selectOneMenu>
                </div>

                <div class="field">
                    <label>Aadhar Number:</label>
                    <h:inputText value="#{subscribedMemberController.member.aadharNo}" required="true" />
                </div>

                <div class="button">
                    <h:commandButton value="Save Member" action="#{subscribedMemberController.save}" />
                </div>
            </div>
        </h:form>
    </f:view>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Add Subscribed Member</title>
    <style>
        body {
            background-color: #f5f8fa;
            font-family: Arial, sans-serif;
        }
        .card {
            width: 500px;
            margin: 40px auto;
            padding: 25px;
            background-color: white;
            box-shadow: 0 0 10px #aaa;
            border-radius: 10px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #0066cc;
        }
        label {
            font-weight: bold;
        }
        .form-row {
            margin-bottom: 15px;
        }
    </style>
</head>

<body>
    <f:view>
        <h:form>
            <div class="card">
                <h2>Subscribe a Family Member</h2>

                <div class="form-row">
                    <h:outputLabel value="Full Name:" for="fullName" />
                    <h:inputText id="fullName" value="#{subscribedMemberController.member.fullName}" required="true" />
                </div>

                <div class="form-row">
                    <h:outputLabel value="Date of Birth:" for="dob" />
                    <h:inputText id="dob" value="#{subscribedMemberController.member.dob}" required="true" />
                </div>

                <div class="form-row">
                    <h:outputLabel value="Age:" for="age" />
                    <h:inputText id="age" value="#{subscribedMemberController.member.age}" required="true" />
                </div>

                <div class="form-row">
                    <h:outputLabel value="Gender:" for="gender" />
                    <h:selectOneMenu id="gender" value="#{subscribedMemberController.member.gender}" required="true">
                        <f:selectItem itemLabel="--Select--" itemValue="" />
                        <f:selectItem itemLabel="Male" itemValue="Male" />
                        <f:selectItem itemLabel="Female" itemValue="Female" />
                        <f:selectItem itemLabel="Other" itemValue="Other" />
                    </h:selectOneMenu>
                </div>

                <div class="form-row">
                    <h:outputLabel value="Relation with Proposer:" for="relation" />
                    <h:selectOneMenu id="relation" value="#{subscribedMemberController.member.relationWithProposer}" required="true">
                        <f:selectItem itemLabel="--Select--" itemValue="" />
                        <f:selectItem itemLabel="Self" itemValue="Self" />
                        <f:selectItem itemLabel="Spouse" itemValue="Spouse" />
                        <f:selectItem itemLabel="Child" itemValue="Child" />
                        <f:selectItem itemLabel="Parent" itemValue="Parent" />
                    </h:selectOneMenu>
                </div>

                <div class="form-row">
                    <h:outputLabel value="Aadhar No:" for="aadhar" />
                    <h:inputText id="aadhar" value="#{subscribedMemberController.member.aadharNo}" required="true" />
                </div>

                <div class="form-row">
                    <h:outputLabel value="Use Existing Subscription?" for="useSub" />
                    <h:selectOneMenu id="useSub" value="#{subscribedMemberController.useExistingSubscription}">
                        <f:selectItem itemLabel="Yes" itemValue="yes" />
                        <f:selectItem itemLabel="No (Create New)" itemValue="no" />
                    </h:selectOneMenu>
                </div>

                <div class="form-row">
                    <h:outputLabel value="Select Subscription ID:" for="subId" />
                    <h:inputText id="subId" value="#{subscribedMemberController.selectedSubscriptionId}" />
                </div>

                <div class="form-row" style="text-align: center;">
                    <h:commandButton value="Save Member" action="#{subscribedMemberController.save}" style="background-color:#007BFF; color:white; padding:8px 15px; border:none; border-radius:5px;" />
                </div>
            </div>
        </h:form>
    </f:view>
</body>
</html>
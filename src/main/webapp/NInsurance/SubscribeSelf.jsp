<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Subscribe Self</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f2f2f2;
            margin: 0;
            padding: 40px;
        }
        .card {
            width: 500px;
            margin: auto;
            background: #fff;
            padding: 25px 35px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 15px;
        }
        .inputField {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .submitBtn {
            width: 100%;
            margin-top: 25px;
            background-color: #3498db;
            color: white;
            padding: 12px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
        }
        .submitBtn:hover {
            background-color: #2980b9;
            cursor: pointer;
        }
    </style>
</head>

<body>
    <f:view>
        <div class="card">
            <h2>Subscribe - Self Member</h2>

            <h:form>
                <!-- Use Existing Subscription? -->
                <label>Use Existing Subscription?</label>
                <h:selectOneMenu value="#{subscribedMemberController.useExistingSubscription}" styleClass="inputField">
                    <f:selectItem itemValue="yes" itemLabel="Yes" />
                    <f:selectItem itemValue="no" itemLabel="No" />
                </h:selectOneMenu>

                <!-- If using existing subscription, enter ID -->
                <label>Subscription ID (if existing)</label>
                <h:inputText value="#{subscribedMemberController.selectedSubscriptionId}" styleClass="inputField" />

                <!-- Full Name -->
                <label>Full Name</label>
                <h:inputText value="#{subscribedMemberController.member.fullName}" styleClass="inputField" />

                <!-- Date of Birth -->
                <label>Date of Birth</label>
                <h:inputText value="#{subscribedMemberController.member.dob}" styleClass="inputField">
                    <f:convertDateTime pattern="yyyy-MM-dd" />
                </h:inputText>

                <!-- Age -->
                <label>Age</label>
                <h:inputText value="#{subscribedMemberController.member.age}" styleClass="inputField" />

                <!-- Gender -->
                <label>Gender</label>
                <h:selectOneMenu value="#{subscribedMemberController.member.gender}" styleClass="inputField">
                    <f:selectItem itemValue="Male" itemLabel="Male" />
                    <f:selectItem itemValue="Female" itemLabel="Female" />
                    <f:selectItem itemValue="Other" itemLabel="Other" />
                </h:selectOneMenu>

                <!-- Relation with Proposer -->
                <label>Relation with Proposer</label>
                <h:selectOneMenu value="#{subscribedMemberController.member.relationWithProposer}" styleClass="inputField">
                    <f:selectItem itemValue="Self" itemLabel="Self" />
                    <f:selectItem itemValue="Spouse" itemLabel="Spouse" />
                    <f:selectItem itemValue="Son" itemLabel="Son" />
                    <f:selectItem itemValue="Daughter" itemLabel="Daughter" />
                    <f:selectItem itemValue="Father" itemLabel="Father" />
                    <f:selectItem itemValue="Mother" itemLabel="Mother" />
                    <f:selectItem itemValue="Other" itemLabel="Other" />
                </h:selectOneMenu>

                <!-- Aadhaar Number -->
                <label>Aadhaar Number</label>
                <h:inputText value="#{subscribedMemberController.member.aadharNo}" styleClass="inputField" />

                <!-- Submit Button -->
                <h:commandButton value="Subscribe" action="#{subscribedMemberController.save}" styleClass="submitBtn" />
            </h:form>
        </div>
    </f:view>
</body>
</html>
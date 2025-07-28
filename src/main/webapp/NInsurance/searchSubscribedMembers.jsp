<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<html>
<head>
    <title>Search Subscribed Members</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            padding: 30px;
        }

        h1 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 30px;
        }

        .form-container {
            display: flex;
            justify-content: center;
            margin-bottom: 30px;
        }

        .form-box {
            background-color: white;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: inline-block;
            width: 180px;
            font-weight: bold;
        }

        input[type="text"] {
            padding: 8px;
            width: 220px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            margin-top: 10px;
            background-color: #2563eb;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 6px;
            font-size: 14px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #1d4ed8;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 100%;
            background-color: white;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #2c3e50;
            color: white;
        }

        h2 {
            margin-top: 40px;
            text-align: center;
            color: #333;
        }
    </style>
</head>
<body>
<f:view>

    <h1>Search Subscribed Members</h1>

    <div class="form-container">
        <h:form styleClass="form-box">
            <div class="form-group">
                <label>Subscription ID:</label>
                <h:inputText value="#{subscribedMemberController.subscriptionId}" />
            </div>
            <div class="form-group">
                <label>Recipient H-ID:</label>
                <h:inputText value="#{subscribedMemberController.hId}" />
            </div>
            <div class="form-group">
                <label>Date of Birth (yyyy-MM-dd):</label>
                <h:inputText value="#{subscribedMemberController.dobString}" />
            </div>
            <h:commandButton value="Search" action="#{subscribedMemberController.searchSubscribedMembers}" styleClass="btn" />
        </h:form>
    </div>

    <h:panelGroup rendered="#{not empty subscribedMemberController.searchResults}">
        <h2>Search Results</h2>
        <h:dataTable value="#{subscribedMemberController.searchResults}" var="member" border="1">

            <h:column>
                <f:facet name="header"><h:outputText value="Member ID" /></f:facet>
                <h:outputText value="#{member.memberId}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Full Name" /></f:facet>
                <h:outputText value="#{member.fullName}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="DOB" /></f:facet>
                <h:outputText value="#{member.dob}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Gender" /></f:facet>
                <h:outputText value="#{member.gender}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Relation" /></f:facet>
                <h:outputText value="#{member.relationWithProposer}" />
            </h:column>

            <h:column>
                <f:facet name="header"><h:outputText value="Aadhar No" /></f:facet>
                <h:outputText value="#{member.aadharNo}" />
            </h:column>

        </h:dataTable>
    </h:panelGroup>

</f:view>
</body>
</html>

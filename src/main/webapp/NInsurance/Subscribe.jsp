<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Subscribe to Insurance Plan</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef2f7;
            margin: 0;
            padding: 0;
        }

        .form-container {
            width: 700px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.1);
        }

        h2, h3 {
            text-align: center;
            color: #333;
        }

        .label {
            font-weight: bold;
        }

        .field {
            padding-bottom: 8px;
        }

        .button-blue {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 15px;
            min-width: 140px;
        }

        .button-blue:hover {
            background-color: #0056b3;
        }

        .button-row {
            margin-top: 30px;
            text-align: center;
        }

        .message-error {
            color: red;
            text-align: center;
        }

        /* Align fetch button */
        .fetch-row {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        /* Confirmation Popup */
        .popup-overlay {
            display: none;
            position: fixed;
            top: 0; left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0,0,0,0.4);
            z-index: 1000;
        }

        .popup-box {
            background-color: white;
            padding: 25px;
            width: 400px;
            margin: 150px auto;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 0 10px rgba(0,0,0,0.3);
        }

        .popup-buttons {
            margin-top: 20px;
        }

        .popup-buttons button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            margin: 0 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            min-width: 80px;
        }

        .popup-buttons button:hover {
            background-color: #0056b3;
        }
    </style>

    <script>
        function showCancelPopup() {
            document.getElementById('popupOverlay').style.display = 'block';
        }

        function hideCancelPopup() {
            document.getElementById('popupOverlay').style.display = 'none';
        }

        function confirmCancel() {
            window.location.href = 'ExploreInsurance2.jsp'; // Update as per routing setup
        }
    </script>
</head>
<body>
    <f:view>
        <h:form styleClass="form-container">

            <h2>Subscribe to Plan: 
                <h:outputText value="#{subscriptionController.selectedPlan.planName}" />
            </h2>
            <hr />

            <!-- Display JSF messages -->
            <h:messages styleClass="message-error" />

            <!-- ========== Coverage Option Dropdown ========== -->
            <h3>Coverage Options:</h3>
            <h:panelGrid columns="2" columnClasses="label,field" cellpadding="6">
                <h:outputLabel for="coverageOption" value="Select Coverage Option:" />
                <h:selectOneMenu id="coverageOption" value="#{subscriptionController.selectedCoverageId}" required="true">
                    <f:selectItem itemLabel="-- Select Coverage --" itemValue="" />
                    <f:selectItems value="#{subscriptionController.coverageOptions}" 
                                   var="cov"
                                   itemValue="#{cov.coverageId}"
                                   itemLabel="#{cov.coverageId} - ₹#{cov.premiumAmount} / ₹#{cov.coverageAmount}" />
                </h:selectOneMenu>
            </h:panelGrid>

            <br/>

            <!-- ========== Recipient Details Section ========== -->
            <h3>Recipient Details:</h3>
            <h:panelGrid columns="2" cellpadding="5">
                <!-- Recipient ID + Fetch Button -->
                <h:outputLabel value="Recipient ID (HID):" />
                <h:panelGroup layout="block">
                    <div class="fetch-row">
                        <h:inputText value="#{subscriptionController.recipient.hId}" required="true" />
                        <h:commandButton value="Fetch" action="#{subscriptionController.fetchRecipientDetails}" styleClass="button-blue" />
                    </div>
                </h:panelGroup>

                <!-- Auto-Filled Fields -->
                <h:outputLabel value="First Name:" />
                <h:inputText value="#{subscriptionController.recipient.firstName}" disabled="true" />

                <h:outputLabel value="Last Name:" />
                <h:inputText value="#{subscriptionController.recipient.lastName}" disabled="true" />

                <h:outputLabel value="Gender:" />
                <h:inputText value="#{subscriptionController.recipient.gender}" disabled="true" />

                <h:outputLabel value="Date of Birth:" />
                <h:inputText value="#{subscriptionController.recipient.dob}" disabled="true" />

                <h:outputLabel value="Email:" />
                <h:inputText value="#{subscriptionController.recipient.email}" disabled="true" />

                <h:outputLabel value="Mobile:" />
                <h:inputText value="#{subscriptionController.recipient.mobile}" disabled="true" />
            </h:panelGrid>

            <!-- ========== Form Action Buttons ========== -->
            <div class="button-row">
                <h:commandButton value="Subscribe Now" action="#{subscriptionController.saveSubscription}" styleClass="button-blue" />
                <h:commandButton value="Cancel" onclick="showCancelPopup(); return false;" styleClass="button-blue" />
            </div>
        </h:form>

        <!-- ========== Cancel Confirmation Popup ========== -->
        <div id="popupOverlay" class="popup-overlay">
            <div class="popup-box">
                <h3>Are you sure you want to go back?</h3>
                <div class="popup-buttons">
                    <button onclick="confirmCancel()">Yes</button>
                    <button onclick="hideCancelPopup()">No</button>
                </div>
            </div>
        </div>
    </f:view>
</body>
</html>
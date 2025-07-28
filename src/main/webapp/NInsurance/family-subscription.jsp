<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>

<f:view>
<html>
<head>
    <title>Family Health Insurance Subscription</title>
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
        .family-member-box {
            border: 1px solid #ddd;
            padding: 15px;
            margin-bottom: 15px;
            border-radius: 5px;
        }
        .button-row {
            margin-top: 30px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }
        .button-blue {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }
        .button-blue:hover {
            background-color: #0056b3;
        }
        .message-error {
            color: red;
            text-align: center;
        }
        .margin-left {
            margin-left: 10px;
        }

        /* Cancel Popup */
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
            window.location.href = 'ExploreInsurance2.jsf';
        }
    </script>
</head>
<body>
    <h:form styleClass="form-container">
        <h2>Family Subscription to Plan:  
            <h:outputText value="#{subscriptionController.selectedPlan.planName}" />
        </h2>
        
        <h:messages styleClass="message-error" globalOnly="true"/>
        
        <h3>Select Coverage Option</h3>
        <h:selectOneMenu value="#{subscriptionController.selectedCoverageId}" required="true" style="width:100%">
            <f:selectItem itemLabel="-- Select Coverage --" itemValue="" />
            <f:selectItems value="#{subscriptionController.coverageOptions}" 
                         var="coverage"
                         itemValue="#{coverage.coverageId}"
                         itemLabel="#{coverage.coverageId} - ₹#{coverage.premiumAmount} (Coverage: ₹#{coverage.coverageAmount})" />
        </h:selectOneMenu>

        <h3>Primary Subscriber Details</h3>
        <h:panelGrid columns="2" cellpadding="5">
            <h:outputLabel for="proposerHid" value="Your HID:" />
            <h:panelGroup>
                <h:inputText id="proposerHid" value="#{subscriptionController.recipient.hId}" required="true" />
                <h:commandButton value="Fetch Details" action="#{subscriptionController.fetchRecipientDetails}" styleClass="button-blue margin-left" />
            </h:panelGroup>
            
            <h:outputLabel value="Name:" />
            <h:outputText value="#{subscriptionController.recipient.firstName} #{subscriptionController.recipient.lastName}" />
            
            <h:outputLabel value="Date of Birth:" />
            <h:outputText value="#{subscriptionController.recipient.dob}" />
        </h:panelGrid>

        <h3>Family Members to Include</h3>

        <h:commandButton value="Add Family Member"
                         action="#{subscriptionController.addFamilyMember}"
                         styleClass="button-blue"
                         disabled="#{subscriptionController.familyMembers.size() ge 4}" />

        <h:panelGroup rendered="#{subscriptionController.familyMembers.size() ge 4}" layout="block">
            <h:outputText value="Maximum of 4 family members allowed." style="color:red; font-weight:bold;" />
        </h:panelGroup>

        <h:dataTable value="#{subscriptionController.familyMembers}" var="member" style="width:100%">
            <h:column>
                <div class="family-member-box">
                    <h:panelGrid columns="2" cellpadding="5">
                        <h:outputLabel value="Member HID:" />
                        <h:panelGroup>
                            <h:inputText value="#{member.hId}" required="true" />
                            <h:commandButton value="Fetch" 
                                             action="#{subscriptionController.fetchFamilyMemberDetails(member)}" 
                                             styleClass="button-blue margin-left" />
                        </h:panelGroup>

                        <h:outputLabel value="Relationship:" />
                        <h:selectOneMenu value="#{member.relationWithProposer}">
                            <f:selectItem itemValue="Spouse" itemLabel="Spouse" />
                            <f:selectItem itemValue="Child" itemLabel="Child" />
                            <f:selectItem itemValue="Parent" itemLabel="Parent" />
                        </h:selectOneMenu>

                        <h:outputLabel value="Full Name:" />
                        <h:outputText value="#{member.fullName}" />

                        <h:outputLabel value="Date of Birth:" />
                        <h:outputText value="#{member.dob}" />

                        <h:outputLabel value="Gender:" />
                        <h:outputText value="#{member.gender}" />

                        <h:outputLabel value="" />
                        <h:commandButton value="Remove" action="#{subscriptionController.removeFamilyMember(member)}" styleClass="button-blue" />
                    </h:panelGrid>
                </div>
            </h:column>
        </h:dataTable>

        <!-- Action Buttons -->
        <div class="button-row">
            <h:commandButton value="Complete Subscription" 
                           action="#{subscriptionController.saveFamilySubscription}" 
                           styleClass="button-blue" />
            <h:commandButton value="Cancel" 
                           onclick="showCancelPopup(); return false;"
                           styleClass="button-blue" />
        </div>
    </h:form>

    <!-- Cancel Confirmation Popup -->
    <div id="popupOverlay" class="popup-overlay">
        <div class="popup-box">
            <h3>Are you sure you want to go back?</h3>
            <div class="popup-buttons">
                <button onclick="confirmCancel()">Yes</button>
                <button onclick="hideCancelPopup()">No</button>
            </div>
        </div>
    </div>
</body>
</html>
</f:view>
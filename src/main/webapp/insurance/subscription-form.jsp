<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<f:view>
<html>
<head>
<title>Subscription Form</title>
</head>
<body>
	
		<h:form>
			<h3>Subscription Details</h3>
			<table>
				<tr>
					<td>Subscription ID:</td>
					<td><h:inputText
							value="#{subscriptionController.subscription.subscriptionId}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td>Recipient ID:</td>
					<td><h:inputText
							value="#{subscriptionController.recipient.hId}" required="true" />
					</td>
				</tr>
				<tr>
					<td>Coverage ID:</td>
					<td><h:inputText
							value="#{subscriptionController.insuranceCoverageOption.coverageId}"
							required="true" /></td>
				</tr>
				<tr>
					<td>Subscribe Date:</td>
					<td><h:inputText
							value="#{subscriptionController.subscription.subscribeDate}"
							required="true">
							<f:convertDateTime pattern="yyyy-MM-dd" />
						</h:inputText></td>
				</tr>
				<tr>
					<td>Expiry Date:</td>
					<td><h:inputText
							value="#{subscriptionController.subscription.expiryDate}"
							required="true">
							<f:convertDateTime pattern="yyyy-MM-dd" />
						</h:inputText></td>
				</tr>
				<tr>
					<td>Status:</td>
					<td><h:selectOneMenu
							value="#{subscriptionController.subscription.status}">
							<f:selectItem itemLabel="-- Select Status --" itemValue="" />
							<f:selectItem itemLabel="Active" itemValue="ACTIVE" />
							<f:selectItem itemLabel="Expired" itemValue="EXPIRED" />
						</h:selectOneMenu></td>
				</tr>
				<tr>
					<td>Total Premium:</td>
					<td><h:inputText
							value="#{subscriptionController.subscription.totalPremium}"
							required="true">
							<f:convertNumber />
						</h:inputText></td>
				</tr>
				<tr>
					<td>Amount Paid:</td>
					<td><h:inputText
							value="#{subscriptionController.subscription.amountPaid}"
							required="true">
							<f:convertNumber />
						</h:inputText></td>
				</tr>
			</table>
			<br />
			<h:commandButton value="Save Subscription"
				action="#{subscriptionController.saveSubscription}" />
		</h:form>
	
</body>
</html>
</f:view>
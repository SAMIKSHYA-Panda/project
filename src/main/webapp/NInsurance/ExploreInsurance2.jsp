<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<title>Explore Insurance Plans</title>
<style>
body {
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	background-color: #f0f4f8;
	padding: 30px;
	margin: 0;
}

h2 {
	color: #1e3a8a;
	text-align: center;
	margin-bottom: 30px;
}

.top-link {
	display: inline-block;
	margin-bottom: 30px;
	font-size: 16px;
	color: #2563eb;
	text-decoration: none;
	font-weight: bold;
}

.top-link:hover {
	text-decoration: underline;
}

.card-container {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	gap: 20px;
	justify-content: center;
	max-width: 1200px;
	margin: 0 auto;
}

.card {
	background-color: #ffffff;
	border-radius: 12px;
	padding: 20px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s ease;
}

.card:hover {
	transform: translateY(-5px);
}

.card-title {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 10px;
	color: #1f2937;
}

.card-detail {
	margin-bottom: 6px;
	color: #374151;
}

.card-button {
	background-color: #2563eb;
	color: white;
	padding: 8px 16px;
	border: none;
	border-radius: 6px;
	font-size: 14px;
	margin-top: 10px;
	margin-right: 8px;
	cursor: pointer;
}

.card-button:hover {
	background-color: #1d4ed8;
}

/* Responsive override for 5 cards (3 in row 1, 2 in row 2) */
.card-container>.card:nth-child(4), .card-container>.card:nth-child(5) {
	grid-column: span 1;
}

@media screen and (max-width: 1024px) {
	.card-container {
		grid-template-columns: repeat(2, 1fr);
	}
}

@media screen and (max-width: 768px) {
	.card-container {
		grid-template-columns: repeat(1, 1fr);
	}
}

.date-display-table>tbody {
	display: flex;
	flex-direction: row;
	gap: 0.75rem;
	flex-wrap: nowrap;
	padding: 0.5rem 0;
}
</style>
</head>
<body>
	<h:form>
		<h2>Explore Available Insurance Plans</h2>

		<div style="text-align: center;">
			<h:commandLink value="All Subscriptions"
				action="SubscriptionList?faces-redirect=true" styleClass="top-link" />
		</div>

		<div class="card-container">
			<h:dataTable value="#{insurancePlanController.planList}" var="plan"
				border="0" styleClass="date-display-table">
				<h:column>
					<div class="card">
						<h:outputText value="#{plan.planName}" styleClass="card-title" />
						<br />
						<h:outputText value="Plan ID: #{plan.planId}"
							styleClass="card-detail" />
						<br />
						<h:outputText value="Company: #{plan.insuranceCompany.name}"
							styleClass="card-detail" />
						<br />
						<h:outputText value="Type: #{plan.planType}"
							styleClass="card-detail" />
						<br />

						<h:commandButton value="View Details"
							action="#{insurancePlanController.searchPlanById(plan.planId)}"
							styleClass="card-button" />

						<h:commandButton value="Subscribe"
							action="#{subscriptionController.prepareSubscriptionPage(plan)}"
							styleClass="card-button" />
					</div>
				</h:column>
			</h:dataTable>
		</div>
	</h:form>
</body>
	</html>
</f:view>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

<f:view>
	<!DOCTYPE html>
	<html>
<head>
<title>Admin Dashboard</title>
<style>
body {
	margin: 0;
	font-family: 'Segoe UI', sans-serif;
	background: #e3f2fd;
	display: flex;
	flex-direction: column;
	min-height: 100vh; /* Full viewport height */
}

header {
	background-color: #0d47a1;
	color: white;
	padding: 20px;
	text-align: center;
	font-size: 26px;
	font-weight: bold;
}

.welcome {
	text-align: center;
	font-size: 20px;
	margin: 20px;
	color: #333;
}

.container {
	flex: 1;
	display: flex;
	justify-content: center;
	gap: 40px;
	flex-wrap: wrap;
	padding: 30px;
}

.box {
	background: linear-gradient(to bottom right, #ffffff, #bbdefb);
	padding: 25px;
	border-radius: 20px;
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.2);
	width: 280px;
	transition: transform 0.3s;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.box:hover {
	transform: scale(1.05);
}

.box h2 {
	font-size: 20px;
	margin-bottom: 20px;
	color: #0d47a1;
}

.box .btn {
	background-color: #0d47a1;
	color: white;
	border: none;
	padding: 10px 20px;
	margin: 5px;
	border-radius: 8px;
	cursor: pointer;
	font-size: 14px;
	width: 100%;
	text-align: center;
}

.box .btn:hover {
	background-color: #1565c0;
}

footer {
    background-color: #0d47a1;
    color: white;
    text-align: center;
    padding: 15px;
    font-size: 14px;
    margin-top: auto;
}

</style>
</head>
<body>

	<header> Admin Dashboard </header>

	<div class="welcome">Welcome to the Admin Control Panel. Please
		manage your insurance system efficiently.</div>

	<h:form>
		<div class="container">

			<!-- Insurance Company Box -->
			<div class="box">
				<h2>Insurance Company</h2>
				<h:commandButton value="Create Company"
					action="createCompany?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="View Companies"
					action="viewCompanies?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="Update Company"
					action="updateCompany?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="Delete Company"
					action="deleteCompany?faces-redirect=true" styleClass="btn" />
			</div>

			<!-- Insurance Plan Box -->
			<div class="box">
				<h2>Insurance Plan</h2>
				<h:commandButton value="Create Plan"
					action="createPlan?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="View Plans"
					action="viewPlans?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="Update Plan"
					action="updatePlan?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="Delete Plan"
					action="deletePlan?faces-redirect=true" styleClass="btn" />
			</div>

			<!-- Coverage Plan Box -->
			<div class="box">
				<h2>Coverage Plan</h2>
				<h:commandButton value="Create Coverage"
					action="createCoverage?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="View Coverage"
					action="viewCoverage?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="Update Coverage"
					action="updateCoverage?faces-redirect=true" styleClass="btn" />
				<h:commandButton value="Delete Coverage"
					action="deleteCoverage?faces-redirect=true" styleClass="btn" />
			</div>

		</div>
	</h:form>

	<footer>
    &copy; 2025 HealthSure Insurance Company. All rights reserved. <br>
    We offer reliable, affordable, and comprehensive plans <br>
    tailored for everyone.
</footer>


</body>
	</html>
</f:view>
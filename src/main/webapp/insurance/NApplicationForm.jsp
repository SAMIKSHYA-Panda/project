<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
 
<f:view>
<html>
<head>
<title>Tell Us About YourSelf</title>
<style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f0f4f8;
            padding: 2rem;
        }
 
        .form-container {
            max-width: 600px;
            background-color: #ffffff;
            padding: 2rem;
            margin: auto;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
        }
 
        h2 {
            text-align: center;
            color: #4b79a1;
        }
 
        .form-row {
            margin-bottom: 1rem;
        }
 
        label {
            display: block;
            margin-bottom: 0.3rem;
            font-weight: bold;
            color: #333;
        }
 
        input[type="text"], input[type="email"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 0.6rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
 
        .ViewPlans-btn {
            background-color: #1d4ed8;
            color: white;
            padding: 0.8rem 2rem;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block;
            margin: auto;
            font-size: 1rem;
        }
 
        .ViewPlan-btn:hover {
            background-color: #153bb1;
        }
</style>
</head>
<body>
<div class="form-container">
<h2>Tell Us About YourSelf</h2>
 
        <h:form>
<div class="form-row">
<h:outputLabel for="name" value="Full Name:" />
<h:inputText id="name" value="#{userBean.name}" required="true" />
</div>
 
            <div class="form-row">
<h:outputLabel for="email" value="Email Address:" />
<h:inputText id="email" value="#{userBean.email}" required="true" />
</div>
 
            <div class="form-row">
<h:outputLabel for="dob" value="Date of Birth:" />
<h:inputText id="dob" value="#{userBean.dob}" required="true" />
</div>
 
            <div class="form-row">
<h:outputLabel for="phone" value="Mobile Number:" />
<h:inputText id="phone" value="#{userBean.phone}" required="true" />
</div>
 
            <div class="form-row">
<h:commandButton value="ViewPlans" action="NExploreInsurancePlan" styleClass="ViewPlans-btn" />
</div>
</h:form>
</div>
</body>
</html>
</f:view>
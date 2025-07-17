<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<html>
<head>
    <title>Insurance Menu - HealthSure</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 40px;
            position: relative;
        }

        .container {
            max-width: 1000px;
            margin: auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        h1, h2 {
            color: #1e3a8a;
        }

        p {
            font-size: 16px;
            color: #333;
            line-height: 1.6;
        }

        .menu-buttons {
            margin-top: 30px;
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }

        .menu-buttons h:commandButton,
        .top-buttons h:commandButton {
            font-size: 16px;
            padding: 12px 24px;
            background-color: #1d4ed8;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
        }

        .menu-buttons h:commandButton:hover,
        .top-buttons h:commandButton:hover {
            background-color: #2563eb;
        }

        .top-buttons {
            position: absolute;
            top: 20px;
            right: 40px;
            display: flex;
            gap: 20px;
        }

        .top-buttons span {
            font-size: 15px;
            color: #1e3a8a;
            font-weight: bold;
            align-self: center;
        }
    </style>
</head>
<body>
<f:view>
    <h:form>

        <!-- Top right corner buttons -->
        <div class="top-buttons">
            <span>Help: +91-9692543500</span>         
        </div>



        <div class="container">
            <h1>Welcome to HealthSure Insurance Portal</h1>

            <h2>Why Health Insurance?</h2>
            <p>
                Life is uncertain, and medical emergencies can strike at any time. Health insurance provides
                financial protection and peace of mind for you and your family. Whether it's a sudden illness,
                an accident, or planned treatments — insurance helps cover costs, ensuring access to quality
                healthcare without worrying about heavy bills.
            </p>

            <p>
                At HealthSure, we offer a variety of insurance plans tailored to your needs — whether you're
                looking for individual coverage, family protection, or senior care.
            </p>

            <div class="menu-buttons">
                <h:commandButton value="Explore" action="NInsuranceOptions" />
                <h:commandButton value="Explore All Plans" action="ExploreInsurance2" />
                <h:commandButton value="Search Plans" action="SearchPlans" />
                
                 <h:commandButton value="Back" action="Home" />
            </div>
        </div>
    </h:form>
</f:view>
</body>
</html>
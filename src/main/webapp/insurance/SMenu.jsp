<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
    <title> HealthSure Insurance Menu</title>
    <style>
        body {
            background: linear-gradient(to right, #e3f2fd, #ffffff);
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 0;
        }

        .menu-container {
            max-width: 850px;
            margin: 50px auto;
            background: #ffffff;
            border-radius: 20px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            padding: 50px 40px;
            text-align: center;
        }

        .menu-container h1 {
            color: #0d47a1;
            font-size: 2.5em;
            margin-bottom: 15px;
        }

        .menu-container p {
            font-size: 1.25em;
            color: #444;
            line-height: 1.8;
            margin-bottom: 35px;
        }

        .emoji {
            font-size: 1.5em;
            margin-right: 5px;
        }

        .blue-button {
            background-color: #2196f3;
            color: white;
            padding: 15px 35px;
            border: none;
            border-radius: 10px;
            font-size: 1.2em;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        .blue-button:hover {
            background-color: #1565c0;
            transform: scale(1.05);
        }

        .note {
            font-size: 1em;
            color: #777;
            margin-top: 20px;
        }
    </style>
</head>

<body>
<f:view>
    <div class="menu-container">
        <h1>Welcome to HealthSure Insurance </h1>
        <p>
            <span class="emoji"></span> Insurance protects your health, wealth, and peace of mind.<br/>
            <span class="emoji"></span> Health Insurance ensures you get the best medical care without financial stress.<br/>
            <span class="emoji">‍</span> Secure your family's future today — because they deserve the best! 
        </p>

        <h:form>
            <h:commandButton value="Explore Health Insurance"
                             styleClass="blue-button"
                             action="NInsuranceOption.jsp" />
        </h:form>

        <div class="note">
             One click can protect your tomorrow. Stay healthy, stay covered! 
        </div>
    </div>
</f:view>
</body>
</html>
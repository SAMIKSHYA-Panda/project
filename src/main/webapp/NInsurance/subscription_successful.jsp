<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<f:view>
<html>
<head>
    <title>Subscription Successful</title>
    <style>
        body {
            background-color: #e6f2f3;
            font-family: Arial, sans-serif;
        }
        .box {
            width: 50%;
            margin: 100px auto;
            background: #ffffff;
            padding: 30px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }
        .success-message {
            font-size: 22px;
            color: #007b7f;
            margin-bottom: 20px;
        }
        .button {
            background-color: #007b7f;
            color: white;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        .button:hover {
            background-color: #005c5f;
        }
    </style>
</head>
<body>
    <div class="box">
        <div class="success-message">
            Subscription Completed Successfully!
        </div>

        <h:form>
            <h:commandButton value="Back to Plans"
                             action="ExploreInsurance2"
                             styleClass="button" />
        </h:form>
    </div>
</body>
</html>
</f:view>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<!DOCTYPE html>
<html lang="en">
<f:view>
<head>
    <meta charset="UTF-8">
    <title>Insurance Selection</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #e0f7fa;
            padding: 2rem;
            color: #333;
        }

        h1 {
            text-align: center;
            color: #1d3557;
            margin-bottom: 2rem;
        }

        .cards-container {
            display: flex;
            justify-content: center;
            gap: 1.5rem;
            flex-wrap: wrap;
            margin-bottom: 2rem;
        }

        .insurance-card {
            background-color: #ffffff;
            border-radius: 12px;
            padding: 1.5rem;
            width: 200px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            cursor: pointer;
            border: none;
            font-size: 1.1rem;
            font-weight: bold;
            color: #0077b6;
        }

        .insurance-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);
        }
    </style>
</head>
<body>
    <h1>For Whom Do You Want Insurance?</h1>

    <h:form>

        <!-- Row 1 -->
        <div class="cards-container">
            <h:commandButton value="🧍 Self" action="#{insuranceBean.select('self')}" styleClass="insurance-card" />
            <h:commandButton value="👨‍👩‍👧‍👦 Family" action="#{insuranceBean.select('family')}" styleClass="insurance-card" />
            <h:commandButton value="🧓 Senior" action="#{insuranceBean.select('senior')}" styleClass="insurance-card" />
        </div>

        <!-- Row 2 -->
        <div class="cards-container">
            <h:commandButton value="🦸 Super Elite" action="#{insuranceBean.select('superelite')}" styleClass="insurance-card" />
            <h:commandButton value="🦠 Epidemic Elite" action="#{insuranceBean.select('epidemic-elite')}" styleClass="insurance-card" />
        </div>

    </h:form>
</body>
</f:view>
</html>

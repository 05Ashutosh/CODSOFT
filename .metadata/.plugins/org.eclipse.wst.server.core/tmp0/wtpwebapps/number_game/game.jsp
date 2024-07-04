<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Guess the Number Game</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        position: relative;
    }
    .container {
        text-align: center;
        background: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .attempts {
        position: absolute;
        top: 20px;
        left: 20px;
        font-size: 1.2em;
    }
    .total-attempts {
        color: red;
    }
    .user-attempts {
        color: green;
    }
    label {
        font-size: 1.2em;
        margin-bottom: 10px;
        display: inline-block;
    }
    input[type="number"] {
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        width: 80%;
        margin-bottom: 20px;
        font-size: 1em;
    }
    button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1em;
    }
    button:hover {
        background-color: #0056b3;
    }
    p {
        font-size: 1.1em;
        color: #333;
    }
</style>
<script>
	    window.onload = function() {
        document.getElementById("guess").focus();
    }
</script>
</head>
<body>
    <div class="attempts">
        <% 
            Integer attempts = (Integer) session.getAttribute("attempts");
            Integer maxAttempts = (Integer) session.getAttribute("maxAttempts");
        %>
        <% if (attempts != null && maxAttempts != null) { %>
            <div class="user-attempts">Your Attempts: <%= attempts %></div>
            <div class="total-attempts">Total Attempts: <%= maxAttempts %></div>
        <% } %>
    </div>
    <div class="container">
        <h1>Guess the Number Game</h1>
        <form action="GameLogicServlet" method="post">
            <label for="guess">Guess the number: </label>
            <input type="number" id="guess" name="guess" required>
            <button type="submit">Submit</button>
        </form>
        <% String message = (String) request.getAttribute("message"); %>
        <% if (message != null) { %>
            <p><%= message %></p>
        <% } %>
    </div>
</body>
</html>

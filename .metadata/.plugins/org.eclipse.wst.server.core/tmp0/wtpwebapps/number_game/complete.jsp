<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number Game</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f8ff;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        color: #333;
    }
    .score {
        position: absolute;
        top: 20px;
        left: 20px;
        font-size: 1.2em;
        color: red;
    }
    .container {
        text-align: center;
        background: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 15px rgba(0,0,0,0.1);
        max-width: 500px;
    }
    h1 {
        font-size: 2.5em;
        color: #007bff;
        margin: 0;
    }
    p {
        font-size: 1.2em;
        color: #555;
    }
    button {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
        font-size: 1em;
        margin-top: 20px;
    }
    button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
    <div class="score">
        <% 
            Integer attempts = (Integer) session.getAttribute("attempts");
            if (attempts != null) {
                int score = 10 - attempts;
                if (score < 0) {
                    score = 0;
                }
                out.println("Your score is: " + score);
            } else {
                out.println("Thank you for playing!");
            }
        %>
    </div>
    <div class="container">
        <h1>Game Over</h1>
        <p><% 
            if (attempts != null) {
                out.println("You guessed the number in " + attempts + " attempts.");
            }
        %></p>
        <form action="GenerateNumberServlet">
            <button type="submit">Play Again</button>
        </form>
    </div>
</body>
</html>

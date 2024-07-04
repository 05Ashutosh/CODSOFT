<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Number Game</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
            background-color: #f0f8ff;
        }
        .main_body {
            width: 100vw;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .box {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            width: 90%;
        }
        h1 {
            margin-bottom: 10px;
            font-size: 24px;
            color: #333;
        }
        p {
            margin-bottom: 20px;
            font-size: 18px;
            color: #666;
        }
        #start {
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background-color: darkblue;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        #start:hover {
            background-color: navy;
        }
    </style>
</head>

<body>
    <div class="main_body">
        <div class="box">
            <h1>Number Game</h1>
            <p>Click the button to start the game</p>
            <button id="start" onclick="showAlert()">Start</button>
        </div>
    </div>
<script>
    function showAlert(){
        if(confirm("Generate a random number?")){
            window.location.href="GenerateNumberServlet";
        }
    }
</script>
</body>
</html>

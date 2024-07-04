<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #121212;
    color: #e0e0e0;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background-color: #1e1e1e;
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
    width: 300px;
    text-align: center;
}

h1 {
    color: #ffffff;
    font-size: 24px;
    margin-bottom: 20px;
}

p {
    font-size: 16px;
    margin: 10px 0;
}

p span {
    font-weight: bold;
    color: #bb86fc;
}

a.btn {
    display: inline-block;
    margin-top: 20px;
    padding: 10px 20px;
    background-color: #6200ea;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}

a.btn:hover {
    background-color: #3700b3;
}

</style>
</head>
<body>
    <div class="container">
        <h1>Result</h1>
        <p>Total Marks: <span><%= request.getAttribute("totalMarks") %></span></p>
        <p>Percentage: <span><%= request.getAttribute("Percentage") %> %</span></p>
        <p>Grade: <span><%= request.getAttribute("grade") %></span></p>
        <a href="index.jsp" class="btn">Calculate Again</a>
    </div>
</body>
</html>

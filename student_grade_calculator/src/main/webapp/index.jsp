<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Grade Calculator</title>
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

h2 {
    color: #bbbbbb;
    font-size: 18px;
    margin-bottom: 10px;
}

label {
    display: block;
    font-size: 14px;
    margin: 10px 0 5px;
    text-align: left;
    color: #e0e0e0;
}

input[type="number"] {
    width: 100%;
    padding: 8px;
    margin-bottom: 10px;
    border: 1px solid #333;
    border-radius: 5px;
    background-color: #2b2b2b;
    color: #e0e0e0;
    box-sizing: border-box;
}

input[type="submit"] {
    background-color: #6200ea;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    width: 100%;
}

input[type="submit"]:hover {
    background-color: #3700b3;
}

	
</style>
</head>
<body>
    <div class="container">
        <h2>Task 2</h2>
        <h1>Enter Marks for Each Subject</h1>
        <form action="CalculatorGradeServlet" method="post">
            <label for="maths">Maths</label>
            <input type="number" max=100 min=0 id="maths" name="maths" required>
            <br>
            <label for="science">Science</label>
            <input type="number" max=100 min=0 id="science" name="science" required>
             <br>
            <label for="english">English</label>
            <input type="number" max=100 min=0 id="english" name="english" required>
            <br>
            <label for="cs">Computer Science</label>
            <input type="number" max=100 min=0 id="cs" name="cs" required>
            <br>
            <label for="os">Operating System</label>
            <input type="number" max=100 min=0 id="os" name="os" required>
            <br>
            <input type="submit" value="Calculate">
        </form>
    </div>
</body>
</html>

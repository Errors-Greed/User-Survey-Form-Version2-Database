<%-- 
    Document   : error
    Created on : Jul 9, 2026, 2:43:47 PM
    Author     : ex0ti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

    <h1>Survey Error</h1>

    <p style="color:red; font-weight:bold;">
        An error occurred while processing your survey.
    </p>

    <p>
        Possible causes include:
    </p>

    <ul>
        <li>Invalid or missing input.</li>
        <li>Unable to connect to the database.</li>
        <li>The survey record could not be saved or updated.</li>
    </ul>

    <br>
    <!-- Attempting to center the button to make it look pretty-->
    <form action="index.jsp" method="get" style="background-color: wheat;">
        <button type="submit" value="Return to Survey">Submit Survey</button>
    </form>

</body>
</html>

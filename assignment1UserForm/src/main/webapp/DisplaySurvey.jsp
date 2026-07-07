<%-- 
    Document   : DisplaySurvey
    Created on : Jun 25, 2026, 1:25:16 PM
    Author     : ex0ti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="surveyData" class="mypack.SurveyBean" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Results</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Survey Results Submitted</h1>
        
        <form>
            <fieldset>
                <legend>Personal & Contact Details</legend>
                <p><strong>Name: </strong><jsp:getProperty name="surveyData" property="name"/></p>
                <p><strong>Email: </strong><jsp:getProperty name="surveyData" property="email"/></p>
                <p><strong>Phone: </strong><jsp:getProperty name="surveyData" property="phone"/></p>
                <p><strong>Age: </strong><jsp:getProperty name="surveyData" property="age"/></p>
                <p><strong>Gender: </strong><jsp:getProperty name="surveyData" property="gender"/></p>
            </fieldset>
            
            <fieldset>
                <legend>Education & Employment</legend>
                <p><strong>Qualification:</strong> <jsp:getProperty name="surveyData" property="qualification" /></p>
                <p><strong>Employment Status:</strong> <jsp:getProperty name="surveyData" property="employment" /></p>
            </fieldset>
            
            <fieldset>
            <legend>Technical Skills</legend>
            <p><strong>Proficiency Level:</strong> <jsp:getProperty name="surveyData" property="proficiency" /> / 10</p>
            <p><strong>Selected Skills:</strong></p>
            <ul>
                <% 
                    String[] selectedSkills = surveyData.getSkills();
                    if (selectedSkills != null && selectedSkills.length > 0) {
                        for (int i = 0; i < selectedSkills.length; i++) {
                            out.println("<li>" + selectedSkills[i] + "</li>");
                        }
                    } else {
                        out.println("<li>No skills selected.</li>");
                    }
                %>
            </ul>
            </fieldset>
            
            <fieldset>
                <Legend>Resume</Legend>
                <p><strong>Resume:</strong>
                    <%
                        String file=surveyData.getResume();
                        out.println("<a href="+file+">"+file+"</a>");
                    %>    
                    
            </fieldset>
            
            <fieldset>
                <legend>User Feedback</legend>
                <p><strong>Comments:</strong><jsp:getProperty name="surveyData" property="comments"/></p>
            </fieldset>
        </form>
    </body>
</html>

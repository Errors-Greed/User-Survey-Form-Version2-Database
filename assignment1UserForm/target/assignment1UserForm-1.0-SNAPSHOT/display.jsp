<%-- 
    Document   : dsiplay
    Created on : Jul 9, 2026, 12:14:16 PM
    Author     : ex0ti
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="mypack.SurveyBean" %>


<%
    SurveyBean surveyData = (SurveyBean) request.getAttribute("surveyData");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Survey Details</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        
        <h1>Survey Submitted Successfully</h1>

    <p style="color:green; font-weight:bold;" align="center">
        Your survey details have been successfully saved.
    </p>

    <table border="1" cellpadding="8" align="center">

        <tr>
            <th>Name</th>
            <td><%= surveyData.getName() %></td>
        </tr>

        <tr>
            <th>Email</th>
            <td><%= surveyData.getEmail() %></td>
        </tr>

        <tr>
            <th>Phone</th>
            <td><%= surveyData.getPhone() %></td>
        </tr>

        <tr>
            <th>Age</th>
            <td><%= surveyData.getAge() %></td>
        </tr>

        <tr>
            <th>Gender</th>
            <td><%= surveyData.getGender() %></td>
        </tr>

        <tr>
            <th>Qualification</th>
            <td><%= surveyData.getQualification() %></td>
        </tr>

        <tr>
            <th>Employment</th>
            <td><%= surveyData.getEmployment() %></td>
        </tr>

        <tr>
            <th>Skills</th>
            <td>
                <%
                    String[] skills = surveyData.getSkills();

                    if (skills != null) {
                        for (String skill : skills) {
                            out.print(skill + "<br>");
                        }
                    }
                %>
            </td>
        </tr>

        <tr>
            <th>Proficiency</th>
            <td><%= surveyData.getProficiency() %></td>
        </tr>

        <tr>
            <th>Resume</th>
            <td><%= surveyData.getResume() %></td>
        </tr>

        <tr>
            <th>Comments</th>
            <td><%= surveyData.getComments() %></td>
        </tr>

    </table>

    <br>

    <form action="EditSurveyServlet" method="get" style="background-color: wheat;">

        <input type="hidden"
               name="email"
               value="<%= surveyData.getEmail() %>">
<!-- Attempting to center the button to make it look pretty-->

        <button type="submit" value="Edit Details">Edit Details</button>

    </form>
        
    </body>
</html>

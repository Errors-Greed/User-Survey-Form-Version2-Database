<%-- 
    Document   : editSurvey
    Created on : Jul 9, 2026, 1:52:24 PM
    Author     : ex0ti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mypack.SurveyBean"%>

<%
    SurveyBean surveyData = (SurveyBean) request.getAttribute("surveyData");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Survey</title>
        <link rel="stylesheet" href="style.css">
    </head>
    
    <body>
        
        <h1>Edit Survey Details</h1>
        
        <form action="EditSurveyServlet" method="post">

    <fieldset>
        <legend>Personal Information</legend>

        <label>Name:</label>
        <input type="text"
               name="name"
               value="<%= surveyData.getName() %>"
               required>
        <br><br>

        <label>Email:</label>
        <input type="email"
               name="email"
               value="<%= surveyData.getEmail() %>"
               readonly>
        <br><br>

        <label>Phone:</label>
        <input type="tel"
               name="phone"
               value="<%= surveyData.getPhone() %>">
        <br><br>

        <label>Gender:</label>

        <input type="radio"
               name="gender"
               value="Male"
               <%= "Male".equals(surveyData.getGender()) ? "checked" : "" %>>
        Male

        <input type="radio"
               name="gender"
               value="Female"
               <%= "Female".equals(surveyData.getGender()) ? "checked" : "" %>>
        Female

        <input type="radio"
               name="gender"
               value="Other"
               <%= "Other".equals(surveyData.getGender()) ? "checked" : "" %>>
        Other

    </fieldset>

    <fieldset>

        <legend>Education</legend>

        <label>Qualification:</label>

        <select name="qualification">

            <option value="High School"
            <%= "High School".equals(surveyData.getQualification()) ? "selected" : "" %>>
                High School
            </option>

            <option value="Bachelor's"
            <%= "Bachelor's".equals(surveyData.getQualification()) ? "selected" : "" %>>
                Bachelor's
            </option>

            <option value="Master's"
            <%= "Master's".equals(surveyData.getQualification()) ? "selected" : "" %>>
                Master's
            </option>

            <option value="PhD"
            <%= "PhD".equals(surveyData.getQualification()) ? "selected" : "" %>>
                PhD
            </option>

        </select>

        <br><br>

        <label>Employment:</label>

        <input type="radio"
               name="employment"
               value="Student"
               <%= "Student".equals(surveyData.getEmployment()) ? "checked" : "" %>>
        Student

        <input type="radio"
               name="employment"
               value="Employed"
               <%= "Employed".equals(surveyData.getEmployment()) ? "checked" : "" %>>
        Employed

        <input type="radio"
               name="employment"
               value="Unemployed"
               <%= "Unemployed".equals(surveyData.getEmployment()) ? "checked" : "" %>>
        Unemployed

    </fieldset>

    <fieldset>

        <legend>Technical Skills</legend>

        <%
            String[] skills = surveyData.getSkills();
        %>

        <input type="checkbox"
               name="skills"
               value="Java"
               <%= skills != null && java.util.Arrays.asList(skills).contains("Java") ? "checked" : "" %>>
        Java

        <input type="checkbox"
               name="skills"
               value="Python"
               <%= skills != null && java.util.Arrays.asList(skills).contains("Python") ? "checked" : "" %>>
        Python

        <input type="checkbox"
               name="skills"
               value="HTML/CSS"
               <%= skills != null && java.util.Arrays.asList(skills).contains("HTML/CSS") ? "checked" : "" %>>
        HTML/CSS

        <input type="checkbox"
               name="skills"
               value="JavaScript"
               <%= skills != null && java.util.Arrays.asList(skills).contains("JavaScript") ? "checked" : "" %>>
        JavaScript

        <br><br>

        <label>Proficiency:</label>

        <%
            int prof = surveyData.getProficiency();
        %>

        <!--PROFICIENCY IS NOT WORKING FOR SOME REASON 
            It is not able to get the values into the range-->
        <input type="range"
               name="proficiency"
               min="1"
               max="10"
               value="<%= prof %>">
        
        

    </fieldset>
               
               
    <fieldset>

        <legend>Resume</legend>

        <input type="text"
               name="resume"
               value="<%= surveyData.getResume() %>">

    </fieldset>
               
               
    <fieldset>

        <legend>Feedback</legend>

        <textarea name="comments"
                  rows="5"
                  cols="40"><%= surveyData.getComments() %></textarea>

    </fieldset>

    

    <br>
<!-- Attempting to center the button to make it look pretty-->
    <input type="submit" value="Update Survey">

</form>
        
    </body>
</html>

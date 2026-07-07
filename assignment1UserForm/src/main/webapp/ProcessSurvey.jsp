<%-- 
    Document   : ProcessSurvey
    Created on : Jun 25, 2026, 11:57:51 AM
    Author     : ex0ti
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="surveyData" class="mypack.SurveyBean" scope="request"/>

<jsp:setProperty name="surveyData" property="*" />

<%-- experimental stuuf. it aint workin for some reason --%> 
<%
    surveyData.createTable();
    surveyData.saveSurvey();
%>

<jsp:forward page="DisplaySurvey.jsp"/>

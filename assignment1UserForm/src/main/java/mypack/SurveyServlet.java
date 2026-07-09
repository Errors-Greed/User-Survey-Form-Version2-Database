/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mypack;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * SurveyServlet
 * @author ex0ti
 */
@WebServlet(name = "SurveyServlet", urlPatterns = {"/SurveyServlet"})


public class SurveyServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //The form data thingy
        String name = request.getParameter("name");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        int age=Integer.parseInt(request.getParameter("age"));
        String gender=request.getParameter("gender");
        String qualification=request.getParameter("qualification");
        String employment=request.getParameter("employment");
        String[] skills=request.getParameterValues("skills");
        int proficiency=Integer.parseInt(request.getParameter("proficiency"));
        String comments=request.getParameter("comments");
        String resume=request.getParameter("resume");
        
        //Creating the bean of za Survey
        SurveyBean bean=new SurveyBean();
        
        //The bean properties
        bean.setName(name);
        bean.setEmail(email);
        bean.setPhone(phone);
        bean.setAge(age);
        bean.setGender(gender);
        bean.setQualification(qualification);
        bean.setEmployment(employment);
        bean.setSkills(skills);
        bean.setProficiency(proficiency);
        bean.setComments(comments);
        bean.setResume(resume);
        
        //Save to za database
        boolean success=bean.saveSurvey();
        
        //Show the bean to the jsp
        request.setAttribute("surveyData", bean);
        
        //Thorw it to the appropriate page
        RequestDispatcher rd;
        
        if(success){
            rd=request.getRequestDispatcher("display.jsp");
        }else{
            rd=request.getRequestDispatcher("error.jsp");
        }
        
        rd.forward(request, response);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SurveyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SurveyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

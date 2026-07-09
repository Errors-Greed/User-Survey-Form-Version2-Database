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
 *EditSurveyServlet
 * @author ex0ti
 */
@WebServlet(name = "EditSurveyServlet", urlPatterns = {"/EditSurveyServlet"})
public class EditSurveyServlet extends HttpServlet {

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

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditSurveyServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditSurveyServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email=request.getParameter("email");
        
        SurveyBean bean=new SurveyBean();
        
        if(bean.retrieveSurvey(email)){
            request.setAttribute("surveyData", bean);
            RequestDispatcher rd=request.getRequestDispatcher("editSurvey.jsp");
            
            rd.forward(request,response);
        }else{
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
        }
    }
           
    //Updating the survey
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        SurveyBean bean=new SurveyBean();
        
        bean.setName(request.getParameter("name"));
        bean.setEmail(request.getParameter("email"));
        bean.setPhone(request.getParameter("phone"));
        bean.setAge(Integer.parseInt(request.getParameter("age")));
        bean.setGender(request.getParameter("gender"));
        bean.setQualification(request.getParameter("qualification"));
        bean.setEmployment(request.getParameter("employment"));
        bean.setSkills(request.getParameterValues("skills"));
        bean.setProficiency(Integer.parseInt(request.getParameter("proficiency")));
        bean.setComments(request.getParameter("comments"));
        bean.setResume(request.getParameter("resume"));
        
        
        if(bean.updateSurvey()){
            response.sendRedirect("confirmation.jsp");
        }else{
            RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
            rd.forward(request,response);
        }
        
        
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mypack;

/**
 *
 * @author ex0ti
 */

import java.sql.*;
import java.io.Serializable;

public class SurveyBean implements Serializable {

    private String name;
    private String email;
    private String phone;
    private int age;
    private String gender;
    private String qualification;
    private String employment;
    private String[] skills;
    private int proficiency;
    private String resume;
    private String comments;

    public SurveyBean() {}

    public String getName() { return name; }
    public void setName(String name) { this.name=name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public String getEmployment() { return employment; }
    public void setEmployment(String employment) { this.employment = employment; }

    public String[] getSkills() { return skills; }
    public void setSkills(String[] skills) { this.skills = skills; }

    public int getProficiency() { return proficiency; }
    public void setProficiency(int proficiency) { this.proficiency = proficiency; }

    public String getResume(){return resume;}
    public void setResume(String r){this.resume=r;}
    
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }


    //Everything under is still in development. I am not doing something correct and I am trying to figure it out. 
    public Connection getConnection(){
        Connection conn=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn= DriverManager.getConnection(
            "jdbc:mysql://localhost:3307/surveydb",
            "TheOne",
            "5071");
            //MAKE SURE TO CHANGE THESE IF YOU ARE USING DIFFERENT SERVER
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    
    public void createTable(){
        String sql="CREATE TABLE IF NOT EXISTS survey_data("+
                "id INT AUTO_INCREMENT PRIMARY KEY,"+
                "name VARCHAR(100),"+
                "email VARCHAR(100) UNIQUE,"+
                "phone VARCHAR(20),"+
                "gender VARCHAR(10),"+
                "qualification VARCHAR(50),"+
                "employment VARCHAR(50),"+
                "skills VARCHAR(255),"+
                "proficiency INT,"+
                "comments TEXT,"+
                "resume VARCHAR(255))";
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            
            ps.executeUpdate();
            System.out.println("Table Created Successfully.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean saveSurvey(){
        String sql="INSERT INTO survey_data("+
                    "name, email,phone,gender,qualification,"+
                    "employment,skills,proficiency,comments,resume)"+
                    "VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try(Connection conn=getConnection();
            PreparedStatement ps=conn.prepareStatement(sql)){
            
            ps.setString(1,name );
            ps.setString(2,email);
            ps.setString(3, phone);
            ps.setString(4, gender);
            ps.setString(5, qualification);
            ps.setString(6, employment);
            if(skills !=null){
                ps.setString(7, String.join(", ", skills));
            }else{
                ps.setString(7,"");
            }
            ps.setInt(8, proficiency);
            ps.setString(9, comments);
            ps.setString(10, resume);
            
            
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateSurvey(){
        //imma do tis later. 
        
        String sql="UPDATE survey_data SET "+
                "name=?,"+
                "phone=?,"+
                "gender=?,"+
                "qualification=?,"+
                "employment=?,"+
                "skills=?,"+
                "proficiency=?,"+
                "comments=?,"+
                "resume=? "+
                "WHERE email=?";
        
        try(Connection conn=getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            
            ps.setString(1,name );
            ps.setString(2,phone);
            ps.setString(3, gender);
            ps.setString(4, qualification);
            ps.setString(5, employment);
            if(skills !=null){
                ps.setString(6, String.join(", ", skills));
            }else{
                ps.setString(6,"");
            }
            ps.setInt(7, proficiency);
            ps.setString(8, comments);
            ps.setString(9, resume);
            ps.setString(10, email);
            
            return ps.executeUpdate()>0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    //then is retrieve Survey that needs to be done. 
    //retrieveSurvey(String email)
    public boolean retrieveSurvey(String email){
        String sql="SELECT * FROM survey_data WHERE email=?";
        
        try(Connection conn= getConnection();
                PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1, email);
            
            ResultSet rs=ps.executeQuery();
            
            if(rs.next()){
                name=rs.getString("name");
                this.email=rs.getString("email");
                phone = rs.getString("phone");
                gender = rs.getString("gender");
                qualification = rs.getString("qualification");
                employment = rs.getString("employment");
                
                String ss=rs.getString("skills");
                if(ss !=null && !ss.isEmpty()){
                    skills=ss.split(",\\s*");
                }
                
                proficiency=rs.getInt("proficiency");
                comments=rs.getString("comments");
                resume=rs.getString("resume");
                
                return true;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    
}



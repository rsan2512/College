<%@ include file="navbar.jsp" %>
<%@ include file="dbConnection.jsp" %>

<%
int id = Integer.parseInt(request.getParameter("id"));
Connection con2 = null;

try{
    con2 = con;

    if(request.getMethod().equalsIgnoreCase("POST")){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        int age = Integer.parseInt(request.getParameter("age"));
        float cgpa = Float.parseFloat(request.getParameter("cgpa"));

        PreparedStatement ps = con2.prepareStatement(
            "UPDATE student SET name=?,email=?,course=?,age=?,cgpa=? WHERE id=?");

        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,course);
        ps.setInt(4,age);
        ps.setFloat(5,cgpa);
        ps.setInt(6,id);

        ps.executeUpdate();

        response.sendRedirect("displayStudents.jsp");
    }

    PreparedStatement ps = con2.prepareStatement("SELECT * FROM student WHERE id=?");
    ps.setInt(1,id);
    ResultSet rs = ps.executeQuery();

    if(rs.next()){
%>

<h2>Update Student</h2>

<form method="post">
    Name: <input type="text" name="name" value="<%= rs.getString("name") %>"><br><br>
    Email: <input type="text" name="email" value="<%= rs.getString("email") %>"><br><br>
    Course: <input type="text" name="course" value="<%= rs.getString("course") %>"><br><br>
    Age: <input type="number" name="age" value="<%= rs.getInt("age") %>"><br><br>
    CGPA: <input type="text" name="cgpa" value="<%= rs.getFloat("cgpa") %>"><br><br>

    <input type="submit" value="Update">
</form>

<%
    }
    con2.close();
}catch(Exception e){
    out.println(e);
}
%>

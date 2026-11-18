<%@ include file="navbar.jsp" %>
<%@ include file="dbConnection.jsp" %>

<h2>Add Student</h2>

<form method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="text" name="email"><br><br>
    Course: <input type="text" name="course"><br><br>
    Age: <input type="number" name="age"><br><br>
    CGPA: <input type="text" name="cgpa"><br><br>

    <input type="submit" value="Add Student">
</form>

<%
if(request.getMethod().equalsIgnoreCase("POST")){
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String course = request.getParameter("course");
    int age = Integer.parseInt(request.getParameter("age"));
    float cgpa = Float.parseFloat(request.getParameter("cgpa"));

    try{
        Connection con2 = con;

        PreparedStatement ps = con2.prepareStatement(
            "INSERT INTO student(name,email,course,age,cgpa) VALUES(?,?,?,?,?)");

        ps.setString(1,name);
        ps.setString(2,email);
        ps.setString(3,course);
        ps.setInt(4,age);
        ps.setFloat(5,cgpa);

        ps.executeUpdate();

        out.println("<p style='color:green;'>Student Added Successfully!</p>");

    }catch(Exception e){
        out.println(e);
    }
}
%>

<%@ include file="navbar.jsp" %>
<%@ include file="dbConnection.jsp" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

try{
    Connection con2 = con;
    PreparedStatement ps = con2.prepareStatement("SELECT * FROM student WHERE id=?");
    ps.setInt(1,id);

    ResultSet rs = ps.executeQuery();

    if(rs.next()){
%>

<h2>Student Details</h2>

ID: <%= rs.getInt("id") %><br>
Name: <%= rs.getString("name") %><br>
Email: <%= rs.getString("email") %><br>
Course: <%= rs.getString("course") %><br>
Age: <%= rs.getInt("age") %><br>
CGPA: <%= rs.getFloat("cgpa") %><br>

<%
    }
    con2.close();
}catch(Exception e){
    out.println(e);
}
%>

<%@ include file="navbar.jsp" %>
<%@ include file="dbConnection.jsp" %>

<h2>Student List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Course</th>
    <th>Age</th>
    <th>CGPA</th>
    <th>Actions</th>
</tr>

<%
try{
    Connection con2 = con;
    Statement st = con2.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM student");

    while(rs.next()){
%>
<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("email") %></td>
    <td><%= rs.getString("course") %></td>
    <td><%= rs.getInt("age") %></td>
    <td><%= rs.getFloat("cgpa") %></td>
    <td>
        <a href="studentDetails.jsp?id=<%= rs.getInt("id") %>">Details</a> |
        <a href="updateStudent.jsp?id=<%= rs.getInt("id") %>">Update</a> |
        <a href="deleteStudent.jsp?id=<%= rs.getInt("id") %>">Delete</a>
    </td>
</tr>

<%
    }
    con2.close();
}catch(Exception e){
    out.println(e);
}
%>
</table>

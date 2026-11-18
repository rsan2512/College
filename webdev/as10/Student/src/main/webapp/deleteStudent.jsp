<%@ include file="dbConnection.jsp" %>

<%
int id = Integer.parseInt(request.getParameter("id"));

try{
    Connection con2 = con;
    PreparedStatement ps = con2.prepareStatement("DELETE FROM student WHERE id=?");
    ps.setInt(1,id);

    ps.executeUpdate();

    response.sendRedirect("displayStudents.jsp");

}catch(Exception e){
    out.println(e);
}
%>

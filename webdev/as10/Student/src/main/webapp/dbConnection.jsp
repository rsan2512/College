<%@ page import="java.sql.*" %>

<%
String url = "jdbc:postgresql://localhost:5432/college_db";
String user = "postgres";
String password = "Roshan25";

Connection con = null;

try {
    Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(url, user, password);
} catch(Exception e) {
    out.println("DB Error: " + e.getMessage());
}
%>

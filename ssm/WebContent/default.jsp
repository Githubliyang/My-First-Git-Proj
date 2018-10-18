<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="java.util.List" %>
<%@page import="dao.user" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
List<user> list=(List<user>)request.getAttribute("list");
%>
        <div class="container">
            <table class="table">
                <tr>Optional table caption.
                   <th>Id</th>
                    <th>名字</th>
                    <th>年龄</th>
                    <th>编辑选项</th>
                </tr>
<%for(user u:list){ %>
               <tr>
         <th><%=u.getId() %></th>
         <th><%=u.getName() %></th>
         <th><%=u.getAge() %></th>
       
         <th>
         <input type="button" value="修改" class="btn btn-info" onclick="window.location='update.do?id=<%=u.getId() %>'">
         <input type="button" value="删除" class="btn btn-danger" onclick="window.location='../m/delete.do?id=<%=u.getId() %>'">
         </th>
                </tr>
                  <%} %>
            </table>
        </div>
</body>
</html>
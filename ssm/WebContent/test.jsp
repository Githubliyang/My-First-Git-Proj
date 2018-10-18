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
<form action="updateconfirm.do" method="post">
<%
List<user> list=(List<user>)request.getAttribute("list");
%>
        <div class="container">
            <table class="table">
                <tr>Optional table caption.
                    <th>名字</th>
                    <th>年龄</th>
                    <th>编辑选项</th>
                </tr>
<%for(user u:list){ %>
               <tr>
         <th><input type="text" value="<%=u.getName() %>" name="name"/></th>
         <th><input type="text" value="<%=u.getAge() %>" name="age"/></th>
       <th><input type="hidden" name="id" value="<%=u.getId() %>"/></th>
         <th>
         <input type="submit" value="确认修改" class="btn btn-info"/>
         </th>
                </tr>
                  <%} %>
            </table>
        </div>
        </form>
</body>
</html>
%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Userss">

  <body>
    <h1>Users</h1>

    <c:if test="${pageContext.request.isUserInRole('WRITE_USERS')}">
      <a href="${pageContext.request.contextPath}/AddUser"
         class="btn btn-primary btn-lg">
        Add User
      </a>
    </c:if>
    <div class="container-text-center">
      <div class="row">
        <div class="col">
          Admin
        </div>

        <div class="col">
          admin@gmail.com
        </div>
      </div>
    </div>
  </body>
</t:pageTemplate>


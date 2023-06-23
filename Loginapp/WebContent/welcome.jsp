<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login Page</title>
    <%--Use the latest Bootstrap Ver5.2.2--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--our external CSS stylesheet --%>
    <link rel="stylesheet" href="main.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light">
       <div class="container-fluid app-logo">
        <a class="navbar-brand" href="index.html"><strong>LoginApp</strong></a>
      </div>
      <div class="user-info">
          <ul class="navbar-info mb-2 mb-lg-0">
            <li class="nav-item"><strong>${sessionScope.userid}</strong></li>
            <li class="nav-item"><strong>${sessionScope.role}</strong></li>
            <li class="nav-item logout-btn">
              <form action="LoginServlet" method="get" class="logout-form">
                <button class="btn btn-secondary" type="submit">Logout</button>
              </form>
            </li>
          </ul>
      </div>
    </nav>

    <section class="main-section">
      <div class="container-fluid">
        <div class="card">
          <div class="card-body">
            <h4 class="card-title">
                Welcome
                ${sessionScope.name}
            </h4>
            <% if (session.getAttribute("isManager") != null && (boolean) session.getAttribute("isManager")) { %>
    			<div>
            		<p class="card-text">Click on the button below to access the restricted page.</p>
            		<a href="restricted.jsp" class="btn btn-warning">Manager Access</a>
            	</div>
			<% } %>
            
            
          </div>
        </div>
      </div>
    </section>

    <%--our external script--%>
    <script src="script/main.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
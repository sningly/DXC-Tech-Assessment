<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Restricted Page</title>
    <%--Use the latest Bootstrap Ver5.2.2--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--our external CSS stylesheet--%>
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
            <h4 class="card-title">Restricted Web Page</h4>
            <p class="card-text">This is a restricted web page that can only be accessed by a manager role and not other user roles.</p>
            <a href="welcome.jsp" class="btn btn-light">Back to Home Page</a>
          </div>
        </div>
      </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
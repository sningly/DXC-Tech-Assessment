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
    <%--our external CSS stylesheet--%>
    <link rel="stylesheet" href="main.css">
</head>
<body>
	<input type="hidden" id="status" value="<%=request.getAttribute("status")%>">
    <nav class="navbar navbar-expand-lg navbar-light">
      <div class="container-fluid app-logo login">
        <a class="navbar-brand" href="login.jsp"><strong>LoginApp</strong></a>
      </div>
    </nav>

    <section class="main-section">
      <div class="container-fluid">
        <div id="particulars-box">
          <form action="LoginServlet" method="post">
              <div class="mb-3">
                <label for="userid" class="form-label">User ID</label>
                <input type="text" class="form-control" name="userid" id="userid" required>
              </div>
              <div class="mb-4"> 
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" name="password" id="password" required>
              </div>
              <div class="mb-3 text-center">
                <button type="submit" class="btn btn-info mb-3">Login</button>
              </div>
          </form>
        </div>
      </div>
    </section>
    
    <script type="text/javascript">
    	var status = document.getElementById("status").value;
    	if (status == "failed") {
    		alert("Invalid Userid or Password. Please try again.");
    	} else if (status == "invalidUserid") {
    		alert("Sorry, please enter your User ID.");
    	} else if (status == "invalidPassword") {
    		alert("Sorry, please enter your password.");
    	}
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
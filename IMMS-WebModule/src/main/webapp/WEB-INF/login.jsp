<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
    <form action="login" method="post">
        <input name="username" type="text" placeholder="Username" required />
        <input name="password" type="password" placeholder="Password" required />
        <button type="submit">Login</button>
    </form>
    <c:if test="${param.error}">
        <p style="color:red;">Invalid credentials.</p>
    </c:if>
</body>
</html>

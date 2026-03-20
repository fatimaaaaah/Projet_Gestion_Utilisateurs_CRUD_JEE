<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<jsp:include page="header.jsp"/>

<div class="main-container">
    <form action="Login" method="post">
        <h2>Connexion</h2>

        <label>Login</label>
        <input type="text" name="login" required>

        <label>Mot de passe</label>
        <div class="password-container">
            <input type="password" id="password" name="password" required>
            <span onclick="togglePassword()" class="eye">👁️</span>
        </div>

        <input type="submit" value="Se connecter">
    </form>
</div>

<p class="error">${erreur}</p>

<jsp:include page="footer.jsp"/>

<script>
function togglePassword() {
    var input = document.getElementById("password");
    input.type = (input.type === "password") ? "text" : "password";
}
</script>

</body>
</html>
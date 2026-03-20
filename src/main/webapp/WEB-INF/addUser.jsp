<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Ajouter un utilisateur</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<jsp:include page="../header.jsp" />

<div class="main-container">
    <form action="Add" method="post">
        <h2>Ajouter un utilisateur</h2>

        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" required>

        <label for="login">Login :</label>
        <input type="text" id="login" name="login" required>

        <label for="password">Mot de passe :</label>
        <div class="password-container">
            <input type="password" id="password" name="password" required>
            <span onclick="togglePassword()" class="eye">👁️</span>
        </div>

        <input type="submit" value="Ajouter">
    </form>
</div>

<jsp:include page="../footer.jsp" />

<script>
function togglePassword() {
    var input = document.getElementById("password");
    input.type = (input.type === "password") ? "text" : "password";
}
</script>

</body>
</html>
<%@ page import="beans.Utilisateurs" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Modifier utilisateur</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<jsp:include page="../header.jsp" />

<%
Utilisateurs u = (Utilisateurs) request.getAttribute("user");
if (u == null) {
%>
<p style="text-align:center; color:red;">Utilisateur non trouvé ! <a href="List">Retour à la liste</a></p>
<%
} else {
%>

<div class="main-container">
    <form action="Edit" method="post">
        <h2>Modifier utilisateur</h2>
        <input type="hidden" name="id" value="<%= u.getId() %>">

        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" value="<%= u.getNom() %>" required>

        <label for="prenom">Prénom :</label>
        <input type="text" id="prenom" name="prenom" value="<%= u.getPrenom() %>" required>

        <label for="login">Login :</label>
        <input type="text" id="login" name="login" value="<%= u.getLogin() %>" required>

        <label for="password">Mot de passe :</label>
        <div class="password-container">
            <input type="password" id="password" name="password" value="<%= u.getPassword() %>" required>
            <span onclick="togglePassword()" class="eye">👁️</span>
        </div>

        <input type="submit" value="Modifier">
    </form>
</div>

<% } %>

<jsp:include page="../footer.jsp" />

<script>
function togglePassword() {
    var input = document.getElementById("password");
    input.type = (input.type === "password") ? "text" : "password";
}
</script>

</body>
</html>
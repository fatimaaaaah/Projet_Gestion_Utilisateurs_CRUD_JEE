<%@ page import="java.util.*, beans.Utilisateurs, dao.UtilisateurDao" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Liste des utilisateurs</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>
<body>

<jsp:include page="../header.jsp" />

<%-- Messages succès/erreur --%>
<%
String message = null;
String messageType = null;

if(session.getAttribute("message") != null) {
    message = (String) session.getAttribute("message");
    messageType = (String) session.getAttribute("messageType");
    session.removeAttribute("message");
    session.removeAttribute("messageType");
}

if(request.getAttribute("message") != null) {
    message = (String) request.getAttribute("message");
    messageType = (String) request.getAttribute("messageType");
}

if(message != null) {
%>
<p class="<%= messageType %>"><%= message %></p>
<% } %>

<div class="main-container-table">
    <div class="table-header">
        <h2>Liste des utilisateurs</h2>
        <a href="Add" class="btn-add"><i class="fas fa-plus"></i> Ajouter</a>
    </div>

    <table class="user-table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Login</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
        List<Utilisateurs> liste = UtilisateurDao.Lister();
        for (Utilisateurs u : liste) {
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getNom() %></td>
            <td><%= u.getPrenom() %></td>
            <td><%= u.getLogin() %></td>
            <td class="actions">
                <a href="Edit?id=<%= u.getId() %>" class="edit"><i class="fas fa-edit"></i></a>
                <a href="#" class="delete" onclick="openConfirm(<%= u.getId() %>)">
                    <i class="fas fa-trash-alt"></i>
                </a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

<div id="confirmBox" class="confirm-box">
    <div class="confirm-content">
        <h3>Gestion des utilisateurs</h3>
        <p>Voulez-vous vraiment supprimer cet utilisateur ?</p>
        <div class="confirm-buttons">
            <button id="confirmDelete" class="btn-confirm">Oui</button>
            <button onclick="closeConfirm()" class="btn-cancel">Non</button>
        </div>
    </div>
</div>

<jsp:include page="../footer.jsp" />

<script>
window.onload = function() {
    let userIdToDelete = null;

    window.openConfirm = function(id) {
        userIdToDelete = id;
        document.getElementById("confirmBox").style.display = "flex";
        document.body.style.overflow = "hidden";
    }

    window.closeConfirm = function() {
        document.getElementById("confirmBox").style.display = "none";
        document.body.style.overflow = "auto";
    }

    document.getElementById("confirmDelete").onclick = function() {
        if(userIdToDelete != null) {
            window.location.href = "Delete?id=" + userIdToDelete;
        }
    };
};
</script>

</body>
</html>
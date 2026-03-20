<%@ page import="jakarta.servlet.http.HttpSession" %>
<header>
    <div class="navbar">
        <div class="nav-left">
            Gestion des utilisateurs
        </div>

        <div class="nav-right">
            <%
                HttpSession sessionUser = request.getSession(false);
                if (sessionUser != null && sessionUser.getAttribute("user") != null) {
            %>
                <nav>
                    <a href="List">Lister</a>
                    <a href="Add">Ajouter</a>
                    <!-- On remplace le lien direct par un onclick -->
                    <a href="#" onclick="openLogoutConfirm()">Se Déconnecter</a>
                </nav>
            <%
                } else {
            %>
                Authentification
            <%
                }
            %>
        </div>
    </div>
</header>

<!-- Boite de confirmation logout -->
<div id="logoutConfirmBox" class="confirm-box">
    <div class="confirm-content">
        <h3>Gestion des utilisateurs</h3>
        <p>Voulez-vous vraiment vous déconnecter ?</p>
        <div class="confirm-buttons">
            <button id="confirmLogout" class="btn-confirm">Oui</button>
            <button onclick="closeLogoutConfirm()" class="btn-cancel">Non</button>
        </div>
    </div>
</div>

<script>
function openLogoutConfirm() {
    document.getElementById("logoutConfirmBox").style.display = "flex";
}

function closeLogoutConfirm() {
    document.getElementById("logoutConfirmBox").style.display = "none";
}

// Bouton Oui => redirection vers le servlet Logout
document.getElementById("confirmLogout").onclick = function() {
    window.location.href = "Logout";
};
</script>
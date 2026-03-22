# GestionUsers1

Projet **CRUD JEE** pour la gestion des utilisateurs avec authentification.  
Ce projet utilise **Java EE (Servlets, JSP), JDBC et MariaDB** pour stocker les utilisateurs.

---

## 📝 Description

Cette application permet de :  
- Ajouter, modifier et supprimer des utilisateurs.  
- Lister tous les utilisateurs dans un tableau avec actions.  
- Authentification simple pour accéder aux fonctionnalités.  
- Affichage de messages de confirmation pour les actions (ajout, modification, suppression, déconnexion).  

L’interface utilise **JSP**, **CSS** et **Font Awesome** pour les icônes.  
La logique côté serveur est en **Servlets**, et les données sont stockées dans une **base de données MySQL/MariaDB** via JDBC.

---

## 📂 Structure du projet
```
GestionUsers1/
├── src/
│ ├── beans/ # Classe Java "Utilisateurs" avec getters/setters
│ ├── dao/ # Classe "UtilisateurDao" pour accéder à la base de données
│ │ └── DBConnection.java # Connexion JDBC à la base de données
│ └── servlets/ # Servlets pour Add, Edit, Delete, List, Login, Logout
├── WebContent/
│ ├── WEB-INF/
│ │ ├── web.xml # Déploiement des servlets et welcome-file
│ │ ├── addUser.jsp # Formulaire d'ajout d'utilisateur
│ │ ├── editUser.jsp # Formulaire de modification
│ │ └── listeUtilisateurs.jsp # Affichage des utilisateurs
│ ├── css/
│ │ └── style.css # Styles de l'application
│ ├── header.jsp # Barre de navigation
│ ├── footer.jsp # Pied de page
│ └── login.jsp # Formulaire de connexion
└── lib/ # Librairies externes (MySQL Connector/J)
```
---

## ⚙️ Configuration

1. **Base de données** :  
   - Crée une base `gestion_users` avec une table `utilisateurs` :  
     ```sql
     CREATE TABLE utilisateurs (
         id INT AUTO_INCREMENT PRIMARY KEY,
         nom VARCHAR(50),
         prenom VARCHAR(50),
         login VARCHAR(50),
         password VARCHAR(100)
     );
     ```
   - Modifie le fichier `DBConnection.java` pour mettre ton **utilisateur** et **mot de passe** MySQL.

2. **Déploiement** :  
   - Déploie le projet sur **Apache Tomcat**.  
   - Accède à l’application via : `http://localhost:8080/GestionUsers1`

3. **Authentification** :  
   - Login : **Admin**.  
   - Password : **Admin**.  

---

## 🔑 Fonctionnalités principales

| Fonction        | Description |
|-----------------|------------|
| Authentification | Accès aux fonctionnalités après login avec `admin/admin` |
| Ajouter utilisateur | Formulaire JSP, ajout dans la base de données |
| Modifier utilisateur | Formulaire JSP prérempli, mise à jour en base |
| Supprimer utilisateur | Confirmation avec boîte personnalisée avant suppression |
| Lister utilisateurs | Tableau JSP avec toutes les données et actions |
| Déconnexion | Boîte de confirmation avant fermeture de session |

---

## 📌 Notes importantes

- La gestion des mots de passe est **simple** (texte clair). Pour un projet réel, il est conseillé d’utiliser **hashage** et **sécurité renforcée**.
- Les messages de succès ou d’erreur sont affichés via des notifications dans la page JSP.
- Toutes les actions CRUD sont maintenant connectées à la **base de données** via JDBC.

---

## 👨‍💻 Auteur

- Fatima Nguénar DIOUF M2Glsi

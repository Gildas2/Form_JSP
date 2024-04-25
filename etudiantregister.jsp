<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire Ajout Etudiants</title>
    <style>
        div form{
            float: left;
        }
        fieldset{
            width: 100%;
        }
        form h3{
            text-align: center;
            margin-bottom: 10px;
        }
        form{
            margin: 60px 100px 0 100px;
        }
        form div{
            padding: 10px;
        }
        form div * {
            display: block;
        }
        form div label{
            font-size: 16px;
            font-weight: bold;
        }
        form div input{
            position: relative;
            width: 100%;
            height: 30px;
            margin-bottom: 8px;
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <form action="<%= request.getContextPath() %>/etudiant" method="post">   
        <fieldset>
            <h3>Renseignez vos informations</h3>
            <div>
                <label for="lastname">Nom : </label>
                <input type="text" id="lastname" name="lastname" placeholder="Nom" required>
            </div>

            <div>
                <label for="firstname">Prénom : </label>
                <input type="text" id="firstname" name="firstname" placeholder="Prénom(s)" required>
            </div>

            <div>
                <label for="date_naissance">Date de naissance : </label>
                <input type="date" id="date_naissance" name="company" placeholder="Date de naissance" required>
            </div>
        
            <div>
                <label for="email">Adresse mail : </label>
                <input type="text" id="email" name="email" placeholder="email" required>    
            </div>
            <div>
                <label for="phone_number">Numéro de téléphone : </label>
                <input type="text" name="phone_number" id="phone_number" placeholder="Numéro de téléphone">    
            </div>
            <div>
                <input type="submit" value="Enregistrer">
            </div>
        </fieldset>
    </form>
</body>
</html>
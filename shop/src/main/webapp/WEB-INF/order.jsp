<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/23/2020
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Order</title>
    <link type="text/css" rel="stylesheet" href="stylesheet/style.css" />
</head>
<body>
<div>
    <form method="get" action="creationCommande">
        <fieldset>
            <legend>Informations client</legend>

            <label for="nomClient">Nom <span class="requested">*</span></label>
            <input type="text" id="nomClient" name="nomClient" value="" size="20" maxlength="20" />
            <br />

            <label for="prenomClient">Prénom </label>
            <input type="text" id="prenomClient" name="prenomClient" value="" size="20" maxlength="20" />
            <br />

            <label for="adresseClient">Adresse de livraison <span class="requested">*</span></label>
            <input type="text" id="adresseClient" name="adresseClient" value="" size="20" maxlength="20" />
            <br />

            <label for="telephoneClient">Numéro de téléphone <span class="requested">*</span></label>
            <input type="text" id="telephoneClient" name="telephoneClient" value="" size="20" maxlength="20" />
            <br />

            <label for="emailClient">Adresse email</label>
            <input type="email" id="emailClient" name="emailClient" value="" size="20" maxlength="60" />
            <br />
        </fieldset>
        <fieldset>
            <legend>Informations commande</legend>

            <label for="dateCommande">Date <span class="requested">*</span></label>
            <input type="text" id="dateCommande" name="dateCommande" value="" size="20" maxlength="20" disabled />
            <br />

            <label for="montantCommande">Montant <span class="requested">*</span></label>
            <input type="text" id="montantCommande" name="montantCommande" value="" size="20" maxlength="20" />
            <br />

            <label for="modePaiementCommande">Mode de paiement <span class="requested">*</span></label>
            <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="" size="20" maxlength="20" />
            <br />

            <label for="statutPaiementCommande">Statut du paiement</label>
            <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" size="20" maxlength="20" />
            <br />

            <label for="modeLivraisonCommande">Mode de livraison <span class="requested">*</span></label>
            <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" size="20" maxlength="20" />
            <br />

            <label for="statutLivraisonCommande">Statut de la livraison</label>
            <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" size="20" maxlength="20" />
            <br />
        </fieldset>
        <input type="submit" value="Valider"  />
        <input type="reset" value="Remettre à zéro" /> <br />
    </form>
</div>
</body>
</html>

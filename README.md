#APPLICATION ENTREVOISINS

Application qui permet à des personnes d’un même quartier de se rendre des petits services : 
garde d’animaux, petit bricolage, troc d’objets, cours particuliers, de nombreuses options s’offrent aux utilisateurs !

Java 8 / API 21. 

#INSTALLATION 

Ces instructions vous permettront d'obtenir une copie du projet sur votre ordinateur local à des fins de développement et de test.
https://github.com/Reps06250/EntrevoisinsPS
Télécharger le dossier de l'app ou utiliser le lien URL.
Ouvrie le dossier avec AndroidStudio.

#BIBLIOTHÈQUE

- ButterKnife
- view Binding
- Glide
- EventBus

#FONCTIONS PRÉSENTES 

- affichage de la liste des voisins 
- Ajout d'un voisin 
- Suppression d’un voisin

#FONCTIONS AJOUTÉES

- Affichage de la liste des favoris
- Affichage du profil d'un voisin

##EXÉCUTION ET COMPILATION

Vous pouvez exécuter l'app soit sur un matériel physique connecté, soit avec un matériel émulé.

#Création d'un périphérique émulé
Onglet Run/Select Device.../Open AVD Manager puis Create Virtual Device...
Choisir un telephone ou une tablette, next, choisir l'api recommandé (minimum 21) et télécharger si besoin, next, choisir un nom et finish.

#Choix du périphérique sur lequel compiler
Run/Select Device...

#compilation et exécution
Run/Run 'app'

#TESTS

Unitaire : app/java/com.openclassrooms.entrevoisins.service/NeighbourServiceTest
D'intégrations : -app/java/com.openclassrooms.entrevoisins(androidTest)/neighbour_list/NeighbourListTest
                 -app/java/com.openclassrooms.entrevoisins(androidTest)/neighbour_profil/NeighbourProfilTest
                 

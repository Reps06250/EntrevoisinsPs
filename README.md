#APPLICATION ENTREVOISINS

Application qui permet à des personnes d’un même quartier de se rendre des petits services : 
garde d’animaux, petit bricolage, troc d’objets, cours particuliers, de nombreuses options s’offrent aux utilisateurs !

Java 8 / API 21. 

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

#INSTALLATION 

Ces instructions vous permettront d'obtenir une copie du projet sur votre ordinateur local à des fins de développement et de test.
Rendez vous à l'adresse https://github.com/Reps06250/EntrevoisinsPS, 2 méthodes s'offrent ensuite à vous pour copier/importer le projet. Soit via le lien download, soit en copiant l'url :
- 1ere méthode, Télécharger le dossier de l'app puis ouvrez le dossier dans AndroidStudio via "Open an existing Android Studio Project" au démarage,     ou onglet File/open... si Android Studio est déjà en cours d'exécution sous un autre projet.
- 2eme méthode, copiez l'URL, au démarage d'AndroidStudio choisissez "check out project from version control", git, puis copiez l'URL.


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
                 

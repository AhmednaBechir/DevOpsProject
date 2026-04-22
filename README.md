# DevOpsProject

### ndarray-lib

[![CI](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/ci.yml/badge.svg)](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/ci.yml)
[![Publish](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/publish.yml/badge.svg)](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/publish.yml)
[![GitHub Pages](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/pages.yml/badge.svg)](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/pages.yml)
[![pages-build-deployment](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/pages/pages-build-deployment/badge.svg)](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/pages/pages-build-deployment)
[![SonarQube Analysis](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/sonar.yml/badge.svg)](https://github.com/AhmednaBechir/DevOpsProject/actions/workflows/sonar.yml)
[![Quality Gate Status](https://im2ag-sonar.univ-grenoble-alpes.fr/api/project_badges/measure?project=m1-devops-final-project&metric=alert_status&token=sqb_9df6eb3cc1dd2469f1f02c53dda1c26010304d2b)](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=m1-devops-final-project)
[![Coverage](https://im2ag-sonar.univ-grenoble-alpes.fr/api/project_badges/measure?project=m1-devops-final-project&metric=coverage&token=sqb_9df6eb3cc1dd2469f1f02c53dda1c26010304d2b)](https://im2ag-sonar.univ-grenoble-alpes.fr/dashboard?id=m1-devops-final-project)

A Java library for multidimensional array computation, inspired by NumPy.

## Fonctionnalités

### Structure de données
- `Ndarray` : Tableau multidimensionnel (1D et 2D) de type `double[][]`
  - Attributs : `double[][]`, `ndim`, `shape`, `size`

### Fonctions de création (Numja)
- `array()` : Création depuis une liste de `double` ou une liste de `double[]` et renvoi un Ndarray
- `zeros()` : Création d'un tableau rempli de zéros. Prend en paramete un `int[]` de taille 2 contenant les deux dimensions. Renvoi un Ndarray.
- `arange()` : Création depuis une séquence de nombres. Prend en paramètre trois entier `start`, `end`, `step` pour définier le début, la fin et le pas de la séquence. Renvoi un Ndarray de 1D.

### Opérations
- `Numja.add(Ndarray mat1, Ndarray mat2)` : Addition élément par élément des matrices mat1 et mat2. Retourne une matrice `mat1+mat2`.
- `Ndarray.add(Ndarray mat_in)` : Addition élément par élément sur place.
- `Numja.sub(Ndarray mat1, Ndarray mat2)` : Soustraction élément par élément des matrices mat1 et mat2. Retourne une matrice `mat1-mat2`.
- `Ndarray.sub(Ndarray mat_in)` : Soustraction élément par élément sur place.
- `Numja.mul(Ndarray mat1, Ndarray mat2)` : Multiplication élément par élément des matrices mat1 et mat2. Retourne une matrice `mat1*mat2`.
- `Ndarray.mul(Ndarray mat_in)` : Multiplication élément par élément sur place. Les dimensions de mat1 devienne -> `mat1(m,n)*mat2(n,p) = mat1(m,p)` 
- `reshape()` : Transformation, si possible, de la forme d'une matrice 2D en une nouvelle matrice 2D de forme différente. Les éléments sont inchangés et aucun élément n'est ajouté ou supprimé.
- `ravel()` : Transformation d'une matrice 2D en 1D sur place.

### Affichage
- `print()` : Fonction qui retourne une `String` représentant l'affichage formaté du tableau

## Choix d'outils

Les outils suivants étaient imposés par le sujet et auraient été utilisés de toute façon :
Git, Maven, JUnit 5, un dépôt GitHub.

Outils choisis en plus :

- **Jacoco** : intégré nativement à Maven, standard pour la couverture de code Java
- **GitHub Actions** : intégré à GitHub, pas besoin de service externe, configuration en YAML
- **GitHub Packages** : intégré à GitHub, déploiement du JAR sans compte externe
- **GitHub Pages + maven-site-plugin** : génération automatique de site avec javadoc et rapports
- **SonarQube (instance UFR)** : analyse statique, instance fournie par l'UFR donc pas de setup serveur
- **Docker + GHCR** : conteneurisation de la démo, registre intégré à GitHub

## Intégration et Livraison Continue (Ops)

### Pipelines GitHub Actions

- **CI** (`ci.yml`) : Déclenché sur push `feature/**` et PR vers `develop`/`main` — compile et lance les tests unitaires, génère et publie le rapport de couverture Jacoco en artifact
- **CI Develop** (`ci-develop.yml`) : Déclenché sur push vers `develop` — même chose, rapport de couverture considéré comme version de référence
- **Publish** (`publish.yml`) : Déclenché sur push vers `main` — publie le JAR sur GitHub Packages et construit et pousse l'image Docker sur GHCR
- **Pages** (`pages.yml`) : Déclenché sur push vers `main` — génère le site Maven (javadoc, rapports) et le déploie sur GitHub Pages
- **SonarQube** (`sonar.yml`) : Déclenché sur push/PR vers `main`/`develop` — analyse statique du code, résultats visibles sur l'instance UFR

### Protection de la branche main

- Pull Request obligatoire avant merge
- 1 approbation requise
- Réinitialisation des approbations si nouveaux commits
- Approbation requise sur le dernier commit (latest push)
- Review obligatoire des Code Owners 
- Les status checks doivent passer (CI)
- La branche doit être à jour avant merge
- Interdiction de bypass (même pour les admins)

## Workflow Git

### Branches
- `main` : Branche stable, releases uniquement
- `develop` : Branche d'intégration
- `feature/*` : Une branche par fonctionnalité, créée depuis `develop`

### Procédure
1. Chaque développeur crée une branche `feature/nom` depuis `develop`
2. Avant ouverture d'une PR, rebase sur `develop` :
```bash
   git fetch origin
   git rebase origin/develop
   git push --force-with-lease
```
3. PR ouverte sur `develop` → review de code par un autre membre → approbation requise
4. CI doit passer (build + tests) avant de pouvoir merger
5. Quand `develop` est stable → PR sur `main` → review + approbation → merge → publish JAR + Docker

### Validation des Pull Requests
- 1 approbation obligatoire
- Les approbations sont invalidées si de nouveaux commits sont poussés
- Le CI doit être vert (status check obligatoire)
- Les discussions doivent être résolues avant merge

### Cas particuliers

Les modifications liées à l’Ops (CI/CD, workflows, configuration pom.xml ..etc)
peuvent être intégrées directement via une Pull Request vers `main`, avec approbation. Le workflow standard (feature → develop → main) ne s'applique que sur les fonctionnalités.

## Images Docker

- **`ghcr.io/ahmednabechir/devopsproject/ndarray-lib:latest`** : Exécute un scénario de démonstration des fonctionnalités de la bibliothèque au lancement du conteneur.
- Dépôt : https://github.com/AhmednaBechir/DevOpsProject/pkgs/container/devopsproject%2Fndarray-lib

## Tests

### NumjaTest
- `arrayTest` : création 1D
- `initializationTest` : création 2D, vérification shape/size/data
- `zerosTest` : vérification zeros 1D et 2D
- `arangeTest` : vérification de création de matrices avec un intervalle et un pas défini
- `addTest*`, `subTest*`, `mulTest*` : opérations de base dans une nouvelle matrice
- `addBadDimensionsTest*`, `subBadDimensionsTest*`, `mulBadDimensionsTest*` : exceptions sur mauvaises dimensions

### NdarrayTest
- `initializationTest` : création 2D, vérification shape/size/data
- `addTest*`, `subTest*`, `mulTest*` : opérations de base sur place
- `reshapeTest` : vérification de transformation de matrices 2D en 2D de forme différente
- `ravelTest` : vérification de transformation de matrices 2D en 1D
- `getSizeTest`


## Travaux en cours

Certaines fonctionnalités ont été commencées mais non finalisées avant la deadline :

- **feature/UsefulMathOp** :
  - `pow(Ndarray arr, double x)`
  - `exp(Ndarray arr)`
  - `sqrt(Ndarray arr)`
  → opérations mathématiques élément par élément

- **feature/broadcast** :
  - Implémentation du broadcasting (partiellement fonctionnelle)

## Feedback

Pas de feedback.

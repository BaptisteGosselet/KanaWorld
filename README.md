# Kana World

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)

## Présentation générale 
Ce projet est un jeu éducatif destiné à l'apprentissage des kanas japonais (équivalent de l'alphabet). Cela consiste en un quiz dans lequel il faut retrouver le caractère correspondant à la lettre proposée. Le jeu propose plusieurs modes de jeux et formats de questions.  

## Script  

```bash
#Compiler
javac -sourcepath src -d bin src/Main.java 

#Générer le jar
jar cfe KanaWorld.jar Main -C bin ./

#Lancer le projet
java -jar KanaWorld.jar 
``` 

## Présentation détaillée
La langue japonaise dispose d'un système d'écriture complexe. Il est composé des Kanjis (des caractères chinois représentant les mots) et des Kanas permettant de représenter des syllabes. Il est possible d'écrire entièrement le japonais avec les kanas sans kanji, mais cela rend la lecture complexe, commesinousecrivionssansespaces. C'est pour cela que l'assimilation des kanas est la première grande étape dans l'apprentissage de cette langue.

Les Kanas sont composés en deux tableaux de caractères : les Hiraganas et les Katakanas. Qui représentent une cinquantaine de caractères chacun.

- Tableau des Hiraganas
![AF433on.jpg](https://steemitimages.com/DQmQpEzeM5X6GXCaxjxcyRFtcnb1BabSD9mQ7LKWVDj2Gxp/AF433on.jpg)

- Tableau des Katakanas
![Hiragana.jpg](https://steemitimages.com/DQmbSoeh6Y3ftw7jacSSckEM2sky8jf9snc5ccAqYRjBsBx/Hiragana.jpg)

### Les modes de jeu

Ce projet propose 3 principaux modes de jeux : 
- Mode Complet : Tous les caractères peuvent être tirés dans la question
- Mode Progressif : Le jeu commencent avec les premiers caractères (a, i, u, e, o) et ajoute un caractère toutes les 5 bonnes réponses consécutives (d'abord ka, puis ki, ku, ke, ko, sa, shi, ...) 
- Mode Selectif : L'utilisateur peut choisir une ligne de kana, par exemple (ta, chi, tsu, te, to) ou (na, ni, nu, ne, no) et le questionnaire tourne en boucle avec ces lettres.

### Les formats de question

Le jeu propose également différents formats de questions : 
- **Hiragana -> Alpha** : Le quiz propose un hiragana et 4 proposition en lettres alphabet, il faut retrouver la lettre correspondante.
- **Alpha -> Hiragana** : L'inverse, le quiz propose une lettre alphabet et propose 4 hiraganas.
- **Katakana -> Alpha** et **Katakana -> Alpha** : La même chose avec les katakanas
- **Kana -> Alpha** et **Alpha -> Kana** : La même chose, mais avec à la fois des hiraganas et des katakanas
- **Hiragana <-> Katakana** : Le quiz propose un caractère en hiragana ou en katakana, les propositions de réponses sont dans l'autre alphabet.

## Présentation technique

A rédiger...<br>
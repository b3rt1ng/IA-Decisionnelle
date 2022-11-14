# important, on rend seulement le readme.txt et pas celui là, on pensera aussi à retier le package csp


| n° | Note |
| --- | --- |
| 1 | Faire les javadoc en même temps que nos classes (on gagnera du temps) |  

Lien du [TP1](https://ecampus.unicaen.fr/pluginfile.php/1250252/mod_resource/content/2/tp_representation.pdf) (représentation)  
Lien du [TP2](https://ecampus.unicaen.fr/pluginfile.php/1250252/mod_resource/content/2/tp_representation.pdf) (planification)  

| Algo | implémentation | Source(s) |
| --- | --- | --- |
| Dijkstra | [/src/planning/DijkstraPlanner](https://github.com/b3rt1ng/Aide-la-d-cision/blob/master/src/planning/DijkstraPlanner.java) | [Wikipedia](https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) + cour |
| Astar | [/src/planning/AStarPlanner](https://github.com/b3rt1ng/Aide-la-d-cision/blob/master/src/planning/AStarPlanner.java) |  [Wikipedia](https://en.wikipedia.org/wiki/A*_search_algorithm) + cour |  

Ant builder commands:
```
ant compile #simple compiling of the project
ant test #compile and run the tests on the project
ant run #compile and run the project
ant doc #generate the whole javadoc of the peoject
```
avancée du projet
- [ ] fil rouge
- [x] représentation
- [x] planification
- [x] csp
- [x] datamining

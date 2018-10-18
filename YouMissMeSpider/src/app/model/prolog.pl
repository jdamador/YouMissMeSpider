%Implementacion de Dijkstra
%definimos un grafo
grafo(a,c,60).
grafo(a,e,80).
grafo(b,a,30).
grafo(b,d,20).
grafo(d,e,10).
grafo(d,a,60).
grafo(c,e,50).
grafo(c,x,40).
grafo(e,f,20).
grafo(f,x,50).
grafo(x,g,30).
grafo(g,c,20).



%nodo inicial, nodo destino, distancia, ruta

%dijkstra(I,F,S,C,L), donde I es el nodo inicio,F el nodo Final,
%S la lista de nodos seleccionados, C la lista de nodos candidatos,
%L la lista de respuesta del camino y R de salida igual,L indica si
% hay camino de I a F.

dijkstra(_,_,_,[],L):- L=[].


%en el siguiente predicado se ejecuta cuando se encuentra la
%solucion: se determina la menorArista del Nodo I y se guarda
%en A el nodo ke hace posible esto, luego se verifica si es el final
% y por ultimo se agrega a la lista de salida.

dijkstra(I,F,S,_,L):- menorArista(I,A),
A==F,
append(S,A,Lista),
L = Lista.



%caso que A(nodo de menor arista) sea diferente de del nodo
%final, luego agregamos a la lista de seleccionados el nodo A y
%lo eliminamos de la lista de candidatos y llamamos de nuevo
%a la función dijkstra.

dijkstra(I,F,S,C,L):- menorArista(I,A),
A\=F, %siA es diferente de F,osea no es el nodo destino
append(S,A,Lista1),
eliminar(A,C,Lista2),
dijkstra(A,F,Lista1,Lista2,L).




menorArista(I,A):- findall(P,grafo(I,_,P),L),
menorlista(L,Menor),
grafo(I,A,Menor).





%Por acá agrego las funciones extras que hago uso

%Detectar el menor elemento de una lista
menorlista([],0).
menorlista([X],X).
menorlista([X|L],X):- menorlista(L,Y),
menor(X,Y).
menorlista([X|L],Y):- menorlista(L,Y),
menor(Y,X).
menor(X,Y):- X =< Y.


%agregar un elemento al final de la lista
append([],L,[L]).
append([H|T],N,[H|S]):-append(T,N,S).



%eliminamos un elemento X de la lista
eliminar(_,[],[]):-fail.
eliminar(X,[X|R],R).
eliminar(X,[C|R],[C|R1]):- eliminar(X,R,R1).

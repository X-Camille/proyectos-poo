Integrantes:  

- Millarayen Ferrada  
- Camille Elgueta  
- Kihara Millaldeo 
- Xiao Zihao 

Comentarios de la actividad: 

Hubieron problemas al momento de hacer Merge. 

El merge de la rama de Millarayen y Camille con la master, no dieron mucho problema. 
Simplemente se resolvieron conflictos, se eliminaron los símbolos <<<<< ===== >>>>>, y se conservaron los nombres correspondientes. 

Los problemas surgieron con las ramas de Xiao y Kihara. 

Cuando se hizo merge con la rama Xiao, IntelliJ no detectaba conflicto y sobreescribía todo el archivo, dejando solo el nombre 
de nuestro compañero. Esto también sucedía cuando se intentaba con la consola Bash. Para solucionarlo, se agregó el método 
zihaoxiao() junto al método main, para que detectara que sí hay conflicto entre los archivos y no los sobreescribiera. 

Por último, con la rama Kihara no dejaba hacer merge ya que no detectaba un commit en común entre la rama master y la de ella. 
Es decir, las historias no estaban relacionadas. Para hacer el merge, 
tuvimos que hacer un commit de fusión utilizando la consola Bash, se resolvieron conflictos en intelliJ y se hizo push a la rama master.

En conclusión, a pesar de los problemas, se logró hacer merge de todas las ramas en la rama master, en donde se pueden ver todos nuestros 
nombres juntos en una misma clase de Java.
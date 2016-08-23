# ReplacePath

Acho muito interessante o comando wget do linux. Entretanto sempre que fiz um mirror de algum site, os links(âncoras) das páginas continuavam apontando para o site no servidor e não no mirror localmente. O que tornava muito incomódo navegar entre as páginas do mirror.
Então criei este simples algoritmo que varre todos as páginas do mirror e substitui a parte do link que se refere ao servidor para um lugar local, no computador.

Ex: 

    http://umsitequalquer.com.br/2015/05/umpostqualquer.html 
    
poderá ficar assim: 

    localhost:8080/pastalocal/2015/05/umpostqualquer.html

E preservar( ao menos na maior parte dos casos) a navegação de páginas do site.

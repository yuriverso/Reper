# Reper
Integração Java e MySQL para a criação de set lists musicais

Este projeto foi construído em Java com integração a um banco de dados MySQL. Seu objetivo é possibilitar a criação de set lists musicais utilizando o repertório musical guardado na base de dados.

![imagem1](https://user-images.githubusercontent.com/96660042/218758132-78d4cbc9-1de7-4362-b8ad-e34ac5ff1e5d.png)

<hr>

## O projeto

  O código possui duas partes principais que atuam concomitantemente: a GUI (Interface Gráfica do Usuário) e a JDBC (Conectividade Java à Base de Dados).
  
  A princípio, a base de dados estará vazia, ou seja, nenhuma música terá sido registrada. Portanto, o usuário deverá registrá-las através da função "Adicionar Música", inserindo o nome, o artista, o tom e a duração da mesma. <br>
(É possível também editar músicas já registradas ou removê-las da base da dados)

![imagem2](https://user-images.githubusercontent.com/96660042/218758776-aeb527b0-49eb-4b8c-82ee-d8486ce810a9.png)

Após registradas, o usuário poderá selecionar aquelas que comporão seu novo set list, tendo ele o poder de reordená-las como desejar, utilizando os botões laterais de reordenação. É possível salvar o set list criado como o nome que quiser, tal como acessá-lo posteriormente ou então exportá-lo como documento de texto.

<hr>

## Configuração

Para que o programa funcione como esperado, é preciso ter uma conexão ativa com a base de dados. Para isso, três requisitos devem ser satisfeitos:
- Adicionar ao projeto o driver MySQL Connector Java, disponível para download em https://dev.mysql.com/downloads/connector/j/
- Criar uma base de dados chamada "reper" no MySQL e uma tabela chamada "all_songs", a qual receberá as músicas registradas
- Passar os dados corretos de conexão à base de dados utilizando o botão "Conexão" ou modificar as variáveis padrões na classe ReperConnection.java 

![imagemconect1](https://user-images.githubusercontent.com/96660042/218760905-989e614e-9e1b-410c-9280-73fdd23bc186.png)
![imagemconect2](https://user-images.githubusercontent.com/96660042/218760929-ba41a602-8633-4fb6-916c-2a5719147cc8.png)

Caso a conexão seja realizada com sucesso, o indicador de conexão ficará verde, caso contrário, vermelho.
<hr>

![imagem3](https://user-images.githubusercontent.com/96660042/218761475-3ac3d048-fdaf-4257-8fe6-bfa85f34e055.png)

<pre>Desenvolvido por Yuri Kruk
             por um mundo mais feliz.</pre>

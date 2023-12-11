# Livros Favoritos
API para gerenciar livros favoritos dos clientes.

---
# Requisitos:
Necessário ter Docker instalado para executar o arquivo compose.yaml. 
Neste arquivo esta incluido imagem para banco de dados MongoDB e Cache Redis. 

---
# Execução
Para executar a aplicação, utilize uma IDE de sua preferencia. Executar "Run" na classe CustomerBooksFavoriteApplication.

---
# Operacões
### Users
    - POST      - Login         - ### EM CONSTRUÇÃO ###
    - POST      - Create        - http://localhost:8080/api/users
    - PUT       - Update        - http://localhost:8080/api/users
    - DELETE    - Delete        - http://localhost:8080/api/users/{userId}
        * Remove usuário e todos os favovitos
    - GET       - List All      - http://localhost:8080/api/users
    - GET       - Find by Email - http://localhost:8080/api/users/marcio@bookstore.com
### Books
    - GET       - List All      - http://localhost:8080/api/books
    - GET       - Find by ISBN  - http://localhost:8080/api/books/9786558101277
### Favorite
    - GET       - List All by User Email    - http://localhost:8080/api/favorite/users/user@bookstore.com
    - DELETE    - Delete by UserId and ISBN - http://localhost:8080/api/favorite
    - POST      - Save                      - http://localhost:8080/api/favorite
---
### Colletion
    Arquivo "Insomnia_2023-12-10.json" possui todas as operações acima.

---
### Overview da Solução
Basicamente são 3 tabelas para controle dos favoritos -> users, books, favorite 

#### Users: 
    Contém os usuarios/clientes

#### Books: 
    Quando é realizada a consulta pelo ISBN, os dados sao gravados nessa tabela.
    Essa tabela esta cacheada no Redis.

#### Favorite: 
    Guarda somente a referência do id do usuario e o ISBN
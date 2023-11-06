# wakivote
projeto de sessão de votação para associados

## Setup
Para executar o projeto é nescessario ter docker compose instalado
https://docs.docker.com/compose/install/

```bash
# finalize todos os containers em execução
docker stop $(docker ps -aq)

# execute o docker compose
docker-compose up --build -d
```
Após o comando acima a aplicação e o banco de dados estarão sendo executados via docker,
acesse a documentação no localhost:
http://localhost:8080/wakivote/api/public/swagger-ui/index.html

Importante que as portas 8080 e 5432 estejam livres antes de executar o docker-compose.
Avaliação
Desenvolver tanto a API quanto o front-end (Spring boot e VueJs no front, caso não tenha
conhecimentos de VueJs, pode ser feito o front com angular). Utilizar a versão 11 do java.

O objetivo dessa tarefa é avaliar como você vai desenvolver o código em termos de estilo, eficiência,
qualidade e prazo de entrega.
A tarefa é a seguinte:
Desenvolver um sistema de agendamento de transferências financeiras.

O usuário deve poder agendar uma transferência financeira com as seguintes informações:

1. Conta de origem (padrão XXXXXXXXXX), conta de destino (padrão XXXXXXXXXX), valor da
transferência, taxa (a ser calculada conforme tabela abaixo), data da transferência (data em
que será realizada a transferência) e data de agendamento (hoje);

3. O cálculo da taxa sobre o valor a ser transferido depende da data de transferência como
segue:
Dias Transferência
R$ Taxa De Até
0   0     3,00 2,5%
1   10    12,00 0,0%
11  20    0,00 8,2%
21  30    0,00 6,9%
31  40    0,00 4,7%
41  50    0,00 1,7%

   Observação: Caso não haja taxa aplicável, lançar um alerta sobre o erro e não permitir
tranferência.

3. O usuário deve poder ver o extrato de todos os agendamentos cadastrados.
Nota: A persistência deve ser feita em banco de dados em memória (h2, por exemplo). 

   *********************************************************************************************************
   RESOLUÇÃO 
 backend: JAVA spring boot

1. Configuração do Projeto
Criei projeto Spring Boot com as dependências:
Spring Web
Spring Data JPA
H2 Database
Lombok
2. Configuração do application.properties 
Configurei o banco de dados em memória H2

3 criação da entidade transferência
4 - criação do repósitorio para o banco de dados
5 - criação dos serviços calculo de taxa e serviço de transferencia
6 criação do controller para tratar as APIs

na parte do frontend foi feito em angular versão 16
1 - criação da aplicação angular 
2- criação do serviço para consumir as informações do backend
3 - criação dos componentes lista de transferencia e o formulario de transferencia

nos componentes usei as diretivas do angular para exibir a tabela no template
fiz configuração de rotas para navegar entre os componentes 

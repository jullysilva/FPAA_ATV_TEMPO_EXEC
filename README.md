# FPAA_ATV_TEMPO_EXEC
FPAA - tempo de execução e complexidade - Prof. João Caram

Estudamos, durante as aulas da disciplina, como a complexidade de tempo (custo de execução) de um algoritmo pode impactar o tempo para a obtenção de uma solução para um problema computacional. O cálculo matemático da complexidade do algoritmo dá uma medida segura para compararmos algoritmos e seus comportamentos. Neste exercício, procuraremos analisar, na prática, os efeitos de algoritmos de complexidades diferentes para um mesmo problema. Você realizará a medição de tempo de execução de algoritmos diferentes com quantidades crescentes de dados e comparará os resultados obtidos com a função de complexidade destes algoritmos.
A descrição completa das tarefas segue:

### PRIMEIRA PARTE
a) Especificar, no documento a ser entregue, em qual equipamento foram realizados os testes (modelo do processador e velocidade; quantidade de memória principal / RAM; sistema operacional utilizado);

b) Usar vetores de teste de tamanho 62.500, 125.000, 250.000, 375.000 com valores aleatórios inteiros. É importante ressaltar que o mesmo vetor deve ser utilizado nos testes com cada um dos dois algoritmos.

c) Para cada tamanho de vetor:
- criar 50 vetores aleatoriamente preenchidos;
- realizar a ordenação utilizando cada um dos dois algoritmos;
- marcar o tempo de execução calcular a média deste tempo para cada método.

d) Criar uma tabela comparando os resultados de tempo x tamanho entre os dois algoritmos.

e) Analisar criticamente esta tabela, relacionado os resultados obtidos com as ordens de complexidade teóricas conhecidas dos algoritmos. Você deve comparar os resultados reais com os resultados que deveriam ser esperados considerando a complexidade teórica dos algoritmos utilizados.

### SEGUNDA PARTE
a) Usando o vetor de tamanho 10.000, realizar uma comparação do algoritmo quicksort com um vetor aleatório e outro já ordenado. Execute este teste 10 vezes para tirar a média de tempo; compare os resultados obtidos com o que sabemos de quicksort.

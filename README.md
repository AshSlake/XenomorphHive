# Planejamento Projeto Xenomorfo 👽🐜

<p>Para Treinar os conceitos aprendidos em JAVA ☕, decidi criar um projeto de simulação de uma colmeia de xenomorfos.
</p>

<h1> 🏗️ Arquitetura Planejada -- ECS + MVP MODULAR</h1>

* ECS (Entity-Component-System) - para simular entidades e comportamentos.
* MVC (Model-View-Controller) - para separar visualização, logica, e controle.
* MODULARIZAÇÂO POR PACOTES - para escalar e manter o sistema organizado

---

### **ECS:**
<p>essa arquitetura é usada em jogos e simulações, ela divide as entidades em partes reutilizaveis</p>


| Elemento  | Função                                                         |
|-----------|----------------------------------------------------------------|
| Entity    | Um identificador (ex: Xenomorfo #36) não tem logica nem dados. |                                                              
| Component | Contem dados puros (ex: posição, Energia, Tipo, Visão).        |                         
| System    | Contem Logica, processa entidades com certos componentes.      |  

<h3>📌Exemplo:<h3/>
* Entity : FaceHugger
* Components: 
  * PositionComponent(x,y)
  * HealthComponent
  * BehaviorComponent(estado atual: caçando, perseguindo)
  * LifecycleComponent(tempo de vida, fase)
* System:
 * MovementSystem
 * AI_BehaviorSystem
 * AttackSystem
 * LifeCycleSystem

➡️ Vantagens:
* Altamente modular
* Facilita a adição de novos tipos de xenomorfos ou variações
* Permite simular milhares de entidades com comportamento isolado
* Reutilização de sistemas entre diferentes entidades

### **MVC:**
<p>
Separar interface grafica da logica é essencial e mesmo que no inicio o projeto seja apenas com saidas no console,
podemos evoluir para uma interface de forma eficiente.</p>

* Model: contém os dados da simulação(estado do mapa, entidades, colmeias e etc)
* View : desenha o mapa, mostra dados de entidades e logs
* Controller : gerencia o input do usuario e interaçoes com o sistema.

### **ORGANIZAÇÂO MODULAR(ESBOÇO):**

````
com.simuladorxeno
├── core             -> Loop principal, tempo, motor da simulação
├── ecs
│   ├── entity
│   ├── component
│   └── system
├── model            -> Modelos de dados (ambiente, recursos, etc.)
├── ai               -> Inteligência artificial dos xenomorfos
├── view             -> Interface (console, GUI)
├── controller       -> Entrada de usuário e controle de simulação
├── utils            -> Classes utilitárias (log, random, etc.)
````

## 🔚 Conclusão

**_A combinação de ECS para lógica de simulação com MVC para interface oferece:_**

* ✅ Separação clara entre lógica, visualização e dados
* ✅ Flexibilidade para simular vários tipos de entidades
* ✅ Facilidade de escalar o projeto no futuro
* ✅ Modularidade para testes e manutenção

#### **logo posto o repositorio oficial do projeto mais hj foi isso** 

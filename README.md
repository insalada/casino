<h1>ipbSoft Casino</h1>

This is a Casino implementation approach. Players are generated randomly. Each pick a game up and starts playing in parallel.

<h2>What is it for?</h2>

It is a convenient exercise that makes use of:
- Java J2SE stand-alone
- Spring framework 4
- Annotations based configuration, Spring Properties
- Maven 2
- Log4j2
- Multithreading
- JUnit
- Factory Design Pattern within Spring (funny)
- BigDecimal and probabilities

<h2>Description</h2>

Implement a simplified casino where players are able to bet and earn money.

1. The casino must support N players playing at the same time, in different games, with different options each
2. User stops playing when either time is over or money is gone
3. Must be possible to trace every player movement as well as the transaction succeed
4. There is an special common prize named Jackpot, where every users contributes with an estimated bet percentage

<h2>Specifications</h2>

User:
  * Unique ID
  * Balance
  * Playing time
  * Waiting time (inbetween bets)
  * Provider
  
Game Config:
  * Unique ID
  * Game type
  * Configuration (min/max bet)
  * Win a prize probability

<h2>Implementation</h2>
  
- The systems generates players from a provider, then they choose a game to play.
- User bets between predefined min and max bet.
- After the bet, there is a chance to win the prize based on the predifined game probability. There is also a chance to win the jackpot.
- Transactions info must be output into the console and a log file.
- Config must be defined as Properties.

Application to compare 2 pokerhands. All cards consist of a pair of 2 letters. The first one for the suit and the second one for the value, e.g.: D8 (Eight of Diamonds), HK (King of Hearts)

Suits: (H)earts, (S)pades, (C)lubs, (D)iamonds
Values: 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A

Use „java examples.pokerhands.client.ConsoleClient“ for a simple demo client.

With this client, you will have to enter a whole hand (5 cards). Use blanks as separator, e.g.: „D3 H5 CK SQ ST“

You can build the project with the included eclipse project (oxygen) or via maven:

- "mvn compile" will compile the project
- "mvn test" will execute all tests and generate a coverage report in  $(BASE)/target/site/jacoco/index.html

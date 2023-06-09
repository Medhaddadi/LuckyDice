## Lucky Dice Roll

This repository contains my solution for the "3 Dice Roll" application specification. The application allows the user to roll three dice in any order, each numbered 1, 2, or 3. The text field allows the user to indicate which die to roll, and the roll is triggered by clicking the "Roll the Dice" button.

- If a player rolls the same die more than once, the game ends and the player receives a score of -1.

The score is calculated based on the following rules:

- If (die 1) < (die 2) < (die 3), the player's score is equal to the value of (die 3).
- If (die 1) > (die 2) > (die 3), the player's score is equal to (die 1) * (die 2) * (die 3).
- If none of the above conditions apply, the player receives a score of zero.
- The application handles all possible cases for comparison and terminates when three dice have been rolled or when a die is rolled twice. 
- The score is displayed and saved in a database. 
- The application allows the user to switch between using a MySQL database and storing data in the application's context.

### Note: 
- The file containing the MySQL database tables can be found in the app folder and is named "jeudesensah.sql".
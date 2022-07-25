# CS Unplugged Activity Plan
#### by Team :snake::wrench:!
Roster: Kiana Herr, David Moste, Nicole Cojuangco, Marieke Thomas

# Conditionals / Be the Code
### Students act out code based on provided conditions.
### OBJECTIVE: SWBAT interpret and implement simple if/then statements

### Background
* Borrowed the concept from "follow the directions" tests
* First direction is traditionally to read all directions OR to flip to the end
* Students who do not follow the directions follow crazy instructions or complete difficult questions

### Participant pre-requisites
Students are familiar with Booleans and have discussed conditionals -- they have worked with if/else statements before. This is a review to check their understanding!

### Scaffolding / Differentiation 
* Advanced students can do the bonus round!
* Intentional time built in for students to process for the first few rounds before taking action
* Visual supplement to go with first (and maybe 2nd round) [e.g. the input being called out is posted clearly and in huge font...a revealed slide between 1st and 2nd round explaining hows/whys of round 1]
* accommodation: be mindful of abilities and inclusivity when creating commands (ex. physical mobility)
* splitting round 1 into a & b as a check for understanding
* adding visual supplement for explanation (nesting and python indentation for round 2)

### Go!
1. Students get a set of instructions and an input value. Input is provided by the teacher. Each round of instructions has sub-rounds with different inputs. Instructions will be modified after each round to increase complexity.
2. Students should record which commands they do/don't follow for each different input
3. Round 1a: (input = 4)
   ```
   if input > 5:
     Stand on a chair
     Raise your right hand
     Turn around three times
     Sit on the floor
   ```

4. Round 1b: (same code, input = 13)
   ```
   if input > 5:
     Stand on a chair
     Raise your right hand
     Turn around three times
     Sit on the floor
   ```
   
5. Round 2: (2a: input = 9, 2b: input = 3, 2c: input = 7)
   ```
   if input > 5:
     Stand up (on the floor)
     hop on one foot 3 times
     if input == 7:
       Pat your head
       if input < 7:
         Spin in a circle
   
     if input < 7:
       High five a neighbor
   ```
6. Round 3: (3a: input = 6, 3b: input = 10, 3c: input = 3, ask: What input could be used to get to the "Bark like a dog" line?[Answer: 5] Which input could be used to get to Meow like a cat? [Answer: 8] Challenge: Which instruction is impossible to reach? [Answer: Lick your elbow])
   ```
   if input == 3:
     Cluck like a chicken
   
   input = input + 3
   
   if input < 9:
     Touch your toes
     input = input - 3
   
   if input >= 5:
     Shake hands with a partner
     if input > 7:
       Stick out your tongue
       if input == 11:
         Meow like a cat
     else if input < 7:
       Bark like a dog
       input = input + 1
     else:
       Lick your elbow
   
   if input < 5:
     Sit down
     Fold your hands on your desk
     Wiggle your ears
   ```
8. Bonus round: Each group makes instructions for another group to follow. They trade and execute the other group's pseudocode
9. Student activity: Create a set of conditional instructions for students to move to either side of the room so that specific people end up on a specific side in no fewer than 7 steps, no names allowed.
 
### Related resources
* [Python Conditionals Practice](http://introtopython.org/if_statements.html)
* [Sample directions quiz](http://www.sanchezclass.com/docs/Directions%20Test.pdf)

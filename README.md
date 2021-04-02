# snapcheck-coding-challenge

This was a quick little coding challenge for a job application to SnapCheck, Inc. 

## About the program
The program performs a simple cypher that takes a string, removes whitespace, and represents 
it as a grid that is as close to square as possible. If *l* represents the length of the string, 
then the dimensions of the grid *rows* and *cols* fall within the constraints 
⌊√*l*⌋ ≤ *rows* ≤ *cols* ≤ ⌈√*l*⌉ 

It then reads the string column by column, separating each column with a space.
#### Example:
```
have a nice day
```

becomes...

```
haveaniceday
```

then...

```
have
anic
eday
```

finally...

```
hae and via ecy
```

The cypher is described more detail here [here](https://github.com/mountainowl/snapcheck-internship-2020/tree/master/backend).

## My approach
As the description of the cypher uses a matrix to represent an intermediate step, if I were to implement the algorithm as demonstrated,
I would be creating a bunch of extra memory, which is slow. Instead, I iterate through the string in 1 character a time, jumping forward 
by the number of columns. Once I reach the end of the string, I start back a the beginning, offset from my initial position by 1. I repeat
this process until the offset when I loop back is equal to the number of columns. The nice thing about this approach is that we don't have 
to worry about how many rows there are. The math takes care of that for us.

## Running the program
I developed this in a Linux environment, but it should work fine with any version of Java on any system (though I only tested 8, 11, and 15).

### If you have `make`
**To Build:**

```
make
```

**To Run:**

```
java Encryptor [string]
```
*or*
```
[SOME_COMMAND] | java Encryptor
```

**To Run Tests (requires** `pytest`**):**

```
make test
```

### If you do not have `make`
**To Build:**

```
javac Encryptor.java
```

**To Run:**

```
java Encryptor [string]
```
*or*
```
[SOME_COMMAND] | java Encryptor
```

**To Run Tests (requires** `pytest`**):**

```
pytest test_encryptor.py
```

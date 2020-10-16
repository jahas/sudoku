# Sudoku analyzer

- [Sudoku analyzer](#sudoku-analyzer)
  - [Technology](#technology)
  - [Usage](#usage)
  - [Comments](#comments)
  
**Sudoku** tool has been designed to check if sudoku table is valid.

*Valid* means that there are no repetitions of digit inside row, column or box.

Let's take a look at examples:

This sudoku is VALID:

```csv
4,3,5,2,6,9,7,8,1
6,8,2,5,7,1,4,9,3
1,9,7,8,3,4,5,6,2
8,2,6,1,9,5,3,4,7
3,7,4,6,8,2,9,1,5
9,5,1,7,4,3,6,2,8
5,1,9,3,2,6,8,7,4
2,4,8,9,5,7,1,3,6
7,6,3,4,1,8,2,5,9
```

This sudoku is valid as well:

```csv
 ,9,4, ,3, ,1, , 
8,1,2,7, , , ,9,6
3, , ,1,9, , , , 
 ,3, ,9, ,4,6, , 
 , ,8,6,1,3, ,4,9
 , ,6,2, , , , ,1
4, ,3,5, , , , ,8
5, , , ,2, ,7, , 
 ,6, , , ,8,4,1,5
 ```

 This sudoku is INVALID:

 ```csv
duplication
     |
     v
  ,9,4, ,3, ,1, , 
8,1,3,7, , , ,9,6
3, , ,1,9, , , , 
 ,3, ,9, ,4,6, , 
 , ,8,6,1,3, ,4,9
 , ,6,2, , , , ,1
4, ,3,5, , , , ,8
5, , , ,2, ,7, , 
 ,6, , , ,8,4,1,5
 ```

## Technology

I have used:

- Scala 2.12.12
- Maven (according to requirements)
- VS Code with extensions
  - Scala (metals)
  - Scala Syntax
  - Maven for Java

## Usage

Clone the repository first:

```console
git clone https://github.com/jahas/sudoku.git
```

Ensure that the following software is installed on your laptop:

- scala 2.12.12
- maven
- java 1.8 or java 11

Run command

```console
mvn clean package
```

Go to `target` folder and run the `run` file using this command:

```console
sh run
```

to obtain help messages.

## Comments

I wanted to used some data science library for scala. The only library that could be used with this version of scala is spark, but it would be an overkill. Finally I have decided to stay with scala's internal data structures.

Hope you like it since for me it was quite big fun to write this code :)

![pic](https://user-images.githubusercontent.com/26244906/32988809-a79ac09a-ccc0-11e7-8458-d7d337c731d7.png)






# Overview 
Espresso is a very basic programming language and the Interpreter is written in java. This language can be used to write scripts that perform complicated calculations in very customized way.
Download the source code and contribute to expand the functionalities of Espresso

### Below is the layout and functionalities of Espresso
## Valid Keywords
- Read: This keyword reads a variablename and prompts a message asking for the value of 
that variable.
  
- Print: This keyword prints the value of variable or expression that is written after 
print keyword.

- Variable Name: There are 48 valid varaible names in Espresso language. These are all 
uppercase and lowercase English Alphabets.

## Valid Datatypes
- Integer: The only valid data type in Espresso is Integer Numbers. Since this is built
for calculation only numbers are allowed.

## Valid Statements
- Assignment: Left hand side of this statement should be a valid variable and Right hand
side can be a valid infix expression or an Integer value.

```
x = 5
```
```
z = y+x*x+y
```
- Input Statement: Left hand side should be the valid keyword read and Right handn side
should be valid variable
```
read x
```
- Output Statement: Left hand side should be the keyword print and right hand side can be 
an infix expression or just a defined variable

```
print x
```
```
print (x+y)/5
```


## Valid Operators
#### +   Addition
#### -   Subtraction
#### *   Multiplication
#### /   Division
#### ( ) Brackets
#### =   Assignment

## Syntax Errors
- ```Invalid Data type:``` This error occurs when a user enters or assigns a value that is
not an Integer
- ```Invalid Operator:``` Thie error occurs when a user uses an operator that is not supported
by the Espresso

- `Invalid Expressoin: ` This error occurs when an infix expression is wrong.Example:  
inappropriate number brackets, Invalid Operator, Unary Operator or any Syntax error is 
present

- `Invalid Keyword:` This error occurs when the used keyword is not supported by the Espresso

## Undefiend Variable Error
- Undefined Variable: This error occurs when the variable is not Valid or it has not 
been initialized yet.

## Valid Extension
Espresso Language supports the .esp extension. Every script file should be saved with .esp extension.


# Getting Started

###### Open your terminal
`git clone https://github.com/vikramsingh7/Espresso.git
 cd Espresso`
 
 

 - Write a simple Espresso script and save it with as .esp extension.
 - sample.esp and the source code of Interpreter should be in same repository
 - Since the interpreter is written in java we have to use some java keyword while running our script

###### Open your terminal
- Since the main function is located in ESPInterpreter.java class
` javac ESPInterpreter.java `
- Running our Espresso script 
 ` java ESPInterpreter sample.esp` 
- Output will be the result of your source code 





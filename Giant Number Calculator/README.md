### Giant Number Calculator

For this project, I have created a Java program that performs additive and subtractive operations on large integers.

**Purpose**

The limitations of integers in Java are restricted between -2147483648 and 2147483647. Therefore, any number larger than 2147483647 or smaller than -2147483647 cannot be used in any arithmetic calculations. Similarly, the result of any operation cannot be be larger than 2147483647 or smaller than -2147483647. The purpose of this program is to handle basic additive and subtractive operations on large numbers that do not qualify as integers identifiable by Java.

**How to Run**

The program can be run in the terminal. Following the file name, the user can type out the first large number for addition, followed by a space, and finally the second large number for addition. The command line arguments can handle a negative value by typing "-" before the number.

_To change the operation to subtraction, open the file and modify the final line of the `main` method and change_ `System.out.println(int1.plus(int2));` _to_ `System.out.println(int1.minus(int2));`.

**Ex:**

`12345678901 98765432101`
`-56789012345 54321098765`
`78901234567 -76543210987`
`-34567890123 -32109876543`

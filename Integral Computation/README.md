### Integral Computation

For this project, I have created a Java program that can calculate the area underneath a specified bounded curve using Riemann Integration. The project was originally designed to model a Skateboard Ramp, however it can be applied to any function identified in the command line. 

**Purpose**

This program can estimate the area under a given curve using Riemann Integration, which divides the area underneath the bounded curve into rectangles so the actual area of the curve can be more accurately assessed. The program accepts either Polynomial functions or Sin functions as input. 

**How to Run**

The program can be run in the terminal. Following the file name, the user can first type out the type of function, either "poly" for polynomial functions or "sin" for sin functions. 

For a polynomial function, the arguments following "poly" are the coefficients of the polynomial function. For example; providing three coefficients results in the use of a quadratic equation (a coefficient for the x^2 term, a coeffcient for the x term, and a constant). The sin function will not have any coefficients. For both polynomial and sin functions, the final two arguments in the command line will be the lower bound and the upper bound of the curve, in this order. This means the final argument cannot be less than that of the preceding argument. 

The program will output the estimated area under the curve between the two bounds using Riemann Integration.

**Ex:**

`poly 0 10 -2 -1 5 1e-6`

`sin -0.27 3.55`


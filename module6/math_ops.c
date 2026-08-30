#include <stdio.h> 

void print_math(int a, int b);
 
int main() {
    int a;
    int b;

    printf("Enter int for variable a: ");
    scanf("%d", &a);

    printf("Enter int for variable b: ");
    scanf("%d", &b);

    print_math(a,b);
    return 0; 
}

void print_math(int a, int b){
    int sum = a + b;
    int product = a * b;

    printf("Sum: %d\n", sum);
    printf("Product: %d\n", product);
}
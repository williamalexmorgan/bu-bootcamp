#include <stdio.h>

void swap(int *a, int *b);
void broken_swap(int a, int b);
 
int main() { 
    int x = 10; 
    int y = 20; 

    printf("Before: x = %d, y = %d\n", x, y); 

    swap(&x, &y); 

    printf("After Swap:  x = %d, y = %d\n", x, y);

    broken_swap(x, y); 

    printf("After Broken Swap:  x = %d, y = %d\n", x, y); 

    return 0;
}

void swap(int *a, int *b) { 
    int temp = *a;
    *a = *b;      
    *b = temp;
}

//because the function receives copies, not addresses like swap function
void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}
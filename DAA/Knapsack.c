#include <stdio.h>

void fractionalKnapsack(int n, float weight[], float value[], float capacity) {
    float x[20], tp = 0;   // x[i] stores the fraction of item taken
    int i, j, u;
    float ratio[20], temp;

    u = capacity;

    // Calculate ratio = value/weight
    for(i = 0; i < n; i++) {
        ratio[i] = value[i] / weight[i];
    }

    // Sorting by ratio in descending order
    for(i = 0; i < n; i++) {
        for(j = i + 1; j < n; j++) {
            if(ratio[i] < ratio[j]) {

                // Swap ratio
                temp = ratio[i];
                ratio[i] = ratio[j];
                ratio[j] = temp;

                // Swap weight
                temp = weight[i];
                weight[i] = weight[j];
                weight[j] = temp;

                // Swap value
                temp = value[i];
                value[i] = value[j];
                value[j] = temp;
            }
        }
    }

    // Initialize x[i] = 0
    for(i = 0; i < n; i++) {
        x[i] = 0.0;
    }

    // Greedy selection
    for(i = 0; i < n; i++) {
        if(weight[i] > u)
            break;
        else {
            x[i] = 1.0;
            tp = tp + value[i];
            u = u - weight[i];
        }
    }

    if(i < n)
        x[i] = u / weight[i];

    tp = tp + (x[i] * value[i]);

    // Output
    printf("\nItem\tWeight\tValue\tFraction");
    for(i = 0; i < n; i++) {
        printf("\n%d\t%.2f\t%.2f\t%.2f", i+1, weight[i], value[i], x[i]);
    }
    printf("\n\nMaximum value in knapsack = %.2f\n", tp);
}

int main() {
    float weight[20], value[20], capacity;
    int n, i;

    printf("Enter number of items: ");
    scanf("%d", &n);

    printf("Enter weight and value of each item:\n");
    for(i = 0; i < n; i++) {
        scanf("%f %f", &weight[i], &value[i]);
    }

    printf("Enter capacity of knapsack: ");
    scanf("%f", &capacity);

    fractionalKnapsack(n, weight, value, capacity);
    return 0;
}

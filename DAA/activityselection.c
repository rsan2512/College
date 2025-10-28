#include <stdio.h>

// Function to perform activity selection
void activitySelection(int start[], int finish[], int n) {
    int i, j;

    printf("Selected activities are:\n");
    i = 0;  // First activity always selected
    printf("A%d ", i + 1);

    // Check the rest of the activities
    for (j = 1; j < n; j++) {
        if (start[j] >= finish[i]) {
            printf("A%d ", j + 1);
            i = j;
        }
    }
}

int main() {
    int n, i, j, temp;
    printf("Enter number of activities: ");
    scanf("%d", &n);

    int start[n], finish[n];

    printf("Enter start times:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &start[i]);

    printf("Enter finish times:\n");
    for (i = 0; i < n; i++)
        scanf("%d", &finish[i]);

    // Sort activities by finish time (ascending order)
    for (i = 0; i < n - 1; i++) {
        for (j = i + 1; j < n; j++) {
            if (finish[i] > finish[j]) {
                // Swap finish time
                temp = finish[i];
                finish[i] = finish[j];
                finish[j] = temp;

                // Swap corresponding start time
                temp = start[i];
                start[i] = start[j];
                start[j] = temp;
            }
        }
    }

    activitySelection(start, finish, n);
    return 0;
}

#include <stdio.h>
#include <stdlib.h>

// Structure for Process
typedef struct {
    int id;
    int arrival;
    int burst;
    int rem_burst;
    int priority;
    int wait;
    int tat;
    int ct;
} Proc;

// Function to swap two processes
void swap(Proc *a, Proc *b) {
    Proc temp = *a;
    *a = *b;
    *b = temp;
}

// Function to copy processes
void copy_proc(Proc dest[], Proc src[], int n) {
    for (int i = 0; i < n; i++) {
        dest[i].id = src[i].id;
        dest[i].arrival = src[i].arrival;
        dest[i].burst = src[i].burst;
        dest[i].priority = src[i].priority;
        dest[i].rem_burst = src[i].burst;
        dest[i].wait = 0;
        dest[i].tat = 0;
        dest[i].ct = 0;
    }
}

// FCFS Implementation
void fcfs(Proc p[], int n) {
    Proc procs[100];
    copy_proc(procs, p, n);
    
    // Sort by arrival time
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (procs[i].arrival > procs[j].arrival) {
                swap(&procs[i], &procs[j]);
            }
        }
    }
    
    int time = 0;
    int complete = 0;
    printf("\nFCFS Gantt Chart: |");
    while (complete < n) {
        int curr = complete;  // Next in sorted order
        time = (time > procs[curr].arrival) ? time : procs[curr].arrival;
        
        int exec = procs[curr].rem_burst;
        for (int k = 0; k < exec; k++) {
            printf("P%d ", procs[curr].id);
        }
        time += exec;
        procs[curr].ct = time;
        procs[curr].tat = time - procs[curr].arrival;
        procs[curr].wait = procs[curr].tat - procs[curr].burst;
        procs[curr].rem_burst = 0;
        complete++;
    }
    printf("|\n");
    
    double sumw = 0, sumt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d: Waiting Time = %d, Turnaround Time = %d\n", procs[i].id, procs[i].wait, procs[i].tat);
        sumw += procs[i].wait;
        sumt += procs[i].tat;
    }
    printf("Average Waiting Time: %.2f\n", sumw / n);
    printf("Average Turnaround Time: %.2f\n", sumt / n);
    
    // Comment: FCFS is simple and fair in order of arrival but can suffer from convoy effect if a long job arrives first.
}

// SJF Non-Preemptive
void sjf(Proc p[], int n) {
    Proc procs[100];
    copy_proc(procs, p, n);
    
    int time = 0;
    int complete = 0;
    printf("\nSJF (Non-Preemptive) Gantt Chart: |");
    while (complete < n) {
        int min_burst = 9999;
        int min_idx = -1;
        for (int i = 0; i < n; i++) {
            if (procs[i].arrival <= time && procs[i].rem_burst > 0 && procs[i].rem_burst < min_burst) {
                min_burst = procs[i].rem_burst;
                min_idx = i;
            }
        }
        if (min_idx == -1) {
            printf("Idle ");
            time++;
            continue;
        }
        int exec = procs[min_idx].rem_burst;
        for (int k = 0; k < exec; k++) {
            printf("P%d ", procs[min_idx].id);
        }
        time += exec;
        procs[min_idx].ct = time;
        procs[min_idx].tat = time - procs[min_idx].arrival;
        procs[min_idx].wait = procs[min_idx].tat - procs[min_idx].burst;
        procs[min_idx].rem_burst = 0;
        complete++;
    }
    printf("|\n");
    
    double sumw = 0, sumt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d: Waiting Time = %d, Turnaround Time = %d\n", procs[i].id, procs[i].wait, procs[i].tat);
        sumw += procs[i].wait;
        sumt += procs[i].tat;
    }
    printf("Average Waiting Time: %.2f\n", sumw / n);
    printf("Average Turnaround Time: %.2f\n", sumt / n);
    
    // Comment: SJF minimizes average waiting time for non-preemptive case, best for batch systems with varying job lengths.
}

// SRTF Preemptive
void srtf(Proc p[], int n) {
    Proc procs[100];
    copy_proc(procs, p, n);
    
    int time = 0;
    int complete = 0;
    printf("\nSRTF (Preemptive) Gantt Chart: |");
    while (complete < n) {
        int min_rem = 9999;
        int min_idx = -1;
        for (int i = 0; i < n; i++) {
            if (procs[i].arrival <= time && procs[i].rem_burst > 0 && procs[i].rem_burst < min_rem) {
                min_rem = procs[i].rem_burst;
                min_idx = i;
            }
        }
        if (min_idx == -1) {
            printf("Idle ");
            time++;
            continue;
        }
        printf("P%d ", procs[min_idx].id);
        procs[min_idx].rem_burst--;
        time++;
        if (procs[min_idx].rem_burst == 0) {
            complete++;
            procs[min_idx].ct = time;
            procs[min_idx].tat = time - procs[min_idx].arrival;
            procs[min_idx].wait = procs[min_idx].tat - procs[min_idx].burst;
        }
    }
    printf("|\n");
    
    double sumw = 0, sumt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d: Waiting Time = %d, Turnaround Time = %d\n", procs[i].id, procs[i].wait, procs[i].tat);
        sumw += procs[i].wait;
        sumt += procs[i].tat;
    }
    printf("Average Waiting Time: %.2f\n", sumw / n);
    printf("Average Turnaround Time: %.2f\n", sumt / n);
    
    // Comment: SRTF is optimal for minimizing average waiting time in preemptive scenario but may starve long jobs.
}

// Priority Non-Preemptive (lower number = higher priority)
void priority_non(Proc p[], int n) {
    Proc procs[100];
    copy_proc(procs, p, n);
    
    int time = 0;
    int complete = 0;
    printf("\nPriority (Non-Preemptive) Gantt Chart: |");
    while (complete < n) {
        int min_pri = 9999;
        int min_idx = -1;
        for (int i = 0; i < n; i++) {
            if (procs[i].arrival <= time && procs[i].rem_burst > 0 && procs[i].priority < min_pri) {
                min_pri = procs[i].priority;
                min_idx = i;
            }
        }
        if (min_idx == -1) {
            printf("Idle ");
            time++;
            continue;
        }
        int exec = procs[min_idx].rem_burst;
        for (int k = 0; k < exec; k++) {
            printf("P%d ", procs[min_idx].id);
        }
        time += exec;
        procs[min_idx].ct = time;
        procs[min_idx].tat = time - procs[min_idx].arrival;
        procs[min_idx].wait = procs[min_idx].tat - procs[min_idx].burst;
        procs[min_idx].rem_burst = 0;
        complete++;
    }
    printf("|\n");
    
    double sumw = 0, sumt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d: Waiting Time = %d, Turnaround Time = %d\n", procs[i].id, procs[i].wait, procs[i].tat);
        sumw += procs[i].wait;
        sumt += procs[i].tat;
    }
    printf("Average Waiting Time: %.2f\n", sumw / n);
    printf("Average Turnaround Time: %.2f\n", sumt / n);
    
    // Comment: Non-preemptive priority favors high-priority jobs but low-priority jobs may wait indefinitely (starvation possible).
}

// Priority Preemptive
void priority_pre(Proc p[], int n) {
    Proc procs[100];
    copy_proc(procs, p, n);
    
    int time = 0;
    int complete = 0;
    printf("\nPriority (Preemptive) Gantt Chart: |");
    while (complete < n) {
        int min_pri = 9999;
        int min_idx = -1;
        for (int i = 0; i < n; i++) {
            if (procs[i].arrival <= time && procs[i].rem_burst > 0 && procs[i].priority < min_pri) {
                min_pri = procs[i].priority;
                min_idx = i;
            }
        }
        if (min_idx == -1) {
            printf("Idle ");
            time++;
            continue;
        }
        printf("P%d ", procs[min_idx].id);
        procs[min_idx].rem_burst--;
        time++;
        if (procs[min_idx].rem_burst == 0) {
            complete++;
            procs[min_idx].ct = time;
            procs[min_idx].tat = time - procs[min_idx].arrival;
            procs[min_idx].wait = procs[min_idx].tat - procs[min_idx].burst;
        }
    }
    printf("|\n");
    
    double sumw = 0, sumt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d: Waiting Time = %d, Turnaround Time = %d\n", procs[i].id, procs[i].wait, procs[i].tat);
        sumw += procs[i].wait;
        sumt += procs[i].tat;
    }
    printf("Average Waiting Time: %.2f\n", sumw / n);
    printf("Average Turnaround Time: %.2f\n", sumt / n);
    
    // Comment: Preemptive priority ensures high-priority jobs interrupt low ones, suitable for real-time systems but risks starvation.
}

// Round Robin
void rr(Proc p[], int n, int quantum) {
    Proc procs[100];
    copy_proc(procs, p, n);
    
    // Sort by arrival time
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (procs[i].arrival > procs[j].arrival) {
                swap(&procs[i], &procs[j]);
            }
        }
    }
    
    int time = 0;
    int complete = 0;
    int idx = 0;  // Next process index
    int queue[100];
    int front = 0, rear = 0;
    printf("\nRound Robin (Quantum = %d) Gantt Chart: |", quantum);
    
    while (complete < n) {
        // Add arrived processes to queue
        while (idx < n && procs[idx].arrival <= time) {
            queue[rear] = idx;
            rear++;
            idx++;
        }
        
        if (front == rear) {  // Queue empty
            if (idx < n) {
                time = procs[idx].arrival;
                continue;
            } else {
                break;
            }
        }
        
        // Dequeue
        int curr = queue[front];
        front++;
        
        // Execute min(quantum, rem_burst)
        int exec = (procs[curr].rem_burst < quantum) ? procs[curr].rem_burst : quantum;
        for (int k = 0; k < exec; k++) {
            printf("P%d ", procs[curr].id);
        }
        time += exec;
        procs[curr].rem_burst -= exec;
        
        if (procs[curr].rem_burst > 0) {
            // Enqueue back
            queue[rear] = curr;
            rear++;
        } else {
            complete++;
            procs[curr].ct = time;
            procs[curr].tat = time - procs[curr].arrival;
            procs[curr].wait = procs[curr].tat - procs[curr].burst;
        }
    }
    printf("|\n");
    
    double sumw = 0, sumt = 0;
    for (int i = 0; i < n; i++) {
        printf("P%d: Waiting Time = %d, Turnaround Time = %d\n", procs[i].id, procs[i].wait, procs[i].tat);
        sumw += procs[i].wait;
        sumt += procs[i].tat;
    }
    printf("Average Waiting Time: %.2f\n", sumw / n);
    printf("Average Turnaround Time: %.2f\n", sumt / n);
    
    // Comment: RR provides fairness and good response time for interactive systems; performance depends on quantum (small: more context switches, large: like FCFS).
}

int main() {
    int n, quantum;
    printf("Enter number of processes: ");
    scanf("%d", &n);
    
    Proc p[100];
    for (int i = 0; i < n; i++) {
        printf("Enter Process ID, Arrival Time, Burst Time, Priority for Process %d: ", i + 1);
        scanf("%d %d %d %d", &p[i].id, &p[i].arrival, &p[i].burst, &p[i].priority);
        p[i].rem_burst = p[i].burst;
    }
    
    printf("Enter Time Quantum for RR: ");
    scanf("%d", &quantum);
    
    // Run all algorithms
    fcfs(p, n);
    sjf(p, n);
    srtf(p, n);
    priority_non(p, n);
    priority_pre(p, n);
    rr(p, n, quantum);
    
    // Overall Analysis (printed as comments in functions, but summarized here):
    // - For short jobs dominant: SJF/SRTF best (low avg wait).
    // - For varying priorities: Priority scheduling favors important jobs.
    // - For time-sharing: RR best (bounded wait).
    // - General: SRTF often optimal avg wait but high overhead; FCFS simple but poor for uneven bursts.
    
    return 0;
}
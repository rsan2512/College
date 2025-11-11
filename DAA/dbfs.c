#include <stdio.h>
#include <stdlib.h>

#define WHITE 0
#define GRAY 1
#define BLACK 2
#define MAX 100

struct Node {
    int vertex;
    struct Node* next;
};

struct VertexInfo {
    int color;
    int distance;
    int parent;
};

struct Node* adj[MAX];
struct VertexInfo info[MAX];
int n; // number of vertices
struct Node* createNode(int v) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->vertex = v;
    newNode->next = NULL;
    return newNode;
}

void addEdge(int src, int dest) {
    struct Node* newNode = createNode(dest);
    newNode->next = adj[src];
    adj[src] = newNode;

    // For undirected graph
    newNode = createNode(src);
    newNode->next = adj[dest];
    adj[dest] = newNode;
}
void BFS(int s) {
    int queue[MAX];
    int front = 0, rear = 0;

    for (int u = 0; u < n; u++) {
        info[u].color = WHITE;
        info[u].distance = 99999; // infinity
        info[u].parent = -1;
    }

    info[s].color = GRAY;
    info[s].distance = 0;
    info[s].parent = -1;

    queue[rear++] = s;

    printf("\nBFS Traversal starting from %d:\n", s);

    while (front < rear) {
        int u = queue[front++];
        printf("%d ", u);

        struct Node* temp = adj[u];
        while (temp) {
            int v = temp->vertex;
            if (info[v].color == WHITE) {
                info[v].color = GRAY;
                info[v].distance = info[u].distance + 1;
                info[v].parent = u;
                queue[rear++] = v;
            }
            temp = temp->next;
        }
        info[u].color = BLACK;
    }
    printf("\n");
}
int timeCounter = 0;

void DFS_Visit(int u) {
    timeCounter++;
    info[u].distance = timeCounter; // discovery time
    info[u].color = GRAY;
    printf("%d ", u);

    struct Node* temp = adj[u];
    while (temp) {
        int v = temp->vertex;
        if (info[v].color == WHITE) {
            info[v].parent = u;
            DFS_Visit(v);
        }
        temp = temp->next;
    }

    info[u].color = BLACK;
    timeCounter++;
}

void DFS() {
    for (int u = 0; u < n; u++) {
        info[u].color = WHITE;
        info[u].parent = -1;
    }

    timeCounter = 0;
    printf("\nDFS Traversal:\n");
    for (int u = 0; u < n; u++) {
        if (info[u].color == WHITE)
            DFS_Visit(u);
    }
    printf("\n");
}
int main() {
    int edges, src, dest, start;

    printf("Enter number of vertices: ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
        adj[i] = NULL;

    printf("Enter number of edges: ");
    scanf("%d", &edges);

    printf("Enter edges (src dest):\n");
    for (int i = 0; i < edges; i++) {
        scanf("%d %d", &src, &dest);
        addEdge(src, dest);
    }

    printf("Enter starting vertex for BFS: ");
    scanf("%d", &start);

    BFS(start);
    DFS();

    return 0;
}

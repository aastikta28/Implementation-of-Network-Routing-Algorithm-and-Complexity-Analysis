package algoproject;

public class MaxHeap
{
    private int[] data;
    private int[] index;
    public int[] cost;
    private int size;

    public MaxHeap(int n) {
        data = new int[n];
        index = new int[n];
        cost = new int[n];

        for (int i = 0; i < n; i++) {
            index[i] = -1;
            cost[i] = -1;
        }

        size = 0;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    private void shiftUp(int i) {
        int j;
        while (i > 0) {
            j = (i - 1) / 2;
            if (cost[data[i]] > cost[data[j]]) {
                // swap here
                int temp = index[data[i]];
                index[data[i]] = index[data[j]];
                index[data[j]] = temp;
                // swap here
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;
                i = j;
            } else
                break;
        }
    }

    private void shiftDown(int i) {
        int j, k;
        while (2 * i + 1 < size) {
            j = 2 * i + 1;
            k = j + 1;
            if (k < size && cost[data[k]] > cost[data[j]]
                    && cost[data[k]] > cost[data[i]]) {
                int temp = index[data[k]];
                index[data[k]] = index[data[i]];
                index[data[i]] = temp;
                temp = data[k];
                data[k] = data[i];
                data[i] = temp;

                i = k;
            } else if (cost[data[j]] > cost[data[i]]) {
                int temp = index[data[j]];
                index[data[j]] = index[data[i]];
                index[data[i]] = temp;
                temp = data[j];
                data[j] = data[i];
                data[i] = temp;

                i = j;
            } else
                break;
        }
    }

    public int pop() {
        int res = data[0];
        data[0] = data[size - 1];
        index[data[0]] = 0;
        size--;
        shiftDown(0);
        return res;
    }

    public void push(int x, int c) {
        if (index[x] == -1) {
            cost[x] = c;
            data[size] = x;
            index[x] = size;
            size++;
            shiftUp(index[x]);
        } else {
            if (c < cost[x]) {
                cost[x] = c;
                shiftUp(index[x]);
                shiftDown(index[x]);
            }
        }
    }
}

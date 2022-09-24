import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int n;
    private int size;
    private int[] sites;
    private int open;
    private boolean[] status;

    private WeightedQuickUnionUF uf;
    private int top, bottom;


    public Percolation (int n) {
        n = n;
        size = n * n;
        sites = new int[size];
        open = 0;
        status = new boolean[size];

        top = n*n;
        bottom = top + 1;
        uf = new WeightedQuickUnionUF(size + 2);

        for (int i = 0; i < n; i++) {
            uf.union(i, top);
            uf.union(size - (i + 1), bottom);
        }
    }

    public void open(int row, int col) {
        int index = index(row, col);
        if (!status[index]) {
            status[index] = true;
            open++;
        }
    }

    public boolean isOpen(int row, int col) {
        return status[index(row, col)];
    }

    public boolean isFull(int row, int col) {
        return uf.find(index(row, col)) == uf.find(top);
    }

    public int numberOfOpenSites() {
        return open;
    }

    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }

    private int index(int row, int col) {
        return n * (row - 1) + (col - 1);
    }

    public static void main(String[] args) {
    }
}

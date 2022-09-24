import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public final class Percolation {
    private int width;
    private int size;
    private int[] sites;
    private int open;
    private boolean[] status;

    private WeightedQuickUnionUF uf;
    private int top;
    private int bottom;

    public Percolation(final int n) {
        width = n;
        size = width * width;
        sites = new int[size];
        open = 0;
        status = new boolean[size];

        top = width * width;
        bottom = top + 1;
        uf = new WeightedQuickUnionUF(size + 2);

        for (int i = 0; i < width; i++) {
            uf.union(i, top);
            uf.union(size - (i + 1), bottom);
        }
    }

    public void open(final int row, final int col) {
        int index = index(row, col);
        if (!status[index]) {
            status[index] = true;
            open++;
        }
    }

    public boolean isOpen(final int row, final int col) {
        return status[index(row, col)];
    }

    public boolean isFull(final int row, final int col) {
        return uf.find(index(row, col)) == uf.find(top);
    }

    public int numberOfOpenSites() {
        return open;
    }

    public boolean percolates() {
        return uf.find(top) == uf.find(bottom);
    }

    private int index(final int row, final int col) {
        return width * (row - 1) + (col - 1);
    }

    public static void main(final String[] args) {
    }
}


public class TreeNode {
    public int value;
    public int row;
    public int column;
    public boolean active;

    public TreeNode(int v, int r, int c) {
        value = v;
        row = r;
        column = c;
        active = false;
    }

    public String toString() {
        //return (value + " (" + row + " " + column + ") ");
         return (value + "");
    }

    
}
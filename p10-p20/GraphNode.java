import java.util.ArrayList;

public class GraphNode implements Comparable<GraphNode> {
    public int value;
    public int id;
    public ArrayList<GraphNode> neighbors;
    public int max_path;
    public GraphNode best_parent; 

    public GraphNode(int v, int i) {
        value = v;
        id = i;
        max_path = Integer.MIN_VALUE;
        neighbors = new ArrayList<GraphNode>();
    }

    public int getRow(){
        int temp = 0;
        int i = 0;
        for(i=0;temp<=id;i++){
            temp = temp + (i+1);
        }
        return i-1; 
    }

    public int getCol(){
        int temp = 0;
        int i = 0;
        for(i=0;temp<=id;i++){
            temp = temp + (i+1);
        }
        temp = temp - (i+1);

        return id-temp-1; 
    }

    public void addNeighbor(GraphNode g){
        neighbors.add(g);
    }

    public String toString() {
        //return "id: " + id + " = " + value;
        //int row = getRow();
        //int col = getCol();

        //return (col == 0) ? "\n" : "" + value + "(" + row +  "," + col + ")";
        /*if(col==0)
            return "\n"  + value ;
        
        return "" + value;
        */
        return value +"";
        //return ("value = " + value + " " + 
        //     "max_path = " + max_path  
        //     );
    }

    public String toStringDetailed() {
     return ("value = " + value + "\n" + 
             "id =" + id + "\n" + 
             "best_parent = " + best_parent + "\n" + 
             "max_path = " + max_path + "\n" + 
              "neighbors = " + neighbors + "\n");
    }

    @Override
    public int compareTo(GraphNode o) {
        return Integer.compare(this.id, o.id);
    }
}
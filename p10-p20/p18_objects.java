import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.ArrayList;

public class p18_objects {

    /**
     * read all the values into file
     */
    private static ArrayList<GraphNode> readFile(String fname) throws IOException {
        BufferedReader inputStream = null;
        ArrayList<GraphNode> numbers = new ArrayList<GraphNode>();

        try {
            inputStream = new BufferedReader(new FileReader(fname));

            // add each node
            int item = 0;
            String l;
            while ((l = inputStream.readLine()) != null) {
                Integer[] rowItems = Arrays.stream(l.split(" ")).map(n -> Integer.parseInt(n)).toArray(Integer[]::new);
                for (int j = 0; j < rowItems.length; j++) {
                    numbers.add(new GraphNode(rowItems[j], item));
                    item++;
                }
            }

            // add neighbors for each node
            for (int i = 0; i < numbers.size(); i++) {
                GraphNode current = numbers.get(i);

                int childIndex = getIndex(current.getRow() + 1, current.getCol());
                if (childIndex < numbers.size()) {
                    current.addNeighbor(numbers.get(childIndex));
                }
                childIndex++;
                if (childIndex < numbers.size()) {
                    current.addNeighbor(numbers.get(childIndex));
                }
            }

        } catch (Exception ex) {
            System.out.println("Error reading file: " + fname);
            System.out.println(ex);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return numbers;
    }

    public static int getIndex(int row, int col) {
        int temp = 0;
        for (int i = 0; i < row; i++) {
            temp = temp + (i + 1);
        }
        return temp + col;
    }

    public static ArrayList<GraphNode> findMaxPath(GraphNode root) {
        Queue<GraphNode> visited = new PriorityQueue<GraphNode>();
        Queue<GraphNode> unvisisted = new PriorityQueue<GraphNode>();
        unvisisted.add(root);
        root.max_path = root.value;

        while (unvisisted.size() > 0) {
            GraphNode node = unvisisted.remove();
            visited.add(node);

            //System.out.println("visiting " + node.id);
            //System.out.println("\t..." + node.neighbors);

            node.neighbors.forEach(n -> {

                if (!visited.contains(n) && !unvisisted.contains(n)) {
                    unvisisted.add(n);
                }

               if (n.max_path < (node.max_path + n.value)) {
                        n.max_path = node.max_path + n.value;
                        n.best_parent = node;
                        //System.out.println(
                        //        "\t..." + n + " has a new max_path of " + n.max_path + " through " + n.best_parent);
                    
                }
            });
        }

        int overall_max_path = root.max_path;
        GraphNode max_node = root;

        for (GraphNode n : visited) {
            if (overall_max_path < n.max_path) {
                overall_max_path = n.max_path;
                max_node = n;
            }
        }

        ArrayList<GraphNode> path = new ArrayList<GraphNode>();
        path.add(max_node);
        while (max_node.best_parent != null) {
            max_node = max_node.best_parent;
            path.add(max_node);
        }
        return path;

    }

    // p18_2.java [93, 73, 58, 39, 97, 94, 70, 92, 67, 34, 65, 10, 82, 64, 75]
    // p18.java [93, 73, 58, 78, 91, 32, 83, 28, 73, 75, 82, 87, 82, 64, 75]

    public static void main(String[] args) {

        try {
            ArrayList<GraphNode> nodes = readFile(args[0]);
            System.out.println(nodes);

            ArrayList<GraphNode> maxPath = findMaxPath(nodes.get(0));
            System.out.println("best path = " + maxPath);
            /*
            for (GraphNode n : maxPath) {
                System.out.println(n.toStringDetailed());
            }*/
             System.out.println(maxPath.get(0).toStringDetailed());

        } catch (IOException ex) {
            System.out.println("Issues reading file " + args[0]);
        }
    }
}

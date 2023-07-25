import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p18{

/**
     * read all the values into file
     */
    private static ArrayList<List<Integer>> readFile(String fname) {
        BufferedReader inputStream = null;

        ArrayList<List<Integer>> matrix = new ArrayList<List<Integer>>();

        try {
            inputStream = new BufferedReader(new FileReader(fname));

            // add each node
            String l;
            while ((l = inputStream.readLine()) != null) {
                matrix.add ( Arrays.stream(l.split(" ")).map(n -> Integer.parseInt(n)).toList());
            }
            System.out.println(matrix);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try{ 
                    inputStream.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }

        return matrix;
    }


    public static int dfs(ArrayList<List<Integer>> matrix, int col, int row, int maxsum){
        if(row == matrix.size()-1){
            return matrix.get(row).get(col);
        }

        int value = matrix.get(row).get(col);
        return Math.max(dfs(matrix, col, row+1, maxsum), dfs(matrix, col+1, row+1, maxsum)) + value;
    }

    public static void main(String[] args){
        System.out.println("Hello, world!");

        ArrayList<List<Integer>> matrix  = readFile("p18.data");
        System.out.println(dfs(matrix,0,0,0));
    }
}
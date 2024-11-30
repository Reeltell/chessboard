import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            int n = Integer.parseInt(reader.readLine());
            Set<String> cells = new HashSet<>();

            for (int i = 0; i < n; i++) {
                cells.add(reader.readLine().replace(" ", ","));
            }

            int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
            int perimeter = 0;


            for (String cell : cells) {
                String[] parts = cell.split(",");
                int row = Integer.parseInt(parts[0]);
                int col = Integer.parseInt(parts[1]);

                for (int[] dir : directions) {
                    String neighbor = (row + dir[0]) + "," + (col + dir[1]);
                    if (!cells.contains(neighbor)) {
                        perimeter++;
                    }
                }
            }

            writer.write(String.valueOf(perimeter));
        } catch (IOException e) {
            System.err.println("Ошибка работы с файлами: " + e.getMessage());
        }
    }
}




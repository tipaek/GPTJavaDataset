package chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    private static final String ALPHABET = "abcdefg";
    private final int gridLength = 7;
    private final int gridSize = 49;
    private final int[] grid = new int[gridSize];
    private int comCount = 0;

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + "  ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine != null && inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine != null ? inputLine.toLowerCase() : null;
    }

    public ArrayList<String> placeDotCom(int comSize) {
        ArrayList<String> alphaCells = new ArrayList<>();
        String[] alphaCoords = new String[comSize];
        String temp;
        int[] coords = new int[comSize];
        int attempts = 0;
        boolean success;
        int location;

        comCount++;
        int incr = (comCount % 2 == 1) ? gridLength : 1;

        do {
            location = (int) (Math.random() * gridSize);
            success = true;
            int x = 0;

            while (success && x < comSize) {
                if (grid[location] == 0) {
                    coords[x++] = location;
                    location += incr;

                    if (location >= gridSize || (x > 0 && location % gridLength == 0)) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        } while (!success && attempts++ < 200);

        int x = 0;
        int row, column;

        while (x < comSize) {
            grid[coords[x]] = 1;
            row = coords[x] / gridLength;
            column = coords[x] % gridLength;
            temp = String.valueOf(ALPHABET.charAt(column));
            alphaCoords[x] = temp.concat(Integer.toString(row));
            alphaCells.add(alphaCoords[x]);
            x++;
        }

        return alphaCells;
    }
}

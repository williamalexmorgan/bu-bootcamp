import java.io.*;
import java.util.ArrayList;


public class GradeAnalyzer {
    //global variable
    static int invalidLines = 0;
    //Using these two as instructed in
    //directions
    static int high = Integer.MIN_VALUE;
    static int low = Integer.MAX_VALUE;

    public static void main(String[] args) {

        //Named these files like this so I don't get confused
        //as to what should come in and out.
        String inputFile = args[0];
        String outputFile = "report.txt";

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Step 2: calculate statistics
        double average = calculateAverage(scores);

        // Step 3: write and print report
        writeReport(scores, average, high, low, outputFile);
    }


    //fxn 1) Returns a list of valid scores read from the file like mentioned in the directions
    public static ArrayList<Integer> readScores(String filename) {

        //array that needs to be returned with scores
        ArrayList<Integer> scores = new ArrayList<>();

        //reading file
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    //getting rid of spaces
                    String trimmedLine = line.trim();

                    // Check for blank lines or lines containing only spaces
                    //Skipping blank & spaces line as instructed in directions
                    if (trimmedLine.isEmpty()) {
                        invalidLines++;
                        continue;
                    }
                    //will throw an error on those with letters and will go to catch block
                    int score = Integer.parseInt(trimmedLine);

                    //Make sure score is between 0 and 100, thought I saw a score over
                    //100 in scores.txt file but was wrong. Still a good case though.
                    //Should not include this score in the total if invalid, continue to
                    //stop the rest of the logic after.
                    if (score < 0 || score > 100) {
                        System.out.println("Warning: Invalid score on line "+ lineNumber + ": " + line);
                        invalidLines++;
                        continue;
                    }

                    //adding 'valid' scores to array
                    scores.add(score);

                } catch (NumberFormatException e) {
                    //Catch block will throw most if not all errors at the Integer parse
                    // which indicates a bad line.
                    System.out.println("Warning: Invalid line " + lineNumber + ": " + line);
                    invalidLines++;
                }
            }

        } catch (IOException e) {
            //404 file most likely
            System.out.println("Error reading file: " + e.getMessage());
        }

        //returning arrayList
        return scores;
    }

    //fxn 2) Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {

        int total = 0;

        //returns 0 if list is empty
        if (scores.isEmpty()) {
            return 0.0;
        }

        //Calculating highest and lowest scores (Step 5)
        //doing this for the global variables
        high = scores.get(0);
        low = scores.get(0);

        for (int score : scores) {
            if (score > high) {
                high = score;
            }

            if (score < low) {
                low = score;
            }
        }
        
        //calculating total
        for (int score : scores) {
            total += score;
        }

        //calculate and return average
        return (double) total / scores.size();
    }

    //fxn 3) Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int fCount = 0;

        // Counting each grade band logic
        // with if, else if, else like instructed
        for (int score : scores) {

            if (score >= 90) {
                aCount++;
            } else if (score >= 80) {
                bCount++;
            } else if (score >= 70) {
                cCount++;
            } else if (score >= 60) {
                dCount++;
            } else {
                fCount++;
            }
        }

        String report;

        // Handle an empty file or a file with no valid scores
        if (scores.isEmpty()) {

            report =
                "Grade Analysis Report\n" +
                "=====================\n" +
                "No valid scores were found.\n";

        } else {

            report =
                "Grade Analysis Report\n" +
                "=====================\n" +
                "Total scores processed: " + scores.size() + "\n" +
                "Invalid lines skipped: " + String.valueOf(invalidLines) + "\n" +
                "\n" +
                String.format("Average Score: %.2f%n", avg) +
                "Highest Score: " + String.valueOf(high) + "\n" +
                "Lowest Score: " + String.valueOf(low) + "\n" +
                "\n" +
                "Grade Distribution\n" +
                "------------------\n" +
                "A (90-100): " + aCount + "\n" +
                "B (80-89):  " + bCount + "\n" +
                "C (70-79):  " + cCount + "\n" +
                "D (60-69):  " + dCount + "\n" +
                "F (below 60):   " + fCount + "\n";
        }

        // Print report to terminal
        System.out.println();
        System.out.println(report);

        // Write report to file
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {

            writer.print(report);

        } catch (IOException e) {
            System.out.println(
                "Error writing report: " + e.getMessage()
            );
        }
    }
}

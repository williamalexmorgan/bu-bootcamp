import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
 
public class FileWriterDemo {
    public static void main(String[] args) {
        String filename = "numbers.txt";
 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("1");
            writer.newLine();
            writer.write("2");
            writer.newLine();
            writer.write("3");
            writer.newLine();
            writer.write("4");
            writer.newLine();
            writer.write("5");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
}
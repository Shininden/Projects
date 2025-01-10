import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Summarizer
{
    public static void main(String[] args) 
    {
        String readPath = "c:\\temp\\source.csv";
        String writePath = "c:\\temp\\out\\summary.csv";

        try ( BufferedReader br = new BufferedReader( new FileReader(readPath) ) )
        {
            String line = br.readLine();

            while (line != null) 
            {
                String[] lineElements = line.split(",");
                
                String productName = lineElements[0];
                int amount = Integer.parseInt(lineElements[2]);
                double price = Double.parseDouble(lineElements[1]);

                String totalPrice = Double.toString(price * amount);

                try (BufferedWriter bw = new BufferedWriter( new FileWriter(writePath, true) ))
                {
                    String newLine = String.join(",", productName, totalPrice);
                    bw.write(newLine);
                    bw.newLine();
                } 
                catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }

                line = br.readLine();
            }
        } 
        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
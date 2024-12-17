package Projects.Converters;

import java.util.Scanner;

public class CaseConverter
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type a text: ");
        String text = sc.nextLine();
        int option = 0;

        do
        {
            System.out.println("\nWhat would you like to do?");

            System.out.println("1 - Phrase format (First letter in upper case)");
            System.out.println("2 - iNVERSE cASE");
            System.out.println("3 - all lower case");
            System.out.println("4 - ALL UPPER CASE");
            System.out.println("5 - Upper Case At The Beginning Of Every Word");
            System.out.println("6 - AlTeRnAtE cAsE");
            System.out.println("7 - Exit");

            option = sc.nextInt();

            switch (option)
            {
                case 1:
                    phraseFormat(text);
                break;

                case 2:
                    inverseCase(text);
                break;

                case 3:
                    lowerCase(text);
                break;

                case 4:
                    upperCase(text);
                break;

                case 5:
                    beginningUpperCase(text);
                break;

                case 6:
                    alternateCase(text);
                break;
            }
        }
        while (option != 7);


        sc.close();
    }

    static void phraseFormat(String text)
    {
        char[] txtCharArray = text.toCharArray(); //To navigate through the positions more easily
        char[] aux = new char[text.length()];


        for (int i = 0; i < txtCharArray.length; i++) 
        {
            if(  (i == 0)  ||  (txtCharArray[i] == ' ' && (txtCharArray[i-1] == '.' || txtCharArray[i-1] == '?' || txtCharArray[i-1] == '!'))  )
            {
                String temp = String.valueOf(txtCharArray[i]); //to get the first letter
                temp = temp.toUpperCase(); // upper casing it

                aux = temp.toCharArray();
                txtCharArray[i] = aux[0];
            }
        }

        System.out.println(txtCharArray);
    } 

    static void inverseCase(String text)
    {

    }

    static void lowerCase(String text){
        System.out.println(text.toLowerCase());   
    }

    static void upperCase(String text){
        System.out.println(text.toUpperCase());
    }

    static void beginningUpperCase(String text)
    {

    }

    static void alternateCase(String text)
    {

    }
}
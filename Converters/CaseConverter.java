package Projects.Converters;

import java.util.Scanner;

public class CaseConverter
{
    static char[] txtCharArray;
    static char[] aux;
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
        txtCharArray = text.toCharArray(); //To navigate through the positions more easily

        for (int i = 0; i < txtCharArray.length; i++) 
        {
            if(i == 0) {
                changeCaseLetter(text,i, 0, "upper");
            }

            if(txtCharArray[i] == ' ' && (txtCharArray[i-1] == '.' || txtCharArray[i-1] == '?' || txtCharArray[i-1] == '!')) {
                changeCaseLetter(text, i,1, "upper");
            }
            else if (txtCharArray[i] == ' ' && (txtCharArray[i-1] != '.' || txtCharArray[i-1] != '?' || txtCharArray[i-1] != '!')) {
                changeCaseLetter(text, i, 1, "lower");
            }
        }

        System.out.println(txtCharArray);
    }
    static void changeCaseLetter(String text, int cont, int increment, String answer)
    {
        String temp = String.valueOf(txtCharArray[cont + increment]); //to get the first letter

        if(answer.equalsIgnoreCase("upper")){
            temp = temp.toUpperCase(); // upper casing it
        }
        else if (answer.equalsIgnoreCase("lower")) {
            temp = temp.toLowerCase();
        }

        aux = temp.toCharArray();
        txtCharArray[cont + increment] = aux[0];
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
        txtCharArray = text.toCharArray();

        for (int i = 0; i < txtCharArray.length; i++)
        {
            if(i == 0) {
                changeCaseLetter(text,i, 0, "upper");
            }

            if(txtCharArray[i] == ' ') {
                changeCaseLetter(text, i,1, "upper");
            }
        }

        System.out.println(txtCharArray);
    }

    static void alternateCase(String text)
    {

    }
}
package Projects.Converter;

import java.util.Arrays;
import java.util.Scanner;

public class CaseConverter
{
    static char[] txtCharArray;
    static char[] originaltxtCharArray;
    static char[] aux;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Type a text: ");
        String text = sc.nextLine();
        txtCharArray = text.toCharArray();
        originaltxtCharArray = Arrays.copyOf(txtCharArray, txtCharArray.length);;
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
            System.out.println("7 - txeT esreveR");
            System.out.println("8 - Exit");

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

                case 7:
                    reverseText(text);
                break;
            }
        }
        while (option != 8);


        sc.close();
    }

    static void phraseFormat(String text)
    {
        for (int i = 0; i < txtCharArray.length; i++) 
        {
            if(i == 0) {
                changeCaseLetter(i, 0, "upper");
            }

            if(txtCharArray[i] == ' ' && (txtCharArray[i-1] == '.' || txtCharArray[i-1] == '?' || txtCharArray[i-1] == '!')) {
                changeCaseLetter(i,1, "upper");
            }
            else if (txtCharArray[i] == ' ' && (txtCharArray[i-1] != '.' || txtCharArray[i-1] != '?' || txtCharArray[i-1] != '!')) {
                changeCaseLetter(i, 1, "lower");
            }
        }

        System.out.println(txtCharArray);
        txtCharArray = Arrays.copyOf(originaltxtCharArray, originaltxtCharArray.length);
    }
    
    static void changeCaseLetter(int cont, int increment, String answer)
    {
        String temp = String.valueOf(txtCharArray[cont + increment]); //to get the first letter

        if(answer.equalsIgnoreCase("upper")){
            temp = temp.toUpperCase(); // upper casing it
        }
        else if (answer.equalsIgnoreCase("lower")) {
            temp = temp.toLowerCase();
        }

        txtCharArray[cont + increment] = temp.charAt(0);
    }

    static void inverseCase(String text)
    {
        for (int i = 0; i < txtCharArray.length; i++)
        {
            if(i == 0) {
                changeCaseLetter(i, 0, "lower");
            }
            else if(i == 1){
                changeCaseLetter(i, 0, "upper");
            }
            else
            {
                if (txtCharArray[i - 2] == '.' || txtCharArray[i - 2] == '?' || txtCharArray[i - 2] == '!') {
                    changeCaseLetter(i, 0, "lower");
                }
                else {
                    changeCaseLetter(i, 0, "upper");
                }
            }
        }
        System.out.println(txtCharArray);
        txtCharArray = Arrays.copyOf(originaltxtCharArray, originaltxtCharArray.length);
    }

    static void lowerCase(String text){
        System.out.println(text.toLowerCase());   
    }

    static void upperCase(String text){
        System.out.println(text.toUpperCase());
    }

    static void beginningUpperCase(String text)
    {
        for (int i = 0; i < txtCharArray.length; i++)
        {
            if(i == 0) {
                changeCaseLetter(i, 0, "upper");
            }

            if(txtCharArray[i] == ' ') {
                changeCaseLetter(i,1, "upper");
            }
        }

        System.out.println(txtCharArray);
        txtCharArray = Arrays.copyOf(originaltxtCharArray, originaltxtCharArray.length);
    }

    static void alternateCase(String text)
    {
        for (int i = 0; i < txtCharArray.length; i++)
        {
            if(i % 2 != 0) {
                changeCaseLetter(i, 0, "upper");
            }
        }

        System.out.println(txtCharArray);
        txtCharArray = Arrays.copyOf(originaltxtCharArray, originaltxtCharArray.length);
    }

    static void reverseText(String text)
    {
        char[] temp = new char[txtCharArray.length];

        for(int i = txtCharArray.length - 1; i >= 0; i--) {
            temp[txtCharArray.length - 1 - i] = txtCharArray[i];
        }

        System.out.println(temp);
    }
}
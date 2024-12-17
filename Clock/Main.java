package Projects.Clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        setTimer(sc);
        setAlarm(sc);

        sc.close();
    }

    static void setTimer(Scanner sc)
    {
        System.out.print("Quantos timers vc quer? ");
        int amountTimers = sc.nextInt();

        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < amountTimers; i++)
        {
            TimerController tempControl = new TimerController();
            threads.add(new Thread(tempControl));
        }

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
    }

    static void setAlarm(Scanner sc)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


        System.out.print("Digite a hora do alarme (HH:mm:ss): ");
        String dateTimeInput = "14/12/2024 " + sc.nextLine();
        LocalDateTime desiredTime = LocalDateTime.parse(dateTimeInput, formatter);


        if (desiredTime.isBefore(LocalDateTime.now())) {
            System.out.println("O horário escolhido já passou. Por favor, insira um horário futuro.");
        }
        else
        {
            while ( LocalDateTime.now().isBefore(desiredTime) )
            {
                System.out.println("Hora atual: " + LocalDateTime.now().format(formatter));

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Hora atual: " + LocalDateTime.now().format(formatter));
            System.out.println("\nO TEMPO ACABOU!!!!");
        }
    }
}
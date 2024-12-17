package Projects.Clock;

import java.util.Scanner;

public class TimerController implements Runnable
{
    private String nome;
    private int duration;

    public TimerController()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do timer: ");
        this.nome = sc.nextLine();

        System.out.print("Unidade de tempo? (horas, minutos ou segundos) ");
        String tempo = sc.nextLine();
        this.duration = 0;

        System.out.print("Quanto tempo? ");
        if(tempo.equalsIgnoreCase("horas")){
            this.duration = sc.nextInt() * 3600;
        }
        else if(tempo.equalsIgnoreCase("minutos")){
            this.duration = sc.nextInt() * 60;
        }
        else if(tempo.equalsIgnoreCase("segundos")){
            this.duration = sc.nextInt();
        }
        else{
            System.out.println("Unidade de tempo inválida");
        }
    }

    @Override
    public void run()
    {
        System.out.println("------------Executando o timer: " + this.nome +  " -----------");

        try
        {
            for (int i = this.duration; i > 0; i--)
            {
                System.out.println("Timer: " + this.nome + " -> " + i + " segundos\n");
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------- O timer " + this.nome + " terminou---------------\n");
    }
}
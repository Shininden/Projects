package Projects.Padaria.controller;
import Projects.Padaria.model.PadariaItens;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BancoDeDados
{
    ArrayList<String> linhasList;
    ArrayList<PadariaItens> itensList;

    public BancoDeDados()
    {
        this.linhasList = new ArrayList<>();
        readDataBase();

        this.itensList = new ArrayList<>();
        linesToItens(linhasList);
    }

    public void readDataBase()
    {
        try
        {
            InputStream is = new FileInputStream("paes.txt");
            InputStreamReader isr = new InputStreamReader(is);
            @SuppressWarnings("resource")
            BufferedReader br = new BufferedReader(isr);

            String linha = br.readLine();

            while (linha != null)
            {
                linhasList.add(linha);
                System.out.println(linha);
                linha = br.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void linesToItens(ArrayList<String> linhas)
    {
        String[] itensDescription = new String[3];


        for (int i = 0; i < linhas.size(); i++)
        {
            PadariaItens padariaItem = new PadariaItens();
            itensDescription = linhas.get(i).split(",");

            padariaItem.setName(itensDescription[0]);
            padariaItem.setPrice(Double.parseDouble(itensDescription[1]));
            padariaItem.setCode(Integer.parseInt(itensDescription[2]));
            itensList.add(padariaItem);
        }
    }

    public ArrayList<PadariaItens> getItensList() {
        return itensList;
    }
}
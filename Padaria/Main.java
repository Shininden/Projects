package Projects.Padaria;
import Projects.Padaria.controller.BancoDeDados;
import Projects.Padaria.model.PadariaItens;
import Projects.Padaria.model.Venda;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        BancoDeDados bd = new BancoDeDados();
        ArrayList<PadariaItens> products = bd.getItensList();

        Venda v = new Venda();
        v.addItem(products, 0);
        v.addItem(products, 1);
        v.addItem(products, 2);

        System.out.println();

        v.sumTotal();

    }
}
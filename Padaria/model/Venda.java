package Projects.Padaria.model;

import Projects.Padaria.controller.BancoDeDados;

import java.util.ArrayList;

public class Venda
{
    ArrayList<PadariaItens> breads;

    public Venda() {
        this.breads = new ArrayList<>();
    }

    public void addItem(PadariaItens padariaItens){
        breads.add(padariaItens);
    }

    public void addItem(ArrayList<PadariaItens> itens, int cod) {
        breads.add( itens.get(cod) );
    }

    public void removeItem(int cod)
    {
        String removedItem = " ";
        for (int i = 0; i < breads.size(); i++)
        {
            if(breads.get(i).getCode() == cod)
            {
                removedItem = breads.get(i).getName();
                breads.remove(i);
                i = breads.size();
            }
        }
        System.out.println("Item " + removedItem + " was removed");
    }

    public void sumTotal()
    {
        double total = 0;


        for (int i = 0; i < breads.size(); i++) {
            total += breads.get(i).getPrice();
        }

        System.out.println("The total to pay is: " + total);
    }
}
package Projects.Lanchonete;
import java.util.ArrayList;

public class Carrinho
{
    private ArrayList<Item> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void addItem(Item item)
    {
        if(item.validateCod())
        {
            itens.add(item);
            System.out.println(item.getName() + " was added");
        }
    }

    public void removeItem(int itemCod)
    {
        if(!itens.isEmpty())
        {
            for (int i = 0; i < itens.size(); i++)
            {
                if(itens.get(i).getItemCod().equals(itemCod))
                {
                    System.out.println(itens.get(i).getName() + " was removed from the shopping cart");
                    itens.remove(i);
                }
            }
        }
    }

    public void removeItem(String name)
    {
        if(!itens.isEmpty())
        {
            for (int i = 0; i < itens.size(); i++) {
                if (itens.get(i).getName().equals(name)) {
                    System.out.println(itens.get(i).getName() + " was removed from the shopping cart");
                    itens.remove(i);
                }
            }
        }
    }

    public void calculateTOTPrice()
    {
        if(!itens.isEmpty())
        {
            double totSum = 0;
            for (int i = 0; i < itens.size(); i++) {
                totSum += itens.get(i).getPrice();
            }

            System.out.printf("Total R$: %.2f ", totSum);
        }

    }
}

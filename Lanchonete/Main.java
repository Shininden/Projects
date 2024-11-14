package Projects.Lanchonete;

public class Main
{
    public static void main(String[] args)
    {
        Item item1 = new Item(13.99, "Suco", "145");
        Item item2 = new Item(59.99, "Bolo", "224");
        Item item3 = new Item(1.99, "Toalha", "3234");
        Item item4 = new Item(100.99, "Pao de Queijo", "40");

        Carrinho cart = new Carrinho();

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        cart.removeItem(1);
        cart.removeItem("Toalha");

        cart.calculateTOTPrice();


    }
}
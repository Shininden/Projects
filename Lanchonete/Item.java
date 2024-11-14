package Projects.Lanchonete;

public class Item
{
    private String name;
    private  double price;
    private String itemCod;

    public Item(double price, String name, String cod)
    {
        this.price = price;
        this.name = name;
        this.itemCod = cod;
    }

    public boolean validateCod()
    {
        char[] aux;
        aux = itemCod.toCharArray();
        if(aux.length < 3)
        {
            System.out.println("The code of " + "\""+ name + "\""+ " is invalid");
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemCod() {
        return itemCod;
    }

    public void setItemCod(String itemCod) {
        this.itemCod = itemCod;
    }

    public void present() {
        System.out.println("Name of the item: " + name + ", Code: " + itemCod + "Price: R$ " + price);
    }
}

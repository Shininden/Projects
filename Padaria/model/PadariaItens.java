package Projects.Padaria.model;

public class PadariaItens
{
    private String name;
    private double price;
    private int code;

    public PadariaItens(String name, double price, int code)
    {
        this.setName(name);
        this.setPrice(price);
        this.setCode(code);
    }

    public PadariaItens() {

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
package Domain.Model;


public class Items {
    private String name;
    private String type;
    private int amount;
    private String discription;


    public Items(String name, String type, int amount, String discription){
        setName(name);
        setType(type);
        setAmount(amount);
        setDiscription(discription);
    }

    public String getName(){return name;}
    public void setName(String name){this.name =name;}
    public String getType(){return type;}
    public void setType(String type){this.type =type;}
    public int getAmount(){return amount;}
    public void setAmount(int amount){this.amount =amount;}
    public String getDiscription(){return discription;}
    public void setDiscription(String discription){this.discription =discription;}



}

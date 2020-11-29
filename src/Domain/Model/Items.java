package Domain.Model;


public class Items {
    private String name;
    private String type;
    private int amount;
    private String discription;

    public  Items(){
    }


    public Items(String name, String type, int amount, String discription){
        setName(name);
        setType(type);
        setAmount(amount);
        setDiscription(discription);
    }

    public String getName(){return name;}

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("fill in a name!");
        }
        this.name =name;
    }


    public String getType(){return type;}

    public void setType(String type){
                if(type == null || type.isEmpty()){
        throw new IllegalArgumentException("fill in a type!");
    }
        this.type =type;
}
    public int getAmount(){return amount;}

    public void setAmount(int amount){
        if (amount <= 0 || amount > 100){
            throw new IllegalArgumentException("Amount has to be between 0 and 100");
        }
        this.amount = amount;
    }


    public String getDiscription(){return discription;}

    public void setDiscription(String discription){
                if(discription == null || discription.isEmpty()){
        throw new IllegalArgumentException("fill in a discription!");
    }
        this.discription =discription;
}

    public Boolean hasName(String name, String type){
        return name.equals(this.getName())&& type.equals(this.getType());
    }

    public Boolean hasAllValues(String name){
        return name.equals(this.getName());
    }



}

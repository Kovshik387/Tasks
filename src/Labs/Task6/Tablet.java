
package Labs.Task6;
public class Tablet{
    private final String name;
    private final Integer memory;
    private final Integer rating;
    private final Integer price;

    public Tablet(String name,int memory, int rating, int price){
        this.name = name;
        this.memory = memory;
        this.rating = Math.min(rating, 5);
        this.price = price;
    }

    public boolean isGood(int m, int r){
        return this.memory >= m && this.rating >= r;
    }

    public int getPrice(){
        return this.price;
    }

    public int getMemory(){
        return this.memory;
    }

    public int getRating(){
        return this.rating;
    }

    @Override
    public String toString(){
        return "Модель:\t" + this.name + " | Память:\t" + this.memory +"Гб" + " | Рейтинг:\t"
                + this.rating + " | Цена:\t" + this.price;
    }

}

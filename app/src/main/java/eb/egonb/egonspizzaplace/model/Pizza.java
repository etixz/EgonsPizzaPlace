package eb.egonb.egonspizzaplace.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pizza implements Serializable {

    public ArrayList pizzaTops;
    public String pizzaSize;

    public Pizza(){

    }

    public Pizza(ArrayList pizzaTops, String pizzaSize) {
        this.pizzaTops = pizzaTops;
        this.pizzaSize = pizzaSize;
    }

    public ArrayList getPizzaTops() {
        return pizzaTops;
    }

    public void setPizzaTops(ArrayList pizzaTops) {
        this.pizzaTops = pizzaTops;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    @Override
    public String toString() {
        return
                "pizzaSize = " + pizzaSize + " pizzaTops=" + pizzaTops +
                '}';
    }
}

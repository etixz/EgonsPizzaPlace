package eb.egonb.egonspizzaplace.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class PizzaViewModel extends ViewModel {

    private MutableLiveData<Object> sharedPizza;
    private Pizza pizza;

    public MutableLiveData<Object> getPizza(){
        if(sharedPizza == null){
            sharedPizza = new MutableLiveData<>();
            createPizza();
        }
        return sharedPizza;
    }

    private void createPizza(){
        pizza = new Pizza();
        pizza.setPizzaSize("");
        pizza.setPizzaTops(new ArrayList());
        sharedPizza.setValue(pizza);
    }






}

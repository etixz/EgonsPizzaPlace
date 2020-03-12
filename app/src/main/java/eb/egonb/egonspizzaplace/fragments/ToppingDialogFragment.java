package eb.egonb.egonspizzaplace.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Array;
import java.util.ArrayList;

import eb.egonb.egonspizzaplace.model.PizzaViewModel;

public class ToppingDialogFragment extends DialogFragment {

    private FragmentActivity myContext;
    String[] toppings = {"Pepperoni", "Shoarma", "Meatballs", "Ham", "Kebab", "Cheese", "Bacon"};
    boolean[] selectedToppings = new boolean[toppings.length];
    ArrayList<String> selectedItems = new ArrayList();

    private DialogInterface.OnMultiChoiceClickListener toppingsSelectListener = new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            if(isChecked){
            selectedItems.add(toppings[which]);
            selectedToppings[which] = true;
            } else if(selectedItems.contains(toppings[which])){
            selectedItems.remove(toppings[Integer.valueOf(which)]);
            /*selectedToppings[which] = false;*/
            }
        }
    };

    private DialogInterface.OnClickListener toppingsClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Log.d("TOPPINGS", "Selected toppings: " + selectedItems);
            PizzaViewModel model = new ViewModelProvider(myContext).get(PizzaViewModel.class);
            model.add
            SmallPizzaFragment.pizzaToOrder.setPizzaTops(selectedItems);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_dropdown_item_1line, selectedItems);
            SmallPizzaFragment.spiSelectedTops.setAdapter(adapter);
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder toppingsBuilder = new AlertDialog.Builder(getActivity());

        toppingsBuilder.setTitle("Choose your toppings:");
        toppingsBuilder.setMultiChoiceItems(toppings, selectedToppings, toppingsSelectListener);
        toppingsBuilder.setPositiveButton("Confirm", toppingsClickListener);
        toppingsBuilder.setNegativeButton(android.R.string.cancel, null);

        return toppingsBuilder.create();
    }
}

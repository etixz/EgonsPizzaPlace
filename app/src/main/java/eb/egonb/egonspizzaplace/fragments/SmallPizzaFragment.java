package eb.egonb.egonspizzaplace.fragments;


import android.os.Bundle;

import androidx.appcompat.widget.ButtonBarLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;

import eb.egonb.egonspizzaplace.R;
import eb.egonb.egonspizzaplace.model.Pizza;
import eb.egonb.egonspizzaplace.model.PizzaViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class SmallPizzaFragment extends Fragment {


    private View rootView;
    private ToppingDialogFragment tpf;
    static TextView selectedSize;
    static Spinner spiSelectedTops;


    private View.OnClickListener toppingsListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tpf.show(getParentFragmentManager(), "toppings");
        }
    };

    private View.OnClickListener sizeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new SizeDialogFragment().show(getParentFragmentManager(), "size");

        }
    };

    private View.OnClickListener pizzaSnackbarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (model.getPizzaSize() == null || pizzaToOrder.getPizzaTops() == null) {
                Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.smallPizza_container),
                        "Niet alle velden zijn ingevuld!", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackbar.show();
            }else{
                Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.smallPizza_container),
                        "Uw pizza zal bezorgd worden!" + pizzaToOrder.toString(), Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                snackbar.show();
            }
        }
    };

   /* public static Pizza pizzaToOrder;*/

    public SmallPizzaFragment() {
        // Required empty public constructor
    }

    public static SmallPizzaFragment newInstance(){
        return new SmallPizzaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_small_pizza, container, false);

        Button btnToppings = rootView.findViewById(R.id.btn_toppings);
        btnToppings.setOnClickListener(toppingsListener);

        Button btnSize = rootView.findViewById(R.id.btn_size);
        btnSize.setOnClickListener(sizeListener);

        FloatingActionButton fabPizzaOrder = rootView.findViewById(R.id.fab_ordered);
        fabPizzaOrder.setOnClickListener(pizzaSnackbarListener);


        selectedSize = rootView.findViewById(R.id.tv_selectedSizeShow);
        selectedSize.setText("Please choose size");

        spiSelectedTops = rootView.findViewById(R.id.spi_selectedTops);

        tpf = new ToppingDialogFragment();
        /*pizzaToOrder = new Pizza();*/

        PizzaViewModel model = new ViewModelProvider(this).get(PizzaViewModel.class);
        model.getPizza().observe(getViewLifecycleOwner(), new Observer<Pizza>() {

            @Override
            public void onChanged(Pizza pizza) {

            }
            return rootView;
    }
}

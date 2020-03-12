package eb.egonb.egonspizzaplace.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import eb.egonb.egonspizzaplace.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LargePizzaFragment extends Fragment {


    public LargePizzaFragment() {
        // Required empty public constructor
    }


    public static LargePizzaFragment newInstance(){
        return new LargePizzaFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_large_pizza, container, false);
    }

}

package eb.egonb.egonspizzaplace.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import eb.egonb.egonspizzaplace.model.PizzaViewModel;

public class SizeDialogFragment extends DialogFragment {

    private FragmentActivity myContext;
    String[] pizzaSizes = {"Small", "Medium", "Large"};

    private DialogInterface.OnClickListener sizeSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "You chose a " + pizzaSizes[which], Toast.LENGTH_SHORT).show();
            SmallPizzaFragment.pizzaToOrder.setPizzaSize(pizzaSizes[which]);
            SmallPizzaFragment.selectedSize.setText(SmallPizzaFragment.pizzaToOrder.getPizzaSize());
            PizzaViewModel model = new ViewModelProvider(myContext)
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder pizzaSizeBuilder = new AlertDialog.Builder(getActivity());

        pizzaSizeBuilder.setTitle("Choose your pizza size: ");
        pizzaSizeBuilder.setItems(pizzaSizes, sizeSelectListener);
        pizzaSizeBuilder.setNegativeButton(android.R.string.cancel, null);

        return pizzaSizeBuilder.create();
    }
}

package eb.egonb.egonspizzaplace.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import eb.egonb.egonspizzaplace.fragments.LargePizzaFragment;
import eb.egonb.egonspizzaplace.fragments.MediumPizzaFragment;
import eb.egonb.egonspizzaplace.fragments.SmallPizzaFragment;

public class TabPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments = {SmallPizzaFragment.newInstance(), MediumPizzaFragment.newInstance(), LargePizzaFragment.newInstance()};

    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0: return "Small";
            case 1: return "Medium";
            case 2: return "Large";
        }
        return "";
    }
}

package jsu.edu.mcis.cs408.lab04;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import jsu.edu.mcis.cs408.lab04.tabs.DistanceConverter;
import jsu.edu.mcis.cs408.lab04.tabs.TempConverter;
import jsu.edu.mcis.cs408.lab04.tabs.TipCalculator;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public static final int NUM_TABS = 3;
    public TabLayoutAdapter(Fragment fragment) { super(fragment); }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: {
                return new TempConverter();
            }
            case 1: {
                return new TipCalculator();
            }
            case 2: {
                return new DistanceConverter();
            }
            default: {
                return null;
            }
        }
    }
    @Override
    public int getItemCount() { return NUM_TABS; }
}

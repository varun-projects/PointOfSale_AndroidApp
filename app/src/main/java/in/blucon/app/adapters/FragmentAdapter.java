package in.blucon.app.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.blucon.app.R;
import in.blucon.app.fragments.PitchersFragment;
import in.blucon.app.fragments.CocktailsFragment;
import in.blucon.app.fragments.NonAlcoholicFragment;
import in.blucon.app.fragments.ShotsFragment;
import in.blucon.app.fragments.RegularsFragment;


public class FragmentAdapter extends FragmentStatePagerAdapter {


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: fragment = new ShotsFragment();
                break;
            case 1: fragment = new CocktailsFragment();
                break;
            case 2: fragment = new PitchersFragment();
                break;
            case 3: fragment = new RegularsFragment();
                break;
            case 4: fragment = new NonAlcoholicFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";

        switch (position) {
            case 0: title = "Shots";
                break;
            case 1: title = "CockTails";
                break;
            case 2: title = "Pitchers";
                break;
            case 3: title = "Regulars";
                break;
            case 4: title = "Non-Alcoholic";
                break;
        }

        return title;
    }
}



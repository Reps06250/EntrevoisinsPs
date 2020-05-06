package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     *
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        return NeighbourFragment.newInstance(position); // ajouter l'argument position qui va me servir d'identifiant
    }                                                   // pour créer un Tag par instance

    /**
     * get the number of pages
     *
     * @return
     */
    @Override
    public int getCount() {
        return 2;  //changer nombre de page à creer
    }
}
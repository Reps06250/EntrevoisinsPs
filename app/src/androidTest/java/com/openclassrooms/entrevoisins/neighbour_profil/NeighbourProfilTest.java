package com.openclassrooms.entrevoisins.neighbour_profil;


import android.content.Intent;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.NeighbourProfil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class NeighbourProfilTest {

    private NeighbourApiService ApiService = DI.getNewInstanceApiService();
    private NeighbourProfil mActivity;
    private static int position = 1;

    @Rule
    public ActivityTestRule<NeighbourProfil> mActivityRule =
            new ActivityTestRule(NeighbourProfil.class,false,false);

    @Before
    public void setUp() {
        mActivity = mActivityRule.getActivity();
    }

    @Test
    public void GoodNameInProfil() {
        String name = ApiService.getNeighbours().get(position).getName();
        Intent intent = new Intent();
        intent.putExtra("position", position);
        intent.putExtra("tag", 0);
        mActivityRule.launchActivity(intent);
        onView(ViewMatchers.withId(R.id.ppseudo)).check(matches(withText(name)));
    }
}

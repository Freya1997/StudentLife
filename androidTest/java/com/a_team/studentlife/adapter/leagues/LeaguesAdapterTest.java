package com.a_team.studentlife.adapter.leagues;

import android.support.test.rule.ActivityTestRule;

import com.a_team.studentlife.R;
import com.a_team.studentlife.card_view_filling.LeagueListElement;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class LeaguesAdapterTest {
    @Rule
    public LeagueListElement mLeagueList;
    private ActivityTestRule<LeagueListElement> mActivityRule;

    @Before
    public void setUp() throws Exception {
        ActivityTestRule  mActivityRule = new ActivityTestRule<>(
                LeagueListElement.class);

    }
    public ActivityTestRule<LeagueListElement> setmLeagueList(LeagueListElement mLeagueList) {
        this.mLeagueList = mLeagueList;
        return null;
    }




    //oy blin
    @Test
    public void addAllLeagues(LeagueListElement mnLeagueList) {
    this.mActivityRule = setmLeagueList(mnLeagueList);
    }

    @Test
    public void onCreateViewHolder() {
    }

    @Test
    public void onBindViewHolder() {
    }

    @Test
    public void getItemCount( ) throws Exception{
        onView(withId(R.id.leagueItem)).check(matches(withText(0))); // == 0
    }




}
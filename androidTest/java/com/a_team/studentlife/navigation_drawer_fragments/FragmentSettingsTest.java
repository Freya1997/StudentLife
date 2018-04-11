package com.a_team.studentlife.navigation_drawer_fragments;

import com.a_team.studentlife.R;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class FragmentSettingsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onCreateView() {
    }

    @Test
    public void onButtonPressed() {
        // locate the view with id "user_name" and type the text "John"
        onView(withId(R.id.activity_main)).perform(typeText("Настройки"));

// locate the view with id "next" and click on it
        onView(withId(R.id.action_settings)).perform(click());

// locate the view with id "greeting_message" and check its text is equal with "Hello John!"
        onView(withId(R.id.settings_menu)).check(matches(withText("Здесь будут настройки аккаунта")));
    }

    @Test
    public void onDetach() {
    }
}
package ru.kkuzmichev.simpleappforespresso;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.intent.Intents;
import static androidx.test.espresso.intent.Intents.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import static org.hamcrest.Matchers.allOf;

import android.content.Intent;


@RunWith(AndroidJUnit4.class)
public class IntentsTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testIntent() {
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getContext());
        ViewInteraction settingsItem = onView(withText("Settings"));
        Intents.init();
        settingsItem.perform(click());
        intended(allOf(
                hasData("https://google.com"),
                hasAction(Intent.ACTION_VIEW)
        ));
        Intents.release();
    }
}

package ru.kkuzmichev.simpleappforespresso;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import androidx.test.rule.ActivityTestRule;
import androidx.test.espresso.ViewInteraction;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)
public class EspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void checkText() {
        ViewInteraction mainText = onView(
            withId(R.id.text_home)
        );
        mainText.check(matches(
            withText("This is home fragment")
        ));
    }
}

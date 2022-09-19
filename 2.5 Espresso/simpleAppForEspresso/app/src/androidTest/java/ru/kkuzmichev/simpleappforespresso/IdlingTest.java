package ru.kkuzmichev.simpleappforespresso;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4.class)
public class IdlingTest {
    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void regIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void testIdling() {
        onView(withContentDescription("Open navigation drawer")).perform(click());
        ViewInteraction galleryItem = onView(withText("Gallery"));
        galleryItem.perform(click());
        ViewInteraction list = onView(withId(R.id.recycle_view));
        list.perform(swipeDown());
        ViewInteraction item = onView(allOf(
                withId(R.id.item_number),
                withText("7")
        ));
        item.check(matches(isDisplayed()));

    }
}

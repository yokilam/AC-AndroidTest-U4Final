package nyc.c4q.androidtest_unit4final;

import android.graphics.Color;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasTextColor;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by justiceo on 1/8/18.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void activityLoads() {
        onView(withText("AndroidTest-Unit4Final")).check(matches(isDisplayed()));
    }

    @Test
    public void textsAreDisplayed() {
        onView(withText("blue")).check(matches(isDisplayed()));
        onView(withText("black")).check(matches(isDisplayed()));
    }

    @Test
    public void textsAreColored() {
        onView(withText("blue")).check(matches(hasTextColor(Color.parseColor("#0000ff"))));
        onView(withText("purple")).check(matches(hasTextColor(Color.parseColor("#800080"))));
    }

    @Test
    public void remoteDataIsLoaded() {
        onView(withText("aliceblue")).check(matches(isDisplayed()));
    }
}

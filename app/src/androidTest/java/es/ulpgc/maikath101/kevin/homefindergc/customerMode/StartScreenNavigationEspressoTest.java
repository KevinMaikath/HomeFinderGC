package es.ulpgc.maikath101.kevin.homefindergc.customerMode;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.maikath101.kevin.homefindergc.R;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartActivity;
import es.ulpgc.maikath101.kevin.homefindergc.customerMode.startScreen.StartScreen;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class StartScreenNavigationEspressoTest {

  @Rule
  public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);

  @Rule
  public GrantPermissionRule mGrantPermissionRule =
          GrantPermissionRule.grant(
                  "android.permission.READ_EXTERNAL_STORAGE");

  @Test
  public void startScreenNavigationEspressoTest() {
    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction floatingActionButton = onView(
            allOf(withId(R.id.floatingOptionsButton),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.drawer_layout),
                                    0),
                            0),
                    isDisplayed()));
    floatingActionButton.perform(click());

    ViewInteraction navigationMenuItemView = onView(
            allOf(childAtPosition(
                    allOf(withId(R.id.design_navigation_view),
                            childAtPosition(
                                    withId(R.id.navigation_view),
                                    0)),
                    2),
                    isDisplayed()));
    navigationMenuItemView.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction floatingActionButton2 = onView(
            allOf(withId(R.id.floatingOptionsButton),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.drawer_layout),
                                    0),
                            0),
                    isDisplayed()));
    floatingActionButton2.perform(click());

    ViewInteraction navigationMenuItemView2 = onView(
            allOf(childAtPosition(
                    allOf(withId(R.id.design_navigation_view),
                            childAtPosition(
                                    withId(R.id.navigation_view),
                                    0)),
                    3),
                    isDisplayed()));
    navigationMenuItemView2.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction floatingActionButton3 = onView(
            allOf(withId(R.id.floatingOptionsButton),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.drawer_layout),
                                    0),
                            0),
                    isDisplayed()));
    floatingActionButton3.perform(click());

    ViewInteraction navigationMenuItemView3 = onView(
            allOf(childAtPosition(
                    allOf(withId(R.id.design_navigation_view),
                            childAtPosition(
                                    withId(R.id.navigation_view),
                                    0)),
                    4),
                    isDisplayed()));
    navigationMenuItemView3.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction floatingActionButton4 = onView(
            allOf(withId(R.id.floatingOptionsButton),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.drawer_layout),
                                    0),
                            0),
                    isDisplayed()));
    floatingActionButton4.perform(click());

    ViewInteraction navigationMenuItemView4 = onView(
            allOf(childAtPosition(
                    allOf(withId(R.id.design_navigation_view),
                            childAtPosition(
                                    withId(R.id.navigation_view),
                                    0)),
                    5),
                    isDisplayed()));
    navigationMenuItemView4.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction floatingActionButton5 = onView(
            allOf(withId(R.id.floatingOptionsButton),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.drawer_layout),
                                    0),
                            0),
                    isDisplayed()));
    floatingActionButton5.perform(click());

    ViewInteraction navigationMenuItemView5 = onView(
            allOf(childAtPosition(
                    allOf(withId(R.id.design_navigation_view),
                            childAtPosition(
                                    withId(R.id.navigation_view),
                                    0)),
                    6),
                    isDisplayed()));
    navigationMenuItemView5.perform(click());
  }

  private static Matcher<View> childAtPosition(
          final Matcher<View> parentMatcher, final int position) {

    return new TypeSafeMatcher<View>() {
      @Override
      public void describeTo(Description description) {
        description.appendText("Child at position " + position + " in parent ");
        parentMatcher.describeTo(description);
      }

      @Override
      public boolean matchesSafely(View view) {
        ViewParent parent = view.getParent();
        return parent instanceof ViewGroup && parentMatcher.matches(parent)
                && view.equals(((ViewGroup) parent).getChildAt(position));
      }
    };
  }
}

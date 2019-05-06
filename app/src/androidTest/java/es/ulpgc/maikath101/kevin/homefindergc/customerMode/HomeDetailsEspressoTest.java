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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class HomeDetailsEspressoTest {

  @Rule
  public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);

  @Rule
  public GrantPermissionRule mGrantPermissionRule =
          GrantPermissionRule.grant(
                  "android.permission.READ_EXTERNAL_STORAGE");

  @Test
  public void homeDetailsEspressoTest() {

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

    ViewInteraction recyclerView = onView(
            allOf(withId(R.id.recyclerView),
                    childAtPosition(
                            withId(R.id.linearLayout),
                            1)));
    recyclerView.perform(actionOnItemAtPosition(1, click()));

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction recyclerView2 = onView(
            allOf(withId(R.id.image_list),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")),
                            2)));
    recyclerView2.perform(actionOnItemAtPosition(1, click()));

    ViewInteraction recyclerView3 = onView(
            allOf(withId(R.id.image_list),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")),
                            2)));
    recyclerView3.perform(actionOnItemAtPosition(2, click()));

    ViewInteraction recyclerView4 = onView(
            allOf(withId(R.id.image_list),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")),
                            2)));
    recyclerView4.perform(actionOnItemAtPosition(3, click()));

    ViewInteraction recyclerView5 = onView(
            allOf(withId(R.id.image_list),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")),
                            2)));
    recyclerView5.perform(actionOnItemAtPosition(4, click()));

    ViewInteraction appCompatButton = onView(
            allOf(withId(R.id.button_description), withText("Descripción"),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")),
                                    3),
                            1)));
    appCompatButton.perform(scrollTo(), click());

    ViewInteraction appCompatButton2 = onView(
            allOf(withId(R.id.button_location), withText("Ubicación"),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")),
                                    3),
                            2)));
    appCompatButton2.perform(scrollTo(), click());

    ViewInteraction appCompatButton3 = onView(
            allOf(withId(R.id.button_distribution), withText("Distribución"),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")),
                                    3),
                            3)));
    appCompatButton3.perform(scrollTo(), click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    pressBack();

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

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

package es.ulpgc.maikath101.kevin.homefindergc.adminMode.login;


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

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

  @Rule
  public ActivityTestRule<LoginActivity> mActivityTestRule = new ActivityTestRule<>(LoginActivity.class);

  @Rule
  public GrantPermissionRule mGrantPermissionRule =
          GrantPermissionRule.grant(
                  "android.permission.READ_EXTERNAL_STORAGE");

  @Test
  public void loginActivityTest() {
    ViewInteraction appCompatEditText = onView(
            allOf(withId(R.id.userEditText2),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            11),
                    isDisplayed()));
    appCompatEditText.perform(replaceText("admin"), closeSoftKeyboard());

    ViewInteraction appCompatEditText2 = onView(
            allOf(withId(R.id.passwordEditText2),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            14),
                    isDisplayed()));
    appCompatEditText2.perform(replaceText("1234"), closeSoftKeyboard());

    ViewInteraction appCompatButton = onView(
            allOf(withId(R.id.signInButton2),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            16),
                    isDisplayed()));
    appCompatButton.perform(click());

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

    ViewInteraction appCompatButton2 = onView(
            allOf(withId(R.id.addHouseButton),
                    childAtPosition(
                            allOf(withId(R.id.linearLayoutCompat2),
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0)),
                            1),
                    isDisplayed()));
    appCompatButton2.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatEditText3 = onView(
            allOf(withId(R.id.nameEditText),
                    childAtPosition(
                            allOf(withId(R.id.apartment_name_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            0)),
                            1)));
    appCompatEditText3.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatEditText4 = onView(
            allOf(withId(R.id.locationEditText),
                    childAtPosition(
                            allOf(withId(R.id.location_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            1)),
                            1)));
    appCompatEditText4.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatEditText5 = onView(
            allOf(withId(R.id.priceEditText),
                    childAtPosition(
                            allOf(withId(R.id.price_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            2)),
                            1)));
    appCompatEditText5.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatEditText6 = onView(
            allOf(withId(R.id.desciptionEditText),
                    childAtPosition(
                            allOf(withId(R.id.description_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            3)),
                            1)));
    appCompatEditText6.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatImageButton = onView(
            allOf(withId(R.id.add_image_button),
                    childAtPosition(
                            allOf(withId(R.id.add_image_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            4)),
                            2)));
    appCompatImageButton.perform(scrollTo(), click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatImageButton2 = onView(
            allOf(withId(R.id.doneButton),
                    childAtPosition(
                            allOf(withId(R.id.actionBar),
                                    childAtPosition(
                                            withId(R.id.addHouseToolbar),
                                            0)),
                            2),
                    isDisplayed()));
    appCompatImageButton2.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton3 = onView(
            allOf(withId(R.id.removeHouseButton),
                    childAtPosition(
                            allOf(withId(R.id.linearLayoutCompat2),
                                    childAtPosition(
                                            withId(android.R.id.content),
                                            0)),
                            2),
                    isDisplayed()));
    appCompatButton3.perform(click());

    // Added a sleep statement to match the app's execution delay.
    // The recommended way to handle such scenarios is to use Espresso idling resources:
    // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
    try {
      Thread.sleep(700);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    ViewInteraction appCompatButton4 = onView(
            allOf(withId(R.id.removeHouse),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.removeHouseRecyclerView),
                                    0),
                            1),
                    isDisplayed()));
    appCompatButton4.perform(click());

    ViewInteraction appCompatButton5 = onView(
            allOf(withId(android.R.id.button1), withText("Sí"),
                    childAtPosition(
                            childAtPosition(
                                    withId(R.id.buttonPanel),
                                    0),
                            3)));
    appCompatButton5.perform(scrollTo(), click());
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

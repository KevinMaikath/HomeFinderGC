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
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SendEmailContactEspressoTest {

  @Rule
  public ActivityTestRule<StartActivity> mActivityTestRule = new ActivityTestRule<>(StartActivity.class);

  @Rule
  public GrantPermissionRule mGrantPermissionRule =
          GrantPermissionRule.grant(
                  "android.permission.READ_EXTERNAL_STORAGE");

  @Test
  public void sendEmailContactEspressoTest() {
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
                    6),
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

    ViewInteraction appCompatEditText = onView(
            allOf(withId(R.id.nameEditText),
                    childAtPosition(
                            allOf(withId(R.id.user_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            1)),
                            1)));
    appCompatEditText.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatEditText2 = onView(
            allOf(withId(R.id.telephoneEditText),
                    childAtPosition(
                            allOf(withId(R.id.telephone_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            2)),
                            1)));
    appCompatEditText2.perform(scrollTo(), replaceText("123"), closeSoftKeyboard());

    ViewInteraction appCompatEditText3 = onView(
            allOf(withId(R.id.countryEditText),
                    childAtPosition(
                            allOf(withId(R.id.country_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            3)),
                            1)));
    appCompatEditText3.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatEditText4 = onView(
            allOf(withId(R.id.zipcodeEditText),
                    childAtPosition(
                            allOf(withId(R.id.zipcode_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            4)),
                            1)));
    appCompatEditText4.perform(scrollTo(), replaceText("123"), closeSoftKeyboard());

    ViewInteraction appCompatEditText5 = onView(
            allOf(withId(R.id.addressEditText),
                    childAtPosition(
                            allOf(withId(R.id.address_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            5)),
                            1)));
    appCompatEditText5.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatEditText6 = onView(
            allOf(withId(R.id.emailEditText),
                    childAtPosition(
                            allOf(withId(R.id.email_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            6)),
                            1)));
    appCompatEditText6.perform(scrollTo(), replaceText("asd"), closeSoftKeyboard());

    ViewInteraction appCompatEditText7 = onView(
            allOf(withId(R.id.subjectEditText),
                    childAtPosition(
                            allOf(withId(R.id.subject_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            7)),
                            0)));
    appCompatEditText7.perform(scrollTo(), replaceText("Asun"), closeSoftKeyboard());

    ViewInteraction appCompatEditText8 = onView(
            allOf(withId(R.id.bodyemailEditText),
                    childAtPosition(
                            allOf(withId(R.id.bodyemail_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            8)),
                            0)));
    appCompatEditText8.perform(scrollTo(), replaceText("a"), closeSoftKeyboard());

    ViewInteraction appCompatImageButton = onView(
            allOf(withId(R.id.send_button),
                    childAtPosition(
                            allOf(withId(R.id.button_relative_layout),
                                    childAtPosition(
                                            withId(R.id.layout),
                                            9)),
                            0)));
    appCompatImageButton.perform(scrollTo(), click());
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

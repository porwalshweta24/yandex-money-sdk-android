package ru.yandex.money.android.test;

import android.test.suitebuilder.annotation.LargeTest;

import com.yandex.money.api.methods.params.PhoneParams;

import ru.yandex.money.android.PaymentArguments;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * @author Slava Yasevich (vyasevich@yamoney.ru)
 */
@LargeTest
public final class InvalidClientIdPaymentActivityTest extends PaymentActivityTest {

    @Override
    protected PaymentArguments createArguments() {
        return new PaymentArguments("invalid", PhoneParams.PATTERN_ID,
                localProperties.getPhoneParams().makeParams());
    }

    public void test() {
        onView(withId(R.id.ym_error_title))
                .check(matches(withText(R.string.ym_error_illegal_param_client_id_title)));
        onView(withId(R.id.ym_error_message))
                .check(matches(withText(R.string.ym_error_illegal_param_client_id)));
        onView(withId(R.id.ym_error_action))
                .check(matches(not(isDisplayed())));
    }
}
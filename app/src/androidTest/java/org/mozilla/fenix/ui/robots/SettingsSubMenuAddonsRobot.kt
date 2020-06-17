/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import org.hamcrest.CoreMatchers.allOf
import org.mozilla.fenix.R
import org.mozilla.fenix.helpers.TestHelper
import org.mozilla.fenix.helpers.TestHelper.scrollToElementByText
import org.mozilla.fenix.helpers.click
import org.mozilla.fenix.helpers.withBitmapDrawable

/**
 * Implementation of Robot Pattern for the settings Add-ons sub menu.
 */
class SettingsSubMenuAddonsRobot {

    class Transition {
        val mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())!!
        fun goBack(interact: SettingsRobot.() -> Unit): SettingsRobot.Transition {
            goBackButton().click()

            SettingsRobot().interact()
            return SettingsRobot.Transition()
        }
    }
}

private fun goBackButton() =
    onView(withContentDescription("Navigate up"))

fun addButtonClick(expectedText: String, index:Int) {
    scrollToElementByText(expectedText)

    onView(allOf(withParentIndex(index), withChild(withId(R.id.add_button)))).click()
    //onView(allOf(withText(expectedText), withChild(withId(R.id.add_button)))).click()
    //onView(allOf(withText(expectedText), withId(R.id.add_button))).click()
    //onView(allOf(withParentIndex(index), withChild(allOf(withContentDescription("Install Add-on"), withId(R.id.add_button))))).click()
    //onView(withId(R.id.add_button)).click()
}

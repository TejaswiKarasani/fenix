/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.ui.robots

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.mozilla.fenix.R
import org.mozilla.fenix.helpers.TestAssetHelper
import org.mozilla.fenix.helpers.click
import org.mozilla.fenix.helpers.ext.waitNotNull

/**
 * Implementation of Robot Pattern for the History three dot menu.
 */
class ThreeDotMenuHistoryItemRobot {

    fun verifyHistoryCopyButton() = assertHistoryCopyButton()

    fun verifyHistoryShareButton() = assertHistoryShareButton()

    fun verifyHistoryOpenInNewTabButton() = assertHistoryOpenInNewTabButton()

    fun verifyHistoryOpenInPrivateTabButton() = assertHistoryOpenInPrivateTabButton()

    fun verifyHistoryDeleteButton() = assertHistoryDeleteButton()

    fun verifyHistoryMenuItems() {
        verifyHistoryCopyButton()
        verifyHistoryShareButton()
        verifyHistoryOpenInNewTabButton()
        verifyHistoryOpenInPrivateTabButton()
        verifyHistoryDeleteButton()
    }

    class Transition {

        fun clickCopy(interact: HistoryRobot.() -> Unit): HistoryRobot.Transition {
            copyButton().click()
            HistoryRobot().interact()
            return HistoryRobot.Transition()
        }

        fun clickShare(interact: LibrarySubMenusMultipleSelectionToolbarRobot.() -> Unit):
            LibrarySubMenusMultipleSelectionToolbarRobot.Transition {

            shareButton().click()

            mDevice.waitNotNull(
                Until.findObject(
                    By.text("ALL ACTIONS")
                ), TestAssetHelper.waitingTime
            )

            LibrarySubMenusMultipleSelectionToolbarRobot().interact()
            return LibrarySubMenusMultipleSelectionToolbarRobot.Transition()
        }

        fun clickOpenInNormalTab(interact: BrowserRobot.() -> Unit): BrowserRobot.Transition {
            openInNewNormalTabButton().click()
            BrowserRobot().interact()
            return BrowserRobot.Transition()
        }

        fun clickOpenInPrivateTab(interact: BrowserRobot.() -> Unit): BrowserRobot.Transition {
            openInNewPrivateTabButton().click()
            BrowserRobot().interact()
            return BrowserRobot.Transition()
        }

        fun clickDelete(interact: HistoryRobot.() -> Unit): HistoryRobot.Transition {
            deleteButton().click()
            HistoryRobot().interact()
            return HistoryRobot.Transition()
        }
    }
}

private fun copyButton() = onView(withText(R.string.history_menu_copy_button))

private fun shareButton() = onView(withText(R.string.history_menu_share_button))

private fun openInNewNormalTabButton() =
    onView(withText(R.string.history_menu_open_in_new_tab_button))

private fun openInNewPrivateTabButton() =
    onView(withText(R.string.history_menu_open_in_private_tab_button))

private fun deleteButton() = onView(withText(R.string.history_delete_item))

private fun assertHistoryCopyButton() {
    copyButton()
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertHistoryShareButton() {
    shareButton()
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertHistoryOpenInNewTabButton() {
    openInNewNormalTabButton()
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertHistoryOpenInPrivateTabButton() {
    openInNewPrivateTabButton()
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

private fun assertHistoryDeleteButton() {
    deleteButton()
        .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
}

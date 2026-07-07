/*
 * Copyright (c) 2025 Element Creations Ltd.
 * Copyright 2023-2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.appearance

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import io.element.android.features.preferences.impl.R
import io.element.android.libraries.architecture.coverage.ExcludeFromCoverage
import io.element.android.libraries.designsystem.components.preferences.PreferencePage
import io.element.android.libraries.designsystem.components.preferences.PreferenceSwitch
import io.element.android.libraries.designsystem.preview.ElementPreviewDark
import io.element.android.libraries.designsystem.preview.ElementPreviewLight
import io.element.android.libraries.designsystem.preview.PreviewWithLargeHeight
import io.element.android.libraries.ui.strings.CommonStrings

@Composable
fun AppearanceSettingsView(
    state: AppearanceSettingsState,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PreferencePage(
        modifier = modifier,
        onBackClick = onBackClick,
        title = stringResource(id = CommonStrings.common_appearance),
    ) {
        PreferenceSwitch(
            title = stringResource(id = R.string.screen_appearance_swipe_to_reply_direction),
            isChecked = state.isSwipeToReplyDirectionRight,
            onCheckedChange = {
                state.eventSink(AppearanceSettingsEvents.SetSwipeToReplyDirection(it))
            },
        )
    }
}

@PreviewWithLargeHeight
@Composable
internal fun AppearanceSettingsViewLightPreview(@PreviewParameter(AppearanceSettingsStateProvider::class) state: AppearanceSettingsState) =
    ElementPreviewLight { ContentToPreview(state) }

@PreviewWithLargeHeight
@Composable
internal fun AppearanceSettingsViewDarkPreview(@PreviewParameter(AppearanceSettingsStateProvider::class) state: AppearanceSettingsState) =
    ElementPreviewDark { ContentToPreview(state) }

@ExcludeFromCoverage
@Composable
private fun ContentToPreview(state: AppearanceSettingsState) {
    AppearanceSettingsView(
        state = state,
        onBackClick = {},
    )
}

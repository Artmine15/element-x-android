/*
 * Copyright (c) 2025 Element Creations Ltd.
 * Copyright 2023-2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.appearance

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

open class AppearanceSettingsStateProvider : PreviewParameterProvider<AppearanceSettingsState> {
    override val values: Sequence<AppearanceSettingsState>
        get() = sequenceOf(
            aAppearanceSettingsState(),
            aAppearanceSettingsState(isSwipeToReplyDirectionRight = false),
        )
}

fun aAppearanceSettingsState(
    isSwipeToReplyDirectionRight: Boolean = true,
    eventSink: (AppearanceSettingsEvents) -> Unit = {},
) = AppearanceSettingsState(
    isSwipeToReplyDirectionRight = isSwipeToReplyDirectionRight,
    eventSink = eventSink
)

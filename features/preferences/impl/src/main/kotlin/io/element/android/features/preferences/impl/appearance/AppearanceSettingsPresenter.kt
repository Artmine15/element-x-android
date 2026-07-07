/*
 * Copyright (c) 2025 Element Creations Ltd.
 * Copyright 2023-2025 New Vector Ltd.
 *
 * SPDX-License-Identifier: AGPL-3.0-only OR LicenseRef-Element-Commercial.
 * Please see LICENSE files in the repository root for full details.
 */

package io.element.android.features.preferences.impl.appearance

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import dev.zacsweers.metro.Inject
import io.element.android.libraries.architecture.Presenter
import io.element.android.libraries.preferences.api.store.SessionPreferencesStore
import kotlinx.coroutines.launch

@Inject
class AppearanceSettingsPresenter(
    private val sessionPreferencesStore: SessionPreferencesStore,
) : Presenter<AppearanceSettingsState> {
    @Composable
    override fun present(): AppearanceSettingsState {
        val scope = rememberCoroutineScope()
        val isSwipeToReplyDirectionRight by remember {
            sessionPreferencesStore.isSwipeToReplyDirectionRight()
        }.collectAsState(initial = true)

        fun handleEvent(event: AppearanceSettingsEvents) {
            when (event) {
                is AppearanceSettingsEvents.SetSwipeToReplyDirection -> scope.launch {
                    sessionPreferencesStore.setSwipeToReplyDirection(event.enabled)
                }
            }
        }

        return AppearanceSettingsState(
            isSwipeToReplyDirectionRight = isSwipeToReplyDirectionRight,
            eventSink = ::handleEvent,
        )
    }
}

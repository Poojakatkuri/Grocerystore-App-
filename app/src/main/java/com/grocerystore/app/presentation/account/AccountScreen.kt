package com.grocerystore.app.presentation.account

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.grocerystore.app.presentation.account.widgets.AccountScreenView
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
    viewModel: AccountViewModel = hiltViewModel(),
    onSignInClick: (() -> Unit),
    onProfileSettingsClick: (() -> Unit),
    onNotificationSettingsClick: (() -> Unit),
    onOrderHistorySettingsClick: (() -> Unit),
    onMealPlanningClick: (() -> Unit),

    ) {
    val user = viewModel.user.collectAsState()

    AccountScreenView(
        modifier = modifier,
        user = user.value,
        onSignInClick = onSignInClick,
        onProfileSettingsClick = onProfileSettingsClick,
        onNotificationSettingsClick = onNotificationSettingsClick,
        onOrderHistorySettingsClick = onOrderHistorySettingsClick,
        onSignOutClick = { viewModel.signOut() },
        onMealPlanningClick = onMealPlanningClick
    )
}

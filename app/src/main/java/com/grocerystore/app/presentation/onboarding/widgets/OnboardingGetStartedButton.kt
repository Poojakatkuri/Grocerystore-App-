package com.grocerystore.app.presentation.onboarding.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import com.grocerystore.app.R
import com.grocerystore.app.presentation.core.widgets.PrimaryButton
import com.grocerystore.app.presentation.onboarding.OnboardingViewModel
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun OnboardingGetStartedButton(
    modifier: Modifier = Modifier,
    viewModel: OnboardingViewModel = hiltViewModel(),
    navigateToMainInitialScreen: () -> Unit
) {
    val enabled = viewModel.isSyncedSuccessful.collectAsState()
    PrimaryButton(
        modifier = modifier,
        onClick = navigateToMainInitialScreen,
        enabled = enabled.value,
    ) {
        Text(text = stringResource(id = R.string.get_started))
    }
}
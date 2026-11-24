package com.grocerystore.app.utilities

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showMessageSnackBar(message: String) {
    Snackbar.make(
        requireActivity().findViewById(android.R.id.content),
        message,
        Snackbar.LENGTH_LONG
    ).show()
}

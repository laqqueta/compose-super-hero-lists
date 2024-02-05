package com.pbi.superherolists.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
    @StringRes val nameRes: Int,
    @StringRes val descRes: Int,
    @DrawableRes val drawableRes: Int
)

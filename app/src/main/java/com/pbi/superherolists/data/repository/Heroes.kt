package com.pbi.superherolists.data.repository

import com.pbi.superherolists.R
import com.pbi.superherolists.model.Hero

object Heroes {
    val heroes = listOf(
        Hero(
            nameRes = R.string.hero1,
            descRes = R.string.description1,
            drawableRes = R.drawable.android_superhero1
        ),
        Hero(
            nameRes = R.string.hero2,
            descRes = R.string.description2,
            drawableRes = R.drawable.android_superhero2
        ),
        Hero(
            nameRes = R.string.hero3,
            descRes = R.string.description3,
            drawableRes = R.drawable.android_superhero3
        ),
        Hero(
            nameRes = R.string.hero4,
            descRes = R.string.description4,
            drawableRes = R.drawable.android_superhero4
        ),
        Hero(
            nameRes = R.string.hero5,
            descRes = R.string.description5,
            drawableRes = R.drawable.android_superhero5
        ),
        Hero(
            nameRes = R.string.hero6,
            descRes = R.string.description6,
            drawableRes = R.drawable.android_superhero6
        )
    )
}
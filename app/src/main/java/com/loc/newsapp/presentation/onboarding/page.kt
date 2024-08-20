package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title : String,
    val desc : String,
    @DrawableRes val image : Int
)

val pages = listOf(

    Page(title = "Your World, Updated",
        desc = "Stay informed with the latest news and events happening around you. " +
                "From local happenings to global headlines, we've got you covered.",
        image = R.drawable.onboarding1),
    Page(title = "Reliable and Fast", desc = "Get access to accurate and up-to-date news delivered right to your fingertips. " +
            "Enjoy a seamless and fast news reading experience.", image = R.drawable.onboarding2),
    Page(title = "Personalized News Feed", desc = "Experience a news feed tailored to your interests. " +
            "Choose the topics you care about and get the stories that matter to you.", image = R.drawable.onboarding3)
)

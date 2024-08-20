package com.loc.newsapp.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.presentation.onboarding.Dimensions.indicatorSize
import com.loc.newsapp.ui.theme.BlueGray
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun PageIndicator(
    modifier:Modifier,
    pageCount: Int,
    selectedPage: Int,
    selectedPageColor: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primary,
    unSelectedPageColor: androidx.compose.ui.graphics.Color = BlueGray
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageCount) {
            page -> Box(modifier= Modifier.size(indicatorSize)
                .clip(CircleShape).
            background(if(page == selectedPage) selectedPageColor else unSelectedPageColor,))
        }
    }
}
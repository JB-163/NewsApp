package com.loc.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.presentation.common.BackButton
import com.loc.newsapp.presentation.common.NextButton
import com.loc.newsapp.presentation.onboarding.Dimensions.pageIndicatorWidth
import com.loc.newsapp.presentation.onboarding.components.OnBoardingPage
import com.loc.newsapp.presentation.onboarding.components.PageIndicator
import com.loc.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {

    val pagerState = rememberPagerState(initialPage = 0) {
        pages.size
    }

    val buttonState by remember {
        derivedStateOf {
            when(pagerState.currentPage) {
                0 -> listOf("","Next")
                1 -> listOf("Back","Next")
                2 -> listOf("Back","Get Started")
                else -> listOf("","")
            }
        }
    }
    Column(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(state = pagerState) {
            index -> OnBoardingPage(page = pages[index])
        }
        Spacer(modifier = Modifier.height(Dimensions.mediumPadding8))

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimensions.mediumPadding2)
            .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            PageIndicator(modifier = Modifier.width(pageIndicatorWidth), pageCount = pages.size, selectedPage = pagerState.currentPage)

            Row(verticalAlignment = Alignment.CenterVertically) {
                val scope = rememberCoroutineScope()
                if(buttonState.first() == "Back"){
                    BackButton(text = buttonState.first(), onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    })
                }
                NextButton(text = buttonState.last(), onClick = {
                    if (pagerState.currentPage == 3) {
                        //TODO : NAVIGATE TO MAIN SCREEN
                    } else {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                })
            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    NewsAppTheme {
        OnBoardingScreen()
    }
}
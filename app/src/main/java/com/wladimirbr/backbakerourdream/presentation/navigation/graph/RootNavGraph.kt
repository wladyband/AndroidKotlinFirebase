package com.wladimirbr.backbakerourdream.presentation.navigation.graph


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.wladimirbr.backbakerourdream.presentation.navigation.Graph


@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.AUTH
    ) {
        AppNavGraph(navController = navController)
    }
}
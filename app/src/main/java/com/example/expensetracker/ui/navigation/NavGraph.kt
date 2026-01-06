package com.example.expensetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.data.AppDatabase
import com.example.expensetracker.ui.screens.AddExpenseScreen
import com.example.expensetracker.ui.screens.ExpenseListScreen

@Composable
fun NavGraph(database: AppDatabase) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list"){
        composable("list") {
            ExpenseListScreen(navController, database)
        }
        composable("add") {
            AddExpenseScreen(navController, database)

        }
    }
}
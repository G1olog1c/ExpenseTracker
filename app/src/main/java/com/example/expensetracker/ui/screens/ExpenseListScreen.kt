package com.example.expensetracker.ui.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.expensetracker.data.AppDatabase

@Composable
fun ExpenseListScreen(
    navController: NavController,
    database: AppDatabase
) {
    val expenses by database.expenseDao()
        .getAllExpenses()
        .collectAsState(initial = emptyList())

    val total = expenses.sumOf { it.amount }

    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Text(
            text = stringResource(R.string.total) + ": $total"
            fontSize = 20.sp
        )

        Spacer(Modifier.height(16.dp))

        expenses.forEach {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(it.title)
                Text("${it.amount}")
            }
        }

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("add")},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.add_expense))
        }
    }
}
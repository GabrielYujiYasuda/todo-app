package com.example.myapplication.features.feature_main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.features.feature_deleted_tasks.DeletedPage
import com.example.myapplication.features.feature_home.HomePage
import com.example.myapplication.features.feature_profile.ProfilePage
import com.example.myapplication.features.feature_task.domain.model.navigation.NavItem
import com.example.myapplication.features.feature_task.domain.use_case.TodoViewModel
import com.example.myapplication.features.feature_task.presentation.tasks.components.TodoListPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(viewModel: TodoViewModel) {
    val taskList by viewModel.taskList

    val navItemList = listOf(
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Todo", Icons.Default.List, taskList?.size ?: 0),
        NavItem("Deleted", Icons.Default.Delete, 0),
        NavItem("Profile", Icons.Default.Person, 0),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(modifier = Modifier
        .fillMaxSize(),

            bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed {index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if (navItem.badgeCount > 0) {
                                    Badge {
                                        Text(text = navItem.badgeCount.toString())
                                    }
                                }
                            }) {
                                Icon(imageVector = navItem.icon, contentDescription = "icon")
                            }
                        },
                        label = { Text(text=navItem.label) }
                    )
                }
            }
        }) { innerPadding ->
        PageContent(modifier = Modifier
            .padding(innerPadding), selectedIndex = selectedIndex, viewModel = viewModel)
    }
}

@Composable
fun PageContent(modifier: Modifier = Modifier, selectedIndex: Int, viewModel: TodoViewModel) {
    when(selectedIndex) {
        0 -> HomePage()
        1 -> TodoListPage(viewModel = viewModel)
        2 -> DeletedPage()
        3 -> ProfilePage()
    }
}

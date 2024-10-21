package com.example.myapplication.features.feature_task.presentation.tasks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.features.feature_task.domain.ports.TaskOutput
import com.example.myapplication.features.feature_task.domain.use_case.TodoViewModel
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListPage(viewModel: TodoViewModel) {
    val taskList by viewModel.taskList

    var inputText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {""
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier.weight(1f),
                value = inputText,
                onValueChange = { inputText = it })

            Button(onClick = { viewModel.addTask(inputText) }) {
                Text(text = "Add")
            }
        }

        taskList?.let {
            LazyColumn(
                modifier = Modifier.padding(bottom = 100.dp),
                content = {
                itemsIndexed(it) {index: Int, item: TaskOutput ->
                    TodoCard(item = item, onDelete = {
                        viewModel.deleteTodo(item.id)
                    })
                }
            })
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items registered",
            fontSize = 16.sp)
    }
}

@Composable
fun TodoCard(item: TaskOutput, onDelete : () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.name,
                fontSize = 20.sp,
                color = Color.White)

            Text(text = SimpleDateFormat(
                "HH:mm - dd/mm/yyyy",
                Locale.ENGLISH).format(item.date),
                fontSize = 15.sp,
                color = Color.LightGray
            )
        }
        IconButton(onClick = onDelete) {
            Icon(painter =  painterResource(
                    id = R.drawable.baseline_delete_24
            ),
                    contentDescription = "Delete button",
                    tint = Color.White)
        }
    }
}



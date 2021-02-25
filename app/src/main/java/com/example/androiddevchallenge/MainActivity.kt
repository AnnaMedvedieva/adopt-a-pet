/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.dogsList
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.purple700
import com.example.androiddevchallenge.ui.theme.typography

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 4.dp,
                title = { Text(text = "Puppy Adoption App") },
            )
        },
        content = {
            NavHost(navController, startDestination = "dogs") {
                composable("dogs") { MainScreen(navController) }
                composable("details/{id}") { navBackStackEntry ->
                    val dog =
                        dogsList.first { it.id == navBackStackEntry.arguments!!.getString("id")!! }
                    DetailsScreen(dog)
                }
            }
        }
    )
}

@Composable
fun MainScreen(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.padding(4.dp)) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(dogsList) { dog ->
                    ListItem(dog) {
                        navController.navigate("details/${dog.id}")
                    }
                }
            }
        }
    }
}

@Composable
fun ListItem(dog: Dog, onItemClick: (Dog) -> Unit) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(3.dp),
        modifier = Modifier
            .clickable { onItemClick(dog) }
            .height(100.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = dog.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .border(1.dp, Color.DarkGray, CircleShape)
                    .width(86.dp)
                    .height(86.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(text = dog.name, style = typography.body1)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(text = "Breed: ${dog.breed}", style = typography.body2)
                Text(text = "Age: ${dog.age}", style = typography.body2)
                Text(text = dog.gender, style = typography.body2)
            }
        }
    }
}

@Composable
fun DetailsScreen(dog: Dog) {
    Column() {
        Image(
            painter = painterResource(id = dog.image),
            contentDescription = null,
            modifier = Modifier
                .requiredHeight(320.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(24.dp)) {
            Text(text = dog.name, style = typography.body1)
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = "Breed: ${dog.breed}", style = typography.body2)
            Text(text = "Age: ${dog.age}", style = typography.body2)
            Text(text = dog.gender, style = typography.body2)
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "${dog.name} is a good looking dog who is well behaved. ${dog.name} loves to play ball and is very good at bringing it back and handing it to you. This little dog is good on the lead and travels well in the car. ${dog.name} has a good nature and a good temperament and would be suitable for anyone.",
                style = typography.body1
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(backgroundColor = purple700),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth(),
                content = {
                    Text(text = "Adopt Me", color = Color.White)
                }
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

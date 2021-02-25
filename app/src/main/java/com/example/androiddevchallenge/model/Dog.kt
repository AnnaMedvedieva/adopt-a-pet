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
package com.example.androiddevchallenge.model

import com.example.androiddevchallenge.R

data class Dog(
    val id: String,
    val name: String,
    val gender: String,
    val age: String,
    val image: Int,
    val breed: String
)

val dogsList = listOf(
    Dog("1", "Annie", "Female", "6 months", R.drawable.king_charles_spaniel, "King Charles Spaniel"),
    Dog("2", "Poppy", "Female", "3 months", R.drawable.maltipoo, "Maltipoo"),
    Dog("3", "Charlie", "Male", "9 months", R.drawable.unknown1, "Unknown"),
    Dog("4", "Oscar", "Male", "5 months", R.drawable.jack_russel, "Jack Russel Terrier"),
    Dog("5", "Max", "Male", "3 months", R.drawable.unknown2, "Unknown"),
    Dog("6", "Millie", "Female", "4 months", R.drawable.yorkshire_terrier, "Yorkshire Terrier"),
    Dog("7", "Teddy", "Male", "4 months", R.drawable.golden_retriever, "Golden Retriever"),
    Dog("8", "Oggy", "Male", "7 months", R.drawable.akita, "Akita"),
    Dog("9", "Bella", "Female", "3 months", R.drawable.unknown3, "Unknown"),
    Dog("10", "Milo", "Male", "4 months", R.drawable.unknown4, "Unknown"),
    Dog("11", "Alfie", "Male", "7 months", R.drawable.unknown5, "Unknown")
)

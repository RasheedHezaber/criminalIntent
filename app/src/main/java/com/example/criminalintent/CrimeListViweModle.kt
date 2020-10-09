package com.example.criminalintent

import androidx.lifecycle.ViewModel

class CrimeListViweModle: ViewModel() {
    val crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "crime #$i"
            crime.isSolved = i % 2 == 0

            crimes += crime
        }
    }
}
package com.meeweel.movieapp.data

import com.meeweel.movieapp.domain.Film

class FakeRepo {
    fun getList() = listOf(
        Film("w3r", "hkgfuty", "Title 1", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 2", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 3", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 4", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 5", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 6", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 7", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 8", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
        Film("w3r", "hkgfuty", "Title 9", "7.3/10", 2017, "Description text of this film", listOf("Comedy", "Drama"), listOf("Coddy", "Lora", "Emma")),
    )
}
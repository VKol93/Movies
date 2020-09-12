package com.vk.movies.test

import com.vk.movies.model.DirectorFilter
import com.vk.movies.model.DurationFilter
import com.vk.movies.model.FilterStorage
import com.vk.movies.model.GenreFilter

fun getTestFilterStorage(): FilterStorage {
    val filter1 = DurationFilter(90, 140)
    val filter2 = DirectorFilter("Cameron")
    val filter3 = GenreFilter("Action")
    val filterStorage = FilterStorage()
    filterStorage.addFilter(filter1)
    filterStorage.addFilter(filter2)
    filterStorage.addFilter(filter3)
    return filterStorage
}
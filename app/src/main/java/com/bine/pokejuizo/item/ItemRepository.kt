package com.bine.pokejuizo.item

import androidx.annotation.WorkerThread

class ItemRepository(private val itemDAO: ItemDAO) {

    val allItems = itemDAO.getAllItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun createItem(item: Item){
        itemDAO.addItem(item)
    }
}
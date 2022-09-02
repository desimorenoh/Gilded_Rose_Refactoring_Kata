package com.gildedrose

data class GildedRose(val items: List<Item>) {

    fun updateQuality(): List<Item> = items.map() {
        it.updateQuality()
    }
}
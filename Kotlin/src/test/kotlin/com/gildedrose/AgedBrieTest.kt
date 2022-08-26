package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

private const val AGED_BRIE = "Aged Brie"


class AgedBrieTest {

    @Test
    fun `aged brie increases in quality the older it gets`() {
        val items = listOf(Item(AGED_BRIE, 2, 0))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(1, app.items[0].sellIn)
        assertEquals(1, app.items[0].quality)
    }

    @Test
    fun `after the date of sale its quality increases 2 units per day`() {
        val items = listOf(Item(AGED_BRIE, 0, 2))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(-1, items[0].sellIn)
        assertEquals(4, items[0].quality)
    }

    @Test
    fun `the quality of the item is never greater than 50`() {
        val items = listOf(Item(AGED_BRIE, 10, 50))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(9, items[0].sellIn)
        assertEquals(50, items[0].quality)
    }
}
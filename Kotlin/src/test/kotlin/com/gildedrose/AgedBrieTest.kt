package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class AgedBrieTest {

    @Test
    fun `aged brie increases in quality the older it gets`() {
        val items = listOf(AgedBrie(2, 0))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()


        assertEquals(1, (updateQuality[0] as AgedBrie).sellIn)
        assertEquals(1, (updateQuality[0] as AgedBrie).quality)
    }

    @Test
    fun `after the date of sale its quality increases 2 units per day`() {
        val items = listOf(AgedBrie( 0, 2))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(-1, (updateQuality[0] as AgedBrie).sellIn)
        assertEquals(4, (updateQuality[0] as AgedBrie).quality)
    }

    @Test
    fun `the quality of the item is never greater than 50`() {
        val items = listOf(AgedBrie( 10, 50))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(9, (updateQuality[0] as AgedBrie).sellIn)
        assertEquals(50, (updateQuality[0] as AgedBrie).quality)
    }
}
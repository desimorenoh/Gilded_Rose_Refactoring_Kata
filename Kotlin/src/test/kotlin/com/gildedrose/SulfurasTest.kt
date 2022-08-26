package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test


private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
class SulfurasTest {

    @Test
    fun `the sale date never changes`() {
        val items = listOf(Item(SULFURAS, 0, 80))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, items[0].sellIn)
        assertEquals(80, items[0].quality)
    }
}
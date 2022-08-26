package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test


private const val CONJURED_ITEMS = "Conjured Mana Cake"

class ConjuredItemTests {

    @Test
    fun `Conjured items degrade in quality twice as fast as normal items`() {
        val items = listOf(Item(CONJURED_ITEMS, 3, 6))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(2,items[0].sellIn)
        assertEquals(4, items[0].quality)
    }
}

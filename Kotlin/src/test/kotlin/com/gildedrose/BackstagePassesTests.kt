package com.gildedrose

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

class BackstagePassesTests {

    @Test
    fun `if the concert is 10 days or less away, the quality is increased by 2 units`() {
        val items = listOf(Item(BACKSTAGE_PASSES, 10, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(9, items[0].sellIn)
        assertEquals(22, items[0].quality)
    }

    @Test
    fun `if the concert is 5 days or less away, the quality is increased by 3 units`() {
        val items = listOf(Item(BACKSTAGE_PASSES, 6, 10))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(5, items[0].sellIn)
        assertEquals(13, items[0].quality)
    }

    @Test
    fun `after the sale date, the quality drops to 0`() {
        val items = listOf(Item(BACKSTAGE_PASSES, 0, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(-1, items[0].sellIn)
        assertEquals(0, items[0].quality)
    }
}
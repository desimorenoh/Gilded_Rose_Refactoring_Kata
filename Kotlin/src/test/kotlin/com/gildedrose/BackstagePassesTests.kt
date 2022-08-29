package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BackstagePassesTests {

    @Test
    fun `if the concert is 10 days or less away, the quality is increased by 2 units`() {
        val items = listOf(BackstagePasses(10, 20))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(9, (updateQuality[0] as BackstagePasses).sellIn)
        assertEquals(22, (updateQuality[0] as BackstagePasses).quality)
    }

    @Test
    fun `if the concert is 5 days or less away, the quality is increased by 3 units`() {
        val items = listOf(BackstagePasses(6, 10))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(5, (updateQuality[0] as BackstagePasses).sellIn)
        assertEquals(13, (updateQuality[0] as BackstagePasses).quality)
    }

    @Test
    fun `after the sale date, the quality drops to 0`() {
        val items = listOf(BackstagePasses(0, 20))
        val app = GildedRose(items)

        val updateQuality: List<Item> = app.updateQuality()

        assertEquals(-1, (updateQuality[0] as BackstagePasses).sellIn)
        assertEquals(0, (updateQuality[0] as BackstagePasses).quality)
    }
}
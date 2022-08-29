package com.gildedrose


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ConjuredItemTests {

    @Test
    fun `Conjured items degrade in quality twice as fast as normal items`() {
        val items = listOf(Conjured(3, 6))
        val app = GildedRose(items)

       val updateQuality: List<Item> = app.updateQuality()

        assertEquals(2,(updateQuality[0] as Conjured).sellIn)
        assertEquals(4, (updateQuality[0] as Conjured).quality)
    }
}

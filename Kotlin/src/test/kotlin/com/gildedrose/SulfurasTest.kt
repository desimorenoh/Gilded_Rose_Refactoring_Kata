package com.gildedrose

import com.gildedrose.Sulfuras
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SulfurasTest {

    @Test
    fun `the sale date never changes`() {
        val items = (listOf(Sulfuras(0, 80)))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, items[0].sellIn)
        assertEquals(80, items[0].quality)
    }
}
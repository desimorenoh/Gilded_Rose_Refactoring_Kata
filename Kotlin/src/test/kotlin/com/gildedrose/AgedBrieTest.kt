package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class AgedBrieTest {

    @Test
    fun `aged brie increases in quality the older it gets`() {
        val agedBrie = AgedBrie(2, 0)

        val updateAgedBrie: AgedBrie = agedBrie.updateQuality()


        assertEquals(1, updateAgedBrie.sellIn)
        assertEquals(1, updateAgedBrie.quality)
    }

    @Test
    fun `after the date of sale its quality increases 2 units per day`() {
        val agedBrie = AgedBrie(0, 2)

        val updateAgedBrie: AgedBrie = agedBrie.updateQuality()

        assertEquals(-1, updateAgedBrie.sellIn)
        assertEquals(4, updateAgedBrie.quality)
    }

    @Test
    fun `the quality of the item is never greater than 50`() {
        val agedBrie = AgedBrie( 10, 50)

        val updateAgedBrie: AgedBrie = agedBrie.updateQuality()

        assertEquals(9, updateAgedBrie.sellIn)
        assertEquals(50, updateAgedBrie.quality)
    }
}

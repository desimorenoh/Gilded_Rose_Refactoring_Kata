package com.gildedrose


import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class ConjuredItemTests {

    @Test
    fun `Conjured items degrade in quality twice as fast as normal items`() {
        val conjured = Conjured(3, 6)

       val updateConjured = conjured.updateQuality()

        assertEquals(2,updateConjured.sellIn)
        assertEquals(4, updateConjured.quality)
    }
}

package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BackstagePassesTests {

    @Test
    fun `if the concert is 10 days or less away, the quality is increased by 2 units`() {
        val backstagePasses = BackstagePasses(10, 20)

        val updateBackstagePasses = backstagePasses.updateQuality()

        assertEquals(9, updateBackstagePasses.sellIn)
        assertEquals(22, updateBackstagePasses.quality)
    }

    @Test
    fun `if the concert is 5 days or less away, the quality is increased by 3 units`() {
        val backstagePasses = BackstagePasses(6, 10)

        val updateBackstagePasses = backstagePasses.updateQuality()

        assertEquals(5, updateBackstagePasses.sellIn)
        assertEquals(13, updateBackstagePasses.quality)
    }

    @Test
    fun `after the sale date, the quality drops to 0`() {
        val backstagePasses = BackstagePasses(0, 20)

        val updateBackstagePasses = backstagePasses.updateQuality()

        assertEquals(-1, updateBackstagePasses.sellIn)
        assertEquals(0, updateBackstagePasses.quality)
    }
}
package com.gildedrose

import com.gildedrose.Sulfuras
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SulfurasTest {

    @Test
    fun `the sale date never changes`() {
        val sulfuras = Sulfuras(0, 80)


        val updateSulfuras = sulfuras.updateQuality()

        assertEquals(0, updateSulfuras.sellIn)
        assertEquals(80, updateSulfuras.quality)
    }
}
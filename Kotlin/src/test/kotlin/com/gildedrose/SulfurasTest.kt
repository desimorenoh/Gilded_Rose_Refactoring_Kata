package com.gildedrose

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test


private const val SULFURAS = "Sulfuras, Hand of Ragnaros"
class SulfurasTest {

    @Test
    fun `the sale date never changes`() {
        val items = arrayOf(Item(SULFURAS, 0, 80))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn).isEqualTo(0)
        assertThat(items[0].quality).isEqualTo(80)
    }
}
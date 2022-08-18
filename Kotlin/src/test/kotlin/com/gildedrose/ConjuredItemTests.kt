package com.gildedrose


import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test


private const val CONJURED_ITEMS = "Conjured Mana Cake"

class ConjuredItemTests {

    @Test
    fun `Conjured items degrade in quality twice as fast as normal items`() {
        val items = arrayOf(Item(CONJURED_ITEMS, 3, 6))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(2))
        assertThat(items[0].quality, equalTo(4))
    }
}

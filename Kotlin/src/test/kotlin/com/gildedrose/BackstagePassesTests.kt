package com.gildedrose

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

private const val BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert"

class BackstagePassesTests {

    @Test
    fun `if the concert is 10 days or less away, the quality is increased by 2 units`() {
        val items = arrayOf(Item(BACKSTAGE_PASSES, 10, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(9))
        assertThat(items[0].quality, equalTo(22))
    }

    @Test
    fun `if the concert is 5 days or less away, the quality is increased by 3 units`() {
        val items = arrayOf(Item(BACKSTAGE_PASSES, 6, 10))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(5))
        assertThat(items[0].quality, equalTo(13))
    }

    @Test
    fun `after the sale date, the quality drops to 0`() {
        val items = arrayOf(Item(BACKSTAGE_PASSES, 0, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertThat(items[0].sellIn, equalTo(-1))
        assertThat(items[0].quality, equalTo(0))
    }
}
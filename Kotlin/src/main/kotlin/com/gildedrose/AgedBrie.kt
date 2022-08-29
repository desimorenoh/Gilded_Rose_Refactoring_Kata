package com.gildedrose

data class AgedBrie(val sellIn: Int, val quality: Int) : Item {

    override fun updateQuality(): AgedBrie {

        var newQuality = quality
        var newSellIn = sellIn

        if (newSellIn > 0) {
            newQuality += 1
        } else {
            newQuality += 2
        }
        newSellIn--
        if (newQuality > 50) {
            newQuality = 50
        }
        return AgedBrie(newSellIn, newQuality)
    }
}

package com.gildedrose

data class BackstagePasses(val sellIn: Int, val quality: Int) : Item {

    override fun updateQuality(): BackstagePasses {

        var newSellIn = sellIn
        var newQuality = quality

        newSellIn--
        if (newSellIn < 0) {
            newQuality = 0
        } else if (newSellIn < 6) {
            newQuality += 3
        } else if (newSellIn in 6..10) {
            newQuality += 2
        }
        return BackstagePasses(newSellIn, newQuality)
    }
}

package com.gildedrose

data class RegularItem(val name: String, val sellIn: Int, val quality: Int) : Item {

    override fun updateQuality(): RegularItem {

        var newQuality = quality
        var newSellIn = sellIn

        newSellIn--
        if (newSellIn < 0) {
            newQuality -= 1 * 2
        } else {
            newQuality -= 1
        }
        if (newQuality < 0) {
            newQuality = 0
        }
        return RegularItem(name, newSellIn, newQuality)
    }
}

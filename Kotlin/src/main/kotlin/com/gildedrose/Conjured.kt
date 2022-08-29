package com.gildedrose

data class Conjured(val sellIn: Int, val quality: Int) : Item {

    override fun updateQuality() : Conjured {

        var newSellIn = sellIn
        var newQuality = quality

        newSellIn--
        newQuality-=2

        return Conjured(newSellIn, newQuality)
    }
}

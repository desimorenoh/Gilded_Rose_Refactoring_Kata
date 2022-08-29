package com.gildedrose

data class Sulfuras(val sellIn: Int, val quality: Int) : Item {

    override fun updateQuality() = this
}
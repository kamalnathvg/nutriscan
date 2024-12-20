package com.mdev.openfoodfacts_client.data.remote.dto


import com.google.gson.annotations.SerializedName

data class NutriScoreDataDto(
    @SerializedName("energy")
    val energy: Double? = null,
    @SerializedName("energy_points")
    val energyPoints: Int? = null,
    @SerializedName("energy_value")
    val energyValue: Double? = null,
    @SerializedName("fiber")
    val fiber: Double? = null,
    @SerializedName("fiber_points")
    val fiberPoints: Int? = null,
    @SerializedName("fiber_value")
    val fiberValue: Double? = null,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils")
    val fruitsVegetablesNutsColzaWalnutOliveOils: Double? = null,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_points")
    val fruitsVegetablesNutsColzaWalnutOliveOilsPoints: Int? = null,
    @SerializedName("fruits_vegetables_nuts_colza_walnut_olive_oils_value")
    val fruitsVegetablesNutsColzaWalnutOliveOilsValue: Double? = null,
    @SerializedName("grade")
    val grade: String? = null,
    @SerializedName("is_beverage")
    val isBeverage: Int? = null,
    @SerializedName("is_cheese")
    val isCheese: Int? = null,
    @SerializedName("is_fat")
    val isFat: Int? = null,
    @SerializedName("is_water")
    val isWater: Int? = null,
    @SerializedName("negative_points")
    val negativePoints: Int? = null,
    @SerializedName("positive_points")
    val positivePoints: Int? = null,
    @SerializedName("proteins")
    val proteins: Double? = null,
    @SerializedName("proteins_points")
    val proteinsPoints: Int? = null,
    @SerializedName("proteins_value")
    val proteinsValue: Double? = null,
    @SerializedName("saturated_fat")
    val saturatedFat: Double? = null,
    @SerializedName("saturated_fat_points")
    val saturatedFatPoints: Int? = null,
    @SerializedName("saturated_fat_value")
    val saturatedFatValue: Double? = null,
    @SerializedName("score")
    val score: Int? = null,
    @SerializedName("sodium")
    val sodium: Double? = null,
    @SerializedName("sodium_points")
    val sodiumPoints: Int? = null,
    @SerializedName("sodium_value")
    val sodiumValue: Double? = null,
    @SerializedName("sugars")
    val sugars: Double? = null,
    @SerializedName("sugars_points")
    val sugarsPoints: Int? = null,
    @SerializedName("sugars_value")
    val sugarsValue: Double? = null
)
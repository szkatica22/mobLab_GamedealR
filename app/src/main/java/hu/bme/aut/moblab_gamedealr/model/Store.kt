package hu.bme.aut.moblab_gamedealr.model

data class Store (
    val storeID: String,
    val storeName: String,
    val isActive: Int,
    val images: List<Image>
)
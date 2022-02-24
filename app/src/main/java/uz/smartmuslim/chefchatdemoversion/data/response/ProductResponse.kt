package uz.smartmuslim.chefchatdemoversion.data.response

data class ProductResponse(
    var id: Int,
    var name: String,
    var image: String,
    var amount: String,
    var unit: String,
    var calorie: String,
    var fat: String,
    var protein: String,
    var carbs: String
)
package uz.smartmuslim.chefchatdemo.data.response

data class FoodResponse(
    val id: String,
    val name: String,
    val image: String,
    val video: String,
    val rating: String,
    val countComment: Int,
    val countBookmark: Int,
    val profileImage: String
)
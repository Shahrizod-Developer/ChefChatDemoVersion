package uz.smartmuslim.chefchatdemoversion.data.response

import uz.smartmuslim.chefchatdemoversion.data.other.Photo
import java.io.Serializable

data class FoodResponse(
    val id: String,
    val name: String,
    val image: String,
    val video: String,
    val rating: String,
    val countComment: Int,
    val countBookmark: Int,
    val profileImage: String,
//    val userName: String,
//    val time: String? = null,
//    val desc: String? = null,
//    val ingredientList: ArrayList<ListProduct>? = null,
//    val stepList: ArrayList<PreparationResponse>? = null,
//    val additionalPicturesList: ArrayList<Photo>? = null,
//    val commentList: ArrayList<CommentResponse>? = null
): Serializable
package uz.smartmuslim.chefchatdemoversion.data.other

import uz.smartmuslim.chefchatdemoversion.data.response.CategoryResponse
import uz.smartmuslim.chefchatdemoversion.data.response.ProductResponse
import uz.smartmuslim.chefchatdemoversion.data.response.PreparationResponse

object Category {
    var items = arrayListOf(
        CategoryResponse(1, "Hammasi"),
        CategoryResponse(2, "Salat"),
        CategoryResponse(3, "Pishiriqlar"),
        CategoryResponse(4, "Ichimliklar"),
        CategoryResponse(5, "Suyuq"),
        CategoryResponse(6, "Quyuq"),
    )
}

object Photos{
    var items = arrayListOf(
        Photo("https://i.ytimg.com/vi/ay9lLMGZjsg/mqdefault.jpg"),

        Photo("https://i.ytimg.com/vi/66rj1GmpmxQ/maxresdefault.jpg"),

        Photo("https://zira.uz/wp-content/uploads/2018/07/kovurma-lagman-14.jpg"),
    )
}


object Ingredients{
    var items = arrayListOf(
        ProductResponse(

            1,
            "Suv",
            "https://yukber.uz/image/cache/catalog/product/YK0365/YK0365_1-700x700.jpg",
            "1000",
            "ml",
            "1000",
            "150",
            "350",
            "70"

        ),
        ProductResponse(

            2,
            "Tuz",
            "https://img02.flagma.uz/photo/tuz-eng-arzon-narxda-o-zbekiston-tuz-1762911_big.jpg",
            "1000",
            "gr",
            "1000",
            "150",
            "350",
            "70"

        ),

    )
}

object Data {
    var items = arrayListOf(
        PreparationResponse(
            "Qadam 1",
            "Kastrulyaga suv solib, tuz sepamiz va qaynatishga qo'yamiz."
        ),
        PreparationResponse(
            "Qadam 2",
            "Qaynab chiqqanidan so'ng lapshani qaynab turgan sho'r suvga 1 daqiqaga solib, so'ngra suvini to'kib tashlaymiz."
        ),
        PreparationResponse(
            "Qadam 3",
            "Mol go'shti, qizil va yashil bulg'or qalampirilarini to'rtburchak shaklida to'g'raymiz."
        ),
        PreparationResponse(
            "Qadam 4",
            "Piyoz va sabzini yarim halqa shaklida to'g'raymiz."
        ),
        PreparationResponse(
            "Qadam 5",
            "Pomidorlarni mayda qilib to'g'raymiz."
        ),
        PreparationResponse(
            "Qadam 6",
            "Qozonga yog' solib, qizdiramiz."
        ),
        PreparationResponse(
            "Qadam 7",
            "Qizdirilgan yog'ga go'shtni solib, 15 daqiqa qovuramiz.\n" +
                    "\n" +
                    "Maslahat: agar go'sht qattiq bo'lsa, ozroq suv solib, qozon qopqog'ini yopgan holda pishirish kerak bo'ladi."
        ),
        PreparationResponse(
            "Qadam 8",
            "Go'shtga piyozni solib, 10-15 daqiqa qovuramiz."
        ),
        PreparationResponse(
            "Qadam 9",
            "So'ngra to'g'ralgan bulg'or qalampiri, sabzi, tuz va zira solamiz. Barchasini yumshagunicha qovurish kerak."
        ),
        PreparationResponse(
            "Qadam 10",
            "So'ngra pomidor solib, 7 daqiqa qovuramiz."
        ),
        PreparationResponse(
            "Qadam 11",
            "Qovurilayotgan massaga lapsha solib, yaxshilab aralashtiramiz va yana 10 daqiqa qovuramiz."
        ),
        PreparationResponse(
            "Qadam 12",
            "Idishga 2 ta tuxum chaqib, tuz sepib, sanchqi yordamida yaxshilab aralashtiramiz."
        ),
        PreparationResponse(
            "Qadam 13",
            "Tovaga o'simlik yog'ini solib, quymoq qilamiz."
        ),
        PreparationResponse(
            "Qadam 14",
            "Quymoqni mayda qilib, yoki somoncha shaklida to'g'raymiz."
        ),
    )
}



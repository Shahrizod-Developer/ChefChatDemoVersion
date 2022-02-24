package uz.smartmuslim.chefchatdemoversion.presentation.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.appbar.AppBarLayout
import uz.smartmuslim.chefchatdemoversion.R
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenArticleBinding
import uz.smartmuslim.chefchatdemoversion.databinding.ScreenBookmarkBinding
import uz.smartmuslim.chefchatdemoversion.presentation.utils.InfoClass


class ScreenArticle : Fragment(R.layout.screen_article) {

    private val binding by viewBinding(ScreenArticleBinding::bind)

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.text3.text =
            "Sabzi: homiladorlik paytida eng foydali sabzavot.  Sabzi me’da-ichak yo‘llari faoliyatini yaxshilaydi. Uning tarkibida katta miqdorda karotin, E, C vitaminlari, B, K va PP guruhiga mansub vitaminlar mavjud. Bu foydali moddalar bolaning a’zolari shakllanishiga yordam beradi. Bu sabzavot me’da yarasi, me’da osti bezi muammolari va me’da-ichak yo‘llari yallig‘lanishlari bo‘lgan ayollarga tavsiya qilinmaydi.\n" +
                    "\n" +
                    "Shirin bulg‘or qalampiri: shifobaxsh xususiyatlarga ega, shilliq qavatlar holatini yaxshilashga yordam beradi va tomirlarni mustahkamlaydi. Qalampir tarkibidagi foydali moddalar homilador ayolning suyaklarini mustahkamlaydi va bolaning suyaklari shakllanishiga yordam beradi. Bu sabzavot tarkibidagi C, E, PP va P vitaminlari teri holatini yaxshilaydi. Efir yog‘lari, oqsil va beta-karotin esa immunitetni oshiradi.\n" +
                    "\n" +
                    "Ismaloq: bu sabzavot homilador ayollarda bola tushish xavfini kamaytirishda, homiladorlik toksikozida va kamqonlikning oldini olishda yordam beruvchi foli kislotasi (A, B9 va E vitaminlari)ga juda boy.\n" +
                    "\n" +
                    "Pomidor: juda to‘yimli va kaloriyasi past bo‘lgan bu sabzavot tarkibida hujayralarni erkin radikallardan himoya qilishda yordam beruvchi va noyob hisoblanuvchi likopin moddasi mavjud.\n" +
                    "\n" +
                    "Banan: bu meva tarkibida kraxmallar soni ko‘pligi va kaloriyasi baland bo‘lishiga qaramasdan shifokorlar undan voz kechishni tavsiya qilishmaydi. Banan tarkibida homila uchun eng foydali elementlar mavjud, bular — rux va kaliy.\n" +
                    "\n" +
                    "Olma: bu meva me’da-ichak yo‘llari faoliyatini yaxshilashga yordam beradi, me’da suyuqligi ajralishini ko‘paytiradi, ko‘ngil aynishini yo‘qotadi. Olmada homila rivojlanishiga yordam beruvchi ko‘plab temir, marganets, magniy, fosfor va kaliy moddalari bor."

        binding.appBarLayout.addOnOffsetChangedListener(object : InfoClass() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when (state) {
                    State.COLLAPSED -> {
                        binding.titleArticle.visibility = View.INVISIBLE
                        binding.title.visibility = View.VISIBLE
                    }
                    State.IDLE -> {
                        binding.titleArticle.visibility = View.VISIBLE
                        binding.title.visibility = View.INVISIBLE
                    }
                    else -> {

                    }
                }
            }

        })

    }
}
package lorena.geometry.geometricalsigns

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import lorena.geometry.geometricalsigns.databinding.ItemLayoutBinding

class SignAdapter(private val context: Context, private val signList: List<SignModel>) :
    PagerAdapter() {

    override fun getCount(): Int {
        return signList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(context), container, false)
        val view = binding.root

        val model = signList[position]
        val imageSigns = model.signImage
        val titleSigns = model.signName
        val contentSigns = context.resources.getStringArray(model.signMeaning)

        val signContents = contentSigns.joinToString("\n\n")

        binding.imageView.setImageResource(imageSigns)
        binding.textView.text = titleSigns
        binding.textContent.text = signContents

        view.setOnClickListener {
            val infoText = "$titleSigns\n$signContents"
            Navigator.showInfo(context, infoText)
        }
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
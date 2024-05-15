package lorena.geometry.geometricalsigns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import lorena.geometry.geometricalsigns.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mySignList: ArrayList<SignModel>
    private lateinit var mySignAdapter: SignAdapter
    private var exit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadSignCard()

        binding.viewPager.setClipToPadding(false)
        val padding = resources.getDimensionPixelSize(R.dimen.viewpager_padding)
        binding.viewPager.setPadding(padding, 0, padding, 0)

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                var title = mySignList[position].signName

                val currentItem = position
                val previousItem = if (positionOffset > 0) position else position - 1

                val currentTitle = mySignList[currentItem].signName
                val previousTitle = if (previousItem >= 0) mySignList[previousItem].signName else ""
            }

            override fun onPageSelected(position: Int) {
            }
        })
    }

    private fun loadSignCard() {
        mySignList = ArrayList()

        mySignList.add(
            SignModel(
                R.drawable.angle,
                "Angle",
                R.array.angle
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.measuredangle,
                "Measured Angle",
                R.array.measured
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.sphericalangle,
                "Spherical Angle",
                R.array.spherical
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.rightangle,
                "Right Angle",
                R.array.right
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.deg,
                "Degree Sign",
                R.array.degrees
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.degree,
                "Degree",
                R.array.degree
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.prime,
                "Prime",
                R.array.primes
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.doubleprime,
                "Double Prime",
                R.array.doubleprime
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.line,
                "Line",
                R.array.line
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.linesegment,
                "Line Segment",
                R.array.linesegment
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.ray,
                "Ray",
                R.array.ray
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.arc,
                "Arc",
                R.array.arc
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.angle,
                "Angle",
                R.array.angle
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.perpendicula,
                "Perpendicular",
                R.array.perpendicular
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.parallel,
                "Parallel",
                R.array.parallel
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.congruentto,
                "Congruent To",
                R.array.congruentto
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.similarity,
                "Similarity",
                R.array.similarity
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.triangle,
                "Triangle",
                R.array.triangle
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.distance,
                "Distance",
                R.array.distance
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.piconstant,
                "Pi Constant",
                R.array.piconstant
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.gradians,
                "Radians",
                R.array.radians
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.radians2,
                "Radian Sign",
                R.array.rad
            )
        )
        mySignList.add(
            SignModel(
                R.drawable.gradianss,
                "Gradians",
                R.array.gradians
            )
        )

        mySignAdapter = SignAdapter(this, mySignList)
        binding.viewPager.adapter = mySignAdapter
    }

    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "PRESS AGAIN TO EXIT", Toast.LENGTH_SHORT).show()
        } else {
            super.onBackPressed()
            finishAffinity()
        }
    }
}
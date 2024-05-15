package lorena.geometry.geometricalsigns

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import lorena.geometry.geometricalsigns.databinding.SignLayoutBinding

class Navigator {
    companion object {
        fun showInfo(context: Context?, title: String) {
            val infoBinding = SignLayoutBinding.inflate(LayoutInflater.from(context))
            val builder = AlertDialog.Builder(context)
            val info = builder.setView(infoBinding.root).create()
            info.setCancelable(true)

            info.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            infoBinding.content.text = title
            infoBinding.closeDialog.setOnClickListener { info.dismiss() }
            info.show()
        }
    }
}
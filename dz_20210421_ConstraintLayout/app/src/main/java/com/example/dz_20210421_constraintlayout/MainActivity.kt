package com.example.dz_20210421_constraintlayout



import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ImageSpan
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.TextView.BufferType
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val imageView = findViewById<ShapeableImageView>(R.id.imageView)
        val radius = resources.getDimension(R.dimen.default_corner_radius)
        imageView.shapeAppearanceModel = imageView.shapeAppearanceModel
                .toBuilder()
                .setTopRightCorner(CornerFamily.ROUNDED, radius)
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .build()

        val textIAmASimpleMan = findViewById<View>(R.id.textIAmASimpleMan) as TextView
        val ssb = SpannableStringBuilder("I am a simple man who loves making photographs and spending time with my wife, daughters and son  .")
        val camera = BitmapFactory.decodeResource(resources, R.drawable.camera)
        ssb.setSpan(ImageSpan(camera), 97, 98, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        textIAmASimpleMan.setText(ssb, BufferType.SPANNABLE)



    }
}
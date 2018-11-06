package a170194a.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun validateForm(v: View) {
        if (etMovieName.text.toString() == "" || etMovieDescription.text.toString() == "") {
            if (etMovieName.text.toString() == "") {
                etMovieName.setError("This field cannot be empty")
            }

            if (etMovieDescription.text.toString() == "") {
                etMovieDescription.setError("This section cannot be empty")
            }
        }
    }

    fun showTextBox(v: View) {
        if (chkbxSuitable.isChecked) {
            llotherBoxes.visibility = View.INVISIBLE
        }
    }
}

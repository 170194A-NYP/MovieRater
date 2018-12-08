package a170194a.nyp.movierater

import a170194a.nyp.movierater.Movies.MovieEntries.number
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.ContactsContract
import android.support.v7.app.AppCompatActivity
import android.view.*
import android.widget.*
import kotlinx.android.synthetic.main.landing_page.*
import java.lang.Exception

class Landing_page_activity : AppCompatActivity() {

    lateinit var layout : LinearLayout
    lateinit var picture : ImageView
    lateinit var rlayout : RelativeLayout
    lateinit var title : TextView
    var viewId:Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)
    }

    override fun onResume() {
        super.onResume()
        try {
            landingPageLayout.removeAllViewsInLayout()
            val moviesdata = Movies.returnMovies()
            for (i in 0..moviesdata!!.size) {
                layout = LinearLayout(this)
                layout.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
                picture = ImageView(this)
                picture.setImageResource(R.drawable.image_resize2)
                picture.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                layout.addView(picture)
                rlayout = RelativeLayout(this)
                rlayout.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                title = TextView(this)
                title.text = moviesdata[i].movietitle
                title.layoutParams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                title.setGravity(Gravity.CENTER)
                title.setId(i)
                rlayout.addView(title)
                layout.addView(rlayout)
                landingPageLayout.addView(layout)

                registerForContextMenu(title)
            }
        } catch (e: Exception) {

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.landing_page_menu, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miLandingAdd) {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(1,1,1,"Edit")
        viewId = v?.getId()
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1) {
            val intent = Intent(this, Edit_page_activity::class.java)
            intent.putExtra("id", viewId)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}
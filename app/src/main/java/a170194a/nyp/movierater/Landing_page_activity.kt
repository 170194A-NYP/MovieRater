package a170194a.nyp.movierater

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.landing_page.*

class Landing_page_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)

        registerForContextMenu(tvNoMovieAdded)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == tvNoMovieAdded.id) {
            menu?.add(1,1,1,"Add")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {

        if(item?.itemId == 1) {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)
    }
}
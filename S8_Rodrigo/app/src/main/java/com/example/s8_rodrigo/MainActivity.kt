package com.example.s8_rodrigo

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var toolbar: Toolbar
    private lateinit var rol: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        rol = intent.getStringExtra("ROL") ?: "Alumno"

        val headerView = navView.getHeaderView(0)
        val roleTextView = headerView.findViewById<TextView>(R.id.header_role)
        roleTextView.text = "ROL: $rol"

        val menu = navView.menu
        menu.clear()
        if (rol == "Profesor") {
            navView.inflateMenu(R.menu.menu_profesor)
        } else {
            navView.inflateMenu(R.menu.menu_alumno)
        }

        navView.setNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_asistencia -> {
                    supportActionBar?.title = "Asistencia"
                    val fragment = RegistroFragment()
                    val bundle = Bundle()
                    bundle.putString("ROL", rol)
                    fragment.arguments = bundle
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content_frame, fragment)
                        .commit()
                }

                R.id.nav_registros -> {
                    supportActionBar?.title = "Lista de Registros"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content_frame, ListaFragment())
                        .commit()
                }

                R.id.nav_web -> {
                    supportActionBar?.title = "Sitio web"
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.content_frame, WebFragment())
                        .commit()
                }

                R.id.nav_logout -> {
                    val intent = Intent(this, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
            }

            drawerLayout.closeDrawers()
            true
        }
    }
}

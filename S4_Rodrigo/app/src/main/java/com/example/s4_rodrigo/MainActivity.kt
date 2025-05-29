package com.example.s4_rodrigo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val preguntas = listOf(
        Pregunta(
            "1. Se ejecuta en 2do plano y no posee una interfaz de usuario ¿Qué componente es?",
            listOf("Servicies", "Content Providers", "Broadcast Receivers", "Activities"),
            listOf(0)
        ),
        Pregunta(
            "2. ¿Qué método del ciclo de vida de una actividad te muestra la interfaz, pero no te deja interactuar con ella?",
            listOf("onStart()", "onPausa()", "onStop()", "onCreate()"),
            listOf(0)
        ),
        Pregunta(
            "3. ¿En qué carpeta ubicamos todos los archivos que les corresponde a las imágenes usadas para la aplicación?",
            listOf("res/layout", "res/font", "res/drawable", "res/mipmap"),
            listOf(2)
        ),
        Pregunta(
            "4. ¿En qué lenguaje es posible codificar la lógica en Android Studio?",
            listOf("java", "php", "python", "kotlin"),
            listOf(0, 3)
        ),
        Pregunta(
            "5. ¿En qué dirección podemos encontrar el diseño visual de las pantallas?",
            listOf("res/drawable", "res/layout", "res/font", "res/mipmap"),
            listOf(1)
        ),
        Pregunta(
            "6. ¿Cuál de todos estos componentes es parte de los componentes nativos?",
            listOf("recyclerView", "TextView", "Navigation Component", "ViewModel"),
            listOf(1)
        ),
        Pregunta(
            "7. ¿Qué arquitectura usan las aplicaciones moviles?",
            listOf("MVP", "MVC", "MVVM", "MVP-VP"),
            listOf(2)
        ),
        Pregunta(
            "8. Durante el ciclo de vida de una actividad, ¿en qué método se encuentra la actividad completamente inicializada y lista para mostrarse, pero aún no ha ganado el foco para interactuar?",
            listOf("onStart()", "onResume()", "onPause()", "onCreate()"),
            listOf(0)
        ),
        Pregunta(
            "9. ¿Qué tipo de Layout deberías evitar si necesitas rendimiento y una jerarquía visual eficiente para pantallas complejas con muchos elementos?",
            listOf("ConstraintLayout", "RelativeLayout", "LinearLayout anidados", "FrameLayout"),
            listOf(2)
        ),
        Pregunta(
            "10. ¿Cuál de los siguientes atributos es crucial para que un TextView o EditText conserve la consistencia de tamaño en pantallas con diferentes densidades?",
            listOf("padding en px", "layout_margin en mm", "textSize en sp", "layout_width en pt"),
            listOf(2)
        ),
        Pregunta(
            "11. Si necesitas organizar elementos que deben alinearse horizontalmente con distribución equitativa del espacio, ¿qué atributo es indispensable en un LinearLayout?",
            listOf("layout_gravity", "layout_alignParentStart", "layout_constraintHorizontal_chainStyle", "layout_weight"),
            listOf(3)
        ),
        Pregunta(
            "12. ¿Cuál de los siguientes componentes nativos tiene la capacidad de representar múltiples elementos visuales organizados jerárquicamente y puede actuar como contenedor de vistas?",
            listOf("TextView", "ViewGroup", "ImageView", "EditText"),
            listOf(1)
        ),
        Pregunta(
            "13. ¿Qué tipo de ViewGroup sería más adecuado si tu diseño requiere apilar elementos uno sobre otro (por ejemplo, un botón flotante sobre una imagen)?",
            listOf("RelativeLayout", "FrameLayout", "LinearLayout", "ConstraintLayout"),
            listOf(1)
        ),
        Pregunta(
            "14. ¿Qué carpeta se utiliza para definir las fuentes personalizadas de texto en una app Android?",
            listOf("res/font", "res/values", "res/assets/fonts", "res/drawable"),
            listOf(0)
        )
        )

    private var preguntaActual = 0
    private var puntos = 0
    private var opcionSeleccionada = false

    private lateinit var tvPuntos: TextView
    private lateinit var tvPregunta: TextView
    private lateinit var tvNumeroPregunta: TextView
    private lateinit var btnOpciones: List<Button>
    private lateinit var btnSiguiente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
        val userName = prefs.getString("USER_NAME", "Nombre")
        findViewById<TextView>(R.id.tvUserName).text = userName

        tvPuntos = findViewById(R.id.tvPuntos)
        tvPregunta = findViewById(R.id.questionText)
        tvNumeroPregunta = findViewById(R.id.tvQuestionNumber)
        btnSiguiente = findViewById(R.id.nextButton)

        btnOpciones = listOf(
            findViewById(R.id.option1),
            findViewById(R.id.option2),
            findViewById(R.id.option3),
            findViewById(R.id.option4)
        )

        cargarPregunta()

        btnOpciones.forEachIndexed { index, button ->
            button.setOnClickListener {
                if (!opcionSeleccionada) {
                    validarRespuesta(index)
                }
            }
        }

        btnSiguiente.setOnClickListener {
            if (preguntaActual < preguntas.size - 1) {
                preguntaActual++
                cargarPregunta()
            } else {
                Toast.makeText(this, "¡Quiz finalizado! Puntaje total: $puntos/${preguntas.size}", Toast.LENGTH_LONG).show()
                btnSiguiente.isEnabled = false
            }
        }
    }

    private fun cargarPregunta() {
        val pregunta = preguntas[preguntaActual]

        tvPregunta.text = pregunta.texto
        tvNumeroPregunta.text = (preguntaActual + 1).toString()
        opcionSeleccionada = false

        btnOpciones.forEachIndexed { i, btn ->
            btn.text = pregunta.opciones[i]
            btn.isEnabled = true
            btn.setBackgroundColor(Color.parseColor("#7691FB"))
        }

        tvPuntos.text = "Puntos: $puntos"
        btnSiguiente.isEnabled = false

        if (preguntaActual == preguntas.size - 1) {
            btnSiguiente.text = "Finalizar"
        } else {
            btnSiguiente.text = "Siguiente"
        }
    }


    private fun validarRespuesta(indiceSeleccionado: Int) {
        val pregunta = preguntas[preguntaActual]
        opcionSeleccionada = true

        if (indiceSeleccionado in pregunta.respuestasCorrectas) {
            puntos++
            btnOpciones[indiceSeleccionado].setBackgroundColor(Color.parseColor("#6FCF97"))
            Toast.makeText(this, "¡Correcto!", Toast.LENGTH_SHORT).show()
        } else {
            btnOpciones[indiceSeleccionado].setBackgroundColor(Color.RED)
            pregunta.respuestasCorrectas.forEach { correcta ->
                btnOpciones[correcta].setBackgroundColor(Color.parseColor("#6FCF97"))
            }
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }

        btnOpciones.forEach { it.isEnabled = false }
        tvPuntos.text = "Puntos: $puntos"
        btnSiguiente.isEnabled = true

        if (preguntaActual == preguntas.size - 1) {
            Toast.makeText(this, "¡Quiz finalizado! Puntaje total: $puntos/${preguntas.size}", Toast.LENGTH_LONG).show()
            btnSiguiente.isEnabled = false
        }
    }
}

package edu.itesm.A01653348.JuegoDado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    var tiros = 1
    var jugador1 = 0
    var jugador2 = 0
    var turno1 = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("edu.itesm.daec", "demostración de log")
        tira_dado()
    }
    fun tira_dado(){
        roll_dice.setOnClickListener {
            val rand = Random.nextInt(1, 6)
            if (turno1 && tiros <= 6){
                mensaje.text = "Jugador 1 tira $rand ,tiro # $tiros"
                tiros++
                mensaje2.text = "Tu turno, jugador 2"
                jugador1+= rand
                turno1 = false
                puntaje1.text = " Jugador 1  = $jugador1"
            }else if(tiros <= 6){
                mensaje.text = "Jugador 2 tira $rand ,tiro # $tiros"
                tiros++
                jugador2+= rand
                if(tiros == 7){
                    if(jugador1<jugador2){
                        mensaje2.text = "Jugador 2 gana"
                    }else if(jugador1>jugador2){
                        mensaje2.text = "Jugador 1 gana"
                    }else{
                        mensaje2.text = "Empate"
                    }
                    roll_dice.text = "Nuevo juego"
                }else {
                    mensaje2.text = "Tu turno, jugador 1"
                }

                puntaje2.text = "Jugador 2 = $jugador2"
                turno1 = true
            }else{
                roll_dice.text = "Tiro"
                jugador1 = 0
                jugador2 = 0
                tiros = 1
                mensaje.text = "------"
                mensaje2.text = "Tu turno, jugador 1"
                turno1 = true
                puntaje1.text = "Jugador 1 = 0"
                puntaje2.text = "Jugador 2 = 0"

            }


        }
    }
}
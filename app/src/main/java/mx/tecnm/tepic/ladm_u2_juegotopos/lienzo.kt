package mx.tecnm.tepic.ladm_u2_juegotopos

import android.content.res.Resources
import android.graphics.*
import android.provider.Settings
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Semaphore
import kotlin.random.Random
import kotlin.coroutines.*

class lienzo(activity:MainActivity):View(activity) {
    var base = imagen(this,600f,100f,R.drawable.base)
    var base2 = imagen(this,1100f,100f,R.drawable.base)
    var base3 = imagen(this,50f,500f,R.drawable.base)
    var base4 = imagen(this,450f,500f,R.drawable.base)
    var base5 = imagen(this,850f,500f,R.drawable.base)
    var base6 = imagen(this,1250f,500f,R.drawable.base)
    var base7 = imagen(this,1650f,500f,R.drawable.base)
    var topo = imagen(this,600f,-20f,R.drawable.dig)
    var topog = imagen(this,600f,-20f,R.drawable.hit)
    //var semaphore= Semaphore(5)
    var contador=0
    var bandera=false
    var hilo=hilo(this)
    var random=0

    var puntos=0
    var nivel=0
    var tiempo=30

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint= Paint()

        canvas.drawColor(ContextCompat.getColor(context, R.color.sky))
        paint.color= ContextCompat.getColor(context,R.color.mountain)
        canvas.drawArc(RectF(-150f, 200f, 2300f, 1450f), 180f, 180f, true, paint)

        paint.color= Color.BLACK
        paint.style=Paint.Style.FILL
        paint.textSize=50f
        canvas.drawText("Nivel:"+nivel,50f,50f,paint)
        canvas.drawText("Puntos: "+puntos,50f,100f,paint)
        canvas.drawText("Tiempo:"+tiempo,50f,150f,paint)

        //Dibujar Hoyos
        base.pintarImagen(canvas)
        base2.pintarImagen(canvas)
        base3.pintarImagen(canvas)
        base4.pintarImagen(canvas)
        base5.pintarImagen(canvas)
        base6.pintarImagen(canvas)
        base7.pintarImagen(canvas)

        dibujarTopo(canvas,random)
            try {
                hilo.start()
            }catch (e:IllegalThreadStateException){}

        if(puntos==10){
            nivel=1
        }
        if(puntos==15){
            nivel=2
        }

    }

    //Verifica si se ha tocado el topo
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action){
            MotionEvent.ACTION_DOWN->{
                if(topo.tocarImagen(event.x,event.y)){
                    bandera=true
                    invalidate()
                }
            }
        }
        return true
    }

    //Determina que topo se pintará en pantalla
    private fun dibujarTopo(canvas:Canvas,pos:Int){
        when(pos){
            0->{
                if(bandera){
                    topog.posX=600f
                    topog.posY=-20f
                    topog.pintarImagen(canvas)
                    bandera=false
                    puntos++
                }else{
                topo.posX=600f
                topo.posY=-20f
                    topo.pintarImagen(canvas)
                }
            }
            1->{
                if(bandera){
                topog.posX=1100f
                topog.posY=-20f
                    topog.pintarImagen(canvas)
                    bandera=false
                    puntos++
                }else{
                    topo.posX=1100f
                    topo.posY=-20f
                    topo.pintarImagen(canvas)
                }
            }
            2->{
                if(bandera){
                topog.posX=50f
                topog.posY=380f
                topog.pintarImagen(canvas)
                    bandera=false
                    puntos++
                }
                else{
                    topo.posX=50f
                    topo.posY=380f
                    topo.pintarImagen(canvas)
                }
            }
            3->{
                if(bandera){
                topog.posX=450f
                topog.posY=380f
                topog.pintarImagen(canvas)
                bandera=false
                    puntos++
            }else{
                topo.posX=450f
                topo.posY=380f
                topo.pintarImagen(canvas)}
            }
            4->{
                if(bandera){
                    topog.posX=850f
                    topog.posY=380f
                    topog.pintarImagen(canvas)
                    bandera=false
                    puntos++
                }
                else{
                    topo.posX=850f
                    topo.posY=380f
                    topo.pintarImagen(canvas)
                }
            }
            5->{
                if(bandera){
                topog.posX=1250f
                topog.posY=380f
                    topog.pintarImagen(canvas)
                    bandera=false
                    puntos++
                }else{
                    topo.posX=1250f
                    topo.posY=380f
                topo.pintarImagen(canvas)}
            }
            6->{
                if(bandera){
                topog.posX=1650f
                topog.posY=380f
                topog.pintarImagen(canvas)
                bandera=false
                puntos++
            }else{
                topo.posX=1650f
                topo.posY=380f
                topo.pintarImagen(canvas)}
            }
            10->{
              System.out.println("asd")
            }
        }


    }
}
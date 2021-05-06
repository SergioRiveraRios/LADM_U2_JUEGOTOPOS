package mx.tecnm.tepic.ladm_u2_juegotopos

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint

class imagen(lienzo:lienzo,posX:Float,posY:Float,img:Int) {
    var posX=posX
    var posY=posY
    var img = BitmapFactory.decodeResource(lienzo.resources,img)

    fun pintarImagen(canvas:Canvas){
        canvas.drawBitmap(img,posX,posY,Paint())
    }

    fun cambiarImagen(lienzo: lienzo,img2:Int){
        img=BitmapFactory.decodeResource(lienzo.resources,img2)
    }

    fun tocarImagen(eventX:Float,eventY:Float):Boolean{
        if((eventX<=posX+img.width && eventX>=posX) &&
            (eventY<=posY+img.height && eventY>=posY)){
            return true
        }
        return false
    }
}

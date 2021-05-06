package mx.tecnm.tepic.ladm_u2_juegotopos

import kotlin.random.Random

class hilo(activity:lienzo):Thread(){
    var act=activity
    override fun run(){
        super.run()
        while (true){
            act.tiempo--
            act.invalidate()
            if(act.tiempo==0){
                sleep(5000)
                act.tiempo=30
            }
            System.out.println(act.tiempo)
            if(act.contador==3){
                act.contador=0
                act.bandera=false
                act.random= Random.nextInt(7)
                act.invalidate()
            }
            when(act.nivel){
                0->{
                    System.out.println("Nivel 0")
                    act.contador++
                    sleep(1000)
                }
                1->{
                    System.out.println("Nivel 1")
                    act.contador++
                    sleep(700)
                }
                2->{
                    System.out.println("Nivel 2")
                    act.contador++
                    sleep(500)
                }
            }

        }
    }
}
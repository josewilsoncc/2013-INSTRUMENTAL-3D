/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mundo;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Administrador
 */
public class BufferSonido {
    private Clip [] misSonidos;
    
    private int index;
    private String ruta;
    private File archivoAudio;

    public BufferSonido(String ruta) {
        misSonidos=new Clip[10];
        index=0;
        this.ruta=ruta;
        archivoAudio=new File(ruta);
        for(int i=0;i<misSonidos.length;i++){
            Main.miInterfazCarga.jLabelConsola.setText("Creando sonido: \""+ruta+"\" e index: "+i);
            try {
                misSonidos[i]=AudioSystem.getClip();
                misSonidos[i].open(AudioSystem.getAudioInputStream(archivoAudio));
            } catch (Exception ex) {
                Logger.getLogger(BufferSonido.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void play(){
        //System.out.println("Play ruta: "+ruta+" index:"+index);
        try {
            misSonidos[index].start();
            if(index<misSonidos.length-1)
                misSonidos[index+1].setFramePosition(0);
            else
                misSonidos[0].setFramePosition(0);
            for(int i=0;i<misSonidos.length;i++){
                if(!misSonidos[i].isRunning()){
                    misSonidos[i].setFramePosition(0);
                }
            }
        } catch (Exception ex) {}
        index++;
        if(index>=misSonidos.length)index=0;
    }
}

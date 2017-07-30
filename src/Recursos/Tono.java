/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Jose Capera
 */
public class Tono extends Thread{

    private int hz;
    private int msec;
    private int volumen;

    public Tono(int hz, int msec, int volumen) {
        this.hz = hz;
        this.msec = msec;
        this.volumen = volumen;
    }
    
    public static void nuevoTono(int hz, int msec, int volumen){
        Tono temp= new Tono(hz, msec, volumen);
        temp.start();
    }
    
    //Donde octava es un entero entre 0 y 10, y "nota" es un entero en el rango de 1 a 12. Do=1, Do#=2, Re=3, Re#=4, Mi=5, Fa=6, Fa#=7, Sol=8, Sol#=9, La=10, La#=11, Si=12.
    public static int frecuencia(double nota, double octava) 
    {
       return (int)(440.0 * Math.exp(((octava-4)+(nota-10)/12)*Math.log(2)))*1000;
    }
    
    private void hacerSonido(int hz, int msec, int volumen){
        try {
            float frecuencia = 44700;
            AudioFormat af = new AudioFormat(frecuencia, 8, 2, true, true);
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
            sdl.open(af);
            sdl.start();
            byte[] buf = new byte[2];
            for(int i=0;i<msec*frecuencia/1000;i++){
                double angle=i/(frecuencia/hz)*2.0*Math.PI;
                buf[0]=(byte)(Math.sin(angle)*volumen);
                buf[1]=(byte)(Math.sin(2*angle)*volumen*0.6);
                sdl.write(buf, 0, 2);
            }
            sdl.drain();
            sdl.stop();
            sdl.stop();
        } catch (LineUnavailableException ex) {
            System.out.println("Error: "+ex);
        }
    }
    
    @Override
    public void run(){
        hacerSonido(hz, msec, volumen);
    }
}
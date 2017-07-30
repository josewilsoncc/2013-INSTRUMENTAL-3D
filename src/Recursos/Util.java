/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursos;

import mundo.Configuracion;
import com.sun.opengl.util.texture.Texture;
import java.io.File;
import javax.media.opengl.GL;
import mundo.BufferSonido;

/**
 *
 * @author Jose
 * @author Carlos
 */
public class Util {
    
    public static final int X =0;
    public static final int Y =2;
    public static final int Z =3;
    
    public static void pintar(GL gl, Texture t, float x, float y, float z) {
        t.enable();//habilitamos
        t.bind();//pegamos           
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glBegin(gl.GL_QUADS);                                            

            gl.glTexCoord2f(0, 1);                
            gl.glVertex3f(x, y, z);     

            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(x + Configuracion.anchoNota, y, z);

            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(x + Configuracion.anchoNota, y + Configuracion.altoNota, z);

            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(x, y + Configuracion.altoNota, z);                                                                                                                                                                                                                                    
        gl.glEnd();
        t.disable();//desabilitar
    }
    
    public static void pintarCuadro(GL gl, Texture t, float tamaño, int grados, float x, float y, float z) {
        t.enable();//habilitamos
        t.bind();//pegamos
        gl.glRotatef(grados, 0, 1, 0);
        gl.glColor4f(1f, 1f, 1f, 1f);
        gl.glBegin(gl.GL_QUADS);                                            

            gl.glTexCoord2f(0, 1);                
            gl.glVertex3f(x, y, z);     

            gl.glTexCoord2f(1, 1);
            gl.glVertex3f(x + tamaño, y, z);

            gl.glTexCoord2f(1, 0);
            gl.glVertex3f(x + tamaño, y + tamaño, z);

            gl.glTexCoord2f(0, 0);
            gl.glVertex3f(x, y + tamaño, z);                                                                                                                                                                                                                                    
        gl.glEnd();
        t.disable();//desabilitar
        gl.glRotatef(-grados, 0, 1, 0);
    }
    
    public static void playSound(String ruta){
        BufferSonido player= new BufferSonido(ruta);
        player.play();
    }
}

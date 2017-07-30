/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import Recursos.Util;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.FileInputStream;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.*;  // GL constants

/**
 *
 * @author Jose Capera
 * @author Carlos
 */
public class NotaGrafica {

    public static final int NORMAL = 0;
    public static final int SONANDO = 1;

    public static Texture cara1;
    
    public static void pintar(GL gl, float x, float y, float z, int estado) {
        float alpha=0.5f;
        
        if(estado==NORMAL)
            alpha=0.2f;
        if(estado==SONANDO)
            alpha=1f;
        
        gl.glColor4f(0, estado, 0.6f, alpha);
        //Atras
        gl.glBegin(GL_QUADS); // draw using triangles
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glEnd();

        gl.glColor4f(0, estado, 0.8f, alpha);
        //izquierda
        gl.glBegin(GL_QUADS); // draw using triangles
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glEnd();

        gl.glColor4f(0, estado, 1, alpha);
        //abajo
        gl.glBegin(GL_QUADS); // draw using triangles
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glEnd();

        gl.glColor4f(0, estado, 0.6f, alpha);
        //AlFrente
        gl.glBegin(GL_QUADS); // draw using triangles
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glEnd();
        
        Util.pintar(gl, cara1, x*Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota+Configuracion.profundidadNota);
        
        gl.glColor4f(0, estado, 0.8f, alpha);
        //derecha
        gl.glBegin(GL_QUADS); // draw using triangles
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glEnd();

        gl.glColor4f(0, estado, 1, alpha);
        //arriba
        gl.glBegin(GL_QUADS); // draw using triangles
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota + Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glVertex3f(x*Configuracion.anchoNota, y*Configuracion.altoNota + Configuracion.altoNota, z*Configuracion.profundidadNota + Configuracion.profundidadNota);
        gl.glEnd();

        
    }
}
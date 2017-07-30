/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import Recursos.Util;
import com.sun.opengl.util.j2d.TextRenderer;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.*;

/**
 *
 * @author Jose Capera
 * @author Carlos
 */
public class PlanoDeReferencia {

    public static Texture[] notasTexturas;

    public static void pintar(GL gl) {

        for (int i = 0; i < notasTexturas.length; i++) {
            Util.pintar(gl, notasTexturas[i], 0, i * Configuracion.altoNota, 0);
        }


        //Eje X
        gl.glColor3f(0, 0, 1);
        gl.glBegin(GL_LINES); // draw using triangles
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(Configuracion.anchoPlano, 0.0f, 0.0f);
        gl.glEnd();
        //Eje Y
        gl.glColor3f(0, 1, 0);
        gl.glBegin(GL_LINES); // draw using triangles
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, Configuracion.altoPlano, 0.0f);
        gl.glEnd();
        //Eje Z
        gl.glColor3f(1, 0, 0);
        gl.glBegin(GL_LINES); // draw using triangles
        gl.glVertex3f(0.0f, 0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, Configuracion.profundidadPlano);
        gl.glEnd();

        for (float i = Configuracion.altoNota; i <= Configuracion.altoPlano; i += Configuracion.altoNota) {
            //gl.glColor3f(1, 0, 0);
            gl.glColor4f(0, 0, 1, 0.4f);
            gl.glBegin(GL_LINES);
            gl.glVertex3f(0.0f, i, 0.0f);
            gl.glVertex3f(Configuracion.anchoPlano, i, 0.0f);
            gl.glEnd();
            gl.glColor4f(0, 1, 0, 0.4f);
            gl.glBegin(GL_LINES);
            gl.glVertex3f(0.0f, i, 0.0f);
            gl.glVertex3f(0.0f, i, Configuracion.profundidadPlano);
            gl.glEnd();

        }

        for (float i = Configuracion.anchoNota; i <= Configuracion.anchoPlano; i += Configuracion.anchoNota) {
            //gl.glColor3f(0, 0, 1);
            gl.glColor4f(1, 0, 0, 0.4f);
            gl.glBegin(GL_LINES);
            gl.glVertex3f(i, 0.0f, 0.0f);
            gl.glVertex3f(i, 0.0f, Configuracion.profundidadPlano);
            gl.glEnd();
            gl.glColor4f(0, 0, 1, 0.4f);
            gl.glBegin(GL_LINES);
            gl.glVertex3f(i, 0.0f, 0.0f);
            gl.glVertex3f(i, Configuracion.altoPlano, 0.0f);
            gl.glEnd();
        }

        for (float i = Configuracion.profundidadNota; i <= Configuracion.profundidadPlano; i += Configuracion.profundidadNota) {
            //gl.glColor3f(0, 1, 0);
            gl.glColor4f(0, 1, 0, 0.4f);
            gl.glBegin(GL_LINES);
            gl.glVertex3f(0.0f, 0.0f, i);
            gl.glVertex3f(0.0f, Configuracion.altoPlano, i);
            gl.glEnd();
            gl.glColor4f(1, 0, 0, 0.4f);
            gl.glBegin(GL_LINES);
            gl.glVertex3f(0.0f, 0.0f, i);
            gl.glVertex3f(Configuracion.anchoPlano, 0.0f, i);
            gl.glEnd();
        }
    }
}
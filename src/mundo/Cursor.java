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
import static javax.media.opengl.GL.GL_LINES;

/**
 *
 * @author Jose Capera
 * @author Carlos Marulanda
 */
public class Cursor {
    public static void pintar(GL gl, int x, int y, int z) {
        
        gl.glColor4f(1, 1, 1, 1f);
        
        gl.glBegin(GL_LINES);
        gl.glVertex3f(0.0f, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(0.0f, Configuracion.altoNota*(1+y), Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(0.0f, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(0.0f, Configuracion.altoNota*(1+y), Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, 0, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, 0, Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), 0, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), 0, Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, 0);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, 0);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), 0);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), 0);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glEnd();
        
        //Lineas complementarias
        gl.glColor4f(0, 1, 0, 0.4f);
        gl.glBegin(GL_LINES);
        gl.glVertex3f(0, Configuracion.altoNota*y, 0);
        gl.glVertex3f(0, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(0, Configuracion.altoNota*(y+1), 0);
        gl.glVertex3f(0, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        
        gl.glColor4f(1, 0, 0, 0.4f);
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, 0, 0);
        gl.glVertex3f(Configuracion.anchoNota*x, 0, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), 0, 0);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), 0, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        
        //Cubo
        
        gl.glColor4f(0, 1, 0, 1f);
        
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*y, Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*x, Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
        gl.glBegin(GL_LINES);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*z);
        gl.glVertex3f(Configuracion.anchoNota*(x+1), Configuracion.altoNota*(y+1), Configuracion.profundidadNota*(z+1));
        gl.glEnd();
    }
}

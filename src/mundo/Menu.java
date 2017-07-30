/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import Interfaz.Principal;
import Recursos.Util;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.io.File;
import java.io.FileInputStream;
import javax.media.opengl.GL;
import static javax.media.opengl.GL.*;  // GL constants
import static mundo.NotaGrafica.cara1;
import static mundo.PlanoDeReferencia.notasTexturas;

/**
 *
 * @author Jose Capera
 * @author Carlos
 */
public class Menu {

    public static Texture t1;
    public static Texture t2;
    public static Texture t3;
    public static Texture m1, m2, m3, m4;
    public static Texture cursor;
    public static boolean direccion;
    
    public static void pintar(GL gl, int indexMenu) {
        try {
            
            if(t1==null){
                t1 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/ideal1.png")), false, TextureIO.PNG);
                t2 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/ideal2.png")), false, TextureIO.PNG);
                t3 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/ideal3.png")), false, TextureIO.PNG);
                m1 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/m1.png")), false, TextureIO.PNG);
                m2 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/m2.png")), false, TextureIO.PNG);
                m3 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/m3.png")), false, TextureIO.PNG);
                m4 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/m4.png")), false, TextureIO.PNG);
                cursor = TextureIO.newTexture(new FileInputStream(new File("Imagenes/cursor.png")), false, TextureIO.PNG);
                
                cara1 = TextureIO.newTexture(new FileInputStream(new File("Imagenes/nota.png")), false, TextureIO.PNG);
                notasTexturas = new Texture[22];
                notasTexturas[0] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c0-7.png")), false, TextureIO.PNG);
                notasTexturas[1] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c0-8.png")), false, TextureIO.PNG);
                notasTexturas[2] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c0-9.png")), false, TextureIO.PNG);
                notasTexturas[3] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c0-10.png")), false, TextureIO.PNG);
                notasTexturas[4] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c0-11.png")), false, TextureIO.PNG);
                notasTexturas[5] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-0.png")), false, TextureIO.PNG);
                notasTexturas[6] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-1.png")), false, TextureIO.PNG);
                notasTexturas[7] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-2.png")), false, TextureIO.PNG);
                notasTexturas[8] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-3.png")), false, TextureIO.PNG);
                notasTexturas[9] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-4.png")), false, TextureIO.PNG);
                notasTexturas[10] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-5.png")), false, TextureIO.PNG);
                notasTexturas[11] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-6.png")), false, TextureIO.PNG);
                notasTexturas[12] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-7.png")), false, TextureIO.PNG);
                notasTexturas[13] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-8.png")), false, TextureIO.PNG);
                notasTexturas[14] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-9.png")), false, TextureIO.PNG);
                notasTexturas[15] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-10.png")), false, TextureIO.PNG);
                notasTexturas[16] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c1-11.png")), false, TextureIO.PNG);
                notasTexturas[17] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c2-0.png")), false, TextureIO.PNG);
                notasTexturas[18] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c2-1.png")), false, TextureIO.PNG);
                notasTexturas[19] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c2-2.png")), false, TextureIO.PNG);
                notasTexturas[20] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c2-3.png")), false, TextureIO.PNG);
                notasTexturas[21] = TextureIO.newTexture(new FileInputStream(new File("Imagenes/c2-4.png")), false, TextureIO.PNG);
                
                Main.miInterfazCarga.setVisible(false);
                Principal.frame.setVisible(true);
            }
//                    Texture piso = TextureIO.newTexture(new FileInputStream(new File("src/Imagenes/piso.jpg")), false, TextureIO.JPG);
            Util.pintarCuadro(gl, t1, 5.0f, 0, -0f, -0f, 0f);
            gl.glTranslatef(-2.5f, -0.0f, 2.5f);
            Util.pintarCuadro(gl, t2, 5.0f, 45, -2.5f, -0f, 0f);
            gl.glTranslatef(2.5f, -0.0f, -2.5f);
            gl.glTranslatef(7.5f, -0.0f, 2.5f);
            Util.pintarCuadro(gl, t3, 5.0f, -45, -2.5f, -0f, 0f);
            gl.glTranslatef(-7.5f, -0.0f, -2.5f);
            
            Util.pintarCuadro(gl, m1, 2.0f, 0, 0f, 3f, 3f);
            Util.pintarCuadro(gl, m2, 2.0f, 0, 3f, 3f, 3f);
            Util.pintarCuadro(gl, m3, 2.0f, 0, 0f, 0f, 3f);
            Util.pintarCuadro(gl, m4, 2.0f, 0, 3f, 0f, 3f);
            
            switch(indexMenu){
                case 0:Util.pintarCuadro(gl, cursor, 2.0f, 0, 0f, 3f, 3.2f);break;
                case 1:Util.pintarCuadro(gl, cursor, 2.0f, 0, 3f, 3f, 3.2f);break;
                case 2:Util.pintarCuadro(gl, cursor, 2.0f, 0, 0f, 0f, 3.2f);break;
                case 3:Util.pintarCuadro(gl, cursor, 2.0f, 0, 3f, 0f, 3.2f);break;
            }
            
//                    gl.glRotated(90, 1, 0, 0);
//                    Util.pintarCuadro(gl, piso, 10.0f, 0, 0f, -0f, -2.5f);
//                    gl.glRotated(-90, 1, 0, 0);
        } catch (Exception ex) {
        }
    }
}
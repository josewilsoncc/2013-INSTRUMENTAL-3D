package Interfaz;

import Recursos.Demo;
import mundo.Configuracion;
import mundo.NotaGrafica;
import mundo.PlanoDeReferencia;
import Recursos.Util;
import com.sun.opengl.util.FPSAnimator;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.swing.*;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import static javax.media.opengl.GL.*;  // GL constants
import javax.media.opengl.GLCanvas;
import mundo.Recursos;

/**
 * JOGL 2.0 Program Template (GLCanvas) This is a "Component" which can be added
 * into a top-level "Container". It also handles the OpenGL events to render
 * graphics.
 */
@SuppressWarnings("serial")
public class Principal extends GLCanvas implements GLEventListener, KeyListener {
    // Define constants for the top-level container

    public static final int EST_INTRO = 0;
    public static final int EST_MENU = 1;
    public static final int EST_EDICION = 2;
    public static final int EST_REPRODUCIENDO = 3;
    
    private int estado;
    private int indexMenu;
    private int indexReproduccion;
    private int indexMovimiento;
    
    private int edicionX;
    private int edicionY;
    private int edicionZ;
    
    private boolean cameraOn;
    
    private static String TITLE = "Jose Wilson Capera, Carlos Andres Marulanda";  //Titulo de la ventana
    private static final int CANVAS_WIDTH = 640;  // width of the drawable
    private static final int CANVAS_HEIGHT = 480; // height of the drawable
    private static final int FPS = 24; // animator's target frames per second
    //private static final int FPS = 24; // animator's target frames per second
    
    private static final boolean O = false;
    private static final boolean X = true;
    
    private static final int OOO = -1;
    private static final int A08 = 0;
    private static final int A09 = 1;
    private static final int A10 = 2;
    private static final int A11 = 3;
    private static final int A12 = 4;
    
    private static final int B01 = 5;
    private static final int B02 = 6;
    private static final int B03 = 7;
    private static final int B04 = 8;
    private static final int B05 = 9;
    private static final int B06 = 10;
    private static final int B07 = 11;
    private static final int B08 = 12;
    private static final int B09 = 13;
    private static final int B10 = 14;
    private static final int B11 = 15;
    private static final int B12 = 16;
    
    private static final int C01 = 17;
    private static final int C02 = 18;
    private static final int C03 = 19;
    private static final int C04 = 20;
    private static final int C05 = 21;
    private static final int C06 = 22;
    
    public final static JFrame frame = new JFrame(); // Swing's JFrame or AWT's Frame
    
    public float xCamara=Configuracion.anchoNota*2;
    public float yCamara=Configuracion.altoNota*9;
    public float zCamara=15;
    
    public ArrayList<int[]>misNotas;
    public ArrayList<Boolean[]>misGolpes;

    //The entry main() method to setup the top-level container and animator
    public static void main(String[] args) {
        
        Recursos.main(args);
        
        // Run the GUI codes in the event-dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the OpenGL rendering canvas
                GLCanvas canvas = new Principal();
                canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

                // Create a animator that drives canvas' display() at the specified FPS.
                final FPSAnimator animator = new FPSAnimator(canvas, FPS, true);

                // Create the top-level container
                frame.getContentPane().add(canvas);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        // Use a dedicate thread to run the stop() to ensure that the
                        // animator stops before program exits.
                        new Thread() {
                            @Override
                            public void run() {
                                if (animator.isAnimating()) {
                                    animator.stop();
                                }
                                System.exit(0);
                            }
                        }.start();
                    }
                });
                frame.setTitle(TITLE);
                frame.pack();
                //frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                animator.start(); // start the animation loop
            }
        });
    }
    // Setup OpenGL Graphics Renderer
    private GLU glu;  // for the GL Utility

    /**
     * Constructor to setup the GUI for this Component
     */
    public Principal() {
        estado=EST_MENU;
        indexMenu=0;
        indexReproduccion=0;
        this.addGLEventListener(this);
        this.addKeyListener(this);
        frame.addKeyListener(this);
        
        edicionX=0;
        edicionY=0;
        edicionZ=0;
        
        misNotas=new ArrayList<int[]>();
        
        misGolpes=new ArrayList<Boolean[]>();
        
        Demo.bienLoco(misNotas, misGolpes);
        
        /*
        //
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        //
        misGolpes.add(new Boolean[]{X, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, X, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, O, O, O, X, O});
        misGolpes.add(new Boolean[]{X, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, X, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, X, O, O, X, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, X, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{X, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, X, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, O, O, O, X, O});
        misGolpes.add(new Boolean[]{X, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, O, O});
        misGolpes.add(new Boolean[]{O, O, O, O, X, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, X, O, O, X, O});
        misGolpes.add(new Boolean[]{O, O, O, O, X, O});
        misGolpes.add(new Boolean[]{O, O, O, X, X, O});
        misGolpes.add(new Boolean[]{O, O, O, O, X, O});
        */
    }

    // ------ Implement methods declared in GLEventListener ------
    /**
     * Called back immediately after the OpenGL context is initialized. Can be
     * used to perform one-time initialization. Run only once.
     */
    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();      // get the OpenGL graphics context
        glu = new GLU();                         // get GL Utilities
        
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
        gl.glClearDepth(1.0f);      // set clear depth value to farthest
        gl.glEnable(GL_DEPTH_TEST); // enables depth testing
        gl.glDepthFunc(GL_LEQUAL);  // the type of depth test to do
        gl.glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST); // best perspective correction
        gl.glShadeModel(GL_SMOOTH); // blends colors nicely, and smoothes out lighting
        
        //alpha on
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

        // ----- Your OpenGL initialization code here -----
    }

    /**
     * Call-back handler for window re-size event. Also called when the drawable
     * is first set to visible.
     */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();  // get the OpenGL 2 graphics context

        if (height == 0) {
            height = 1;   // prevent divide by zero
        }
        float aspect = (float) width / height;

        // Set the view port (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL_PROJECTION);  // choose projection matrix
        gl.glLoadIdentity();             // reset projection matrix
        glu.gluPerspective(45.0, aspect, 0.1, 100.0); // fovy, aspect, zNear, zFar
        glu.gluLookAt(
                xCamara, yCamara, zCamara,
                Configuracion.anchoNota*2, Configuracion.altoNota*9, 0,
                0, 1, 0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glDepthFunc(GL.GL_LEQUAL); //Comprueba la profundidad
        gl.glEnable(GL.GL_DEPTH_TEST); // Dibuja pixel si la coordenada Z es mas cercana al punto de vizualizacion
        gl.glClearDepth(1.0); //Inicializa posiciones en 1.0
        
        // Enable the model-view transform
        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity(); // reset
    }

    /**
     * Called back by the animator to perform rendering.
     */
    @Override
    public void display(GLAutoDrawable drawable) {
        reshape(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        
        GL gl = drawable.getGL();  // get the OpenGL 2 graphics context
        gl.glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear color and depth buffers
        gl.glLoadIdentity();  // reset the model-view matrix
        gl.glTranslatef(-0.0f, -0.0f, 0.0f); // translate into the screen
        
        if(estado==EST_MENU)
            gl.glClearColor(0.0f, 0.0f, 1.0f, 0.0f); // set background (clear) color
        else
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // set background (clear) color
        switch(estado){
            case EST_MENU:
                if(mundo.Menu.direccion){
                    if(xCamara<5f)xCamara+=0.02f;
                    else mundo.Menu.direccion=false;
                }
                else{
                    if(xCamara>-0.5f)xCamara-=0.02f;
                    else mundo.Menu.direccion=true;
                }
                mundo.Menu.pintar(gl, indexMenu);
                break;
            case EST_EDICION:
                PlanoDeReferencia.pintar(gl);
                mundo.Cursor.pintar(gl, edicionX, edicionY, edicionZ);
                for(int i=0;i<misNotas.size();i++){
                    for(int j=0;j<misNotas.get(0).length;j++){
                        if(misNotas.get(i)[j]!=-1){
                            if(i==indexReproduccion)
                                NotaGrafica.pintar(gl, j, misNotas.get(i)[j], i, NotaGrafica.SONANDO);
                            else
                                NotaGrafica.pintar(gl, j, misNotas.get(i)[j], i, NotaGrafica.NORMAL);
                        }
                    }
                }
                for(int i=0;i<misGolpes.size();i++){
                    for (int j = 0; j < misGolpes.get(i).length; j++) {
                        if(misGolpes.get(i)[j]){
                            gl.glTranslatef(0, 0, -(indexMovimiento*Configuracion.profundidadNota/4+Configuracion.profundidadNota*indexReproduccion));
                            if(i==indexReproduccion)
                                NotaGrafica.pintar(gl, 4, j, i, NotaGrafica.SONANDO);
                            else
                                NotaGrafica.pintar(gl, 4, j, i, NotaGrafica.NORMAL);
                            gl.glTranslatef(0, 0, +(indexMovimiento*Configuracion.profundidadNota/4+Configuracion.profundidadNota*indexReproduccion));
                        }
                    }
                }
                break;
            case EST_REPRODUCIENDO:
                PlanoDeReferencia.pintar(gl);
                if(indexMovimiento<3)
                    indexMovimiento++;
                else{
                    indexMovimiento=0;
                    if(indexReproduccion<misNotas.size() || indexReproduccion<misGolpes.size())
                        indexReproduccion++;
                    else
                        indexReproduccion=0;
                }
                
                if(indexMovimiento==0 && indexReproduccion<misGolpes.size()){
                    if(misGolpes.get(indexReproduccion)[0])Recursos.soundKick1.play();
                    if(misGolpes.get(indexReproduccion)[1])Recursos.soundKick2.play();
                    if(misGolpes.get(indexReproduccion)[2])Recursos.soundSnare2.play();
                    if(misGolpes.get(indexReproduccion)[3])Recursos.soundSnare1.play();
                    if(misGolpes.get(indexReproduccion)[4])Recursos.soundPalito1.play();
                    if(misGolpes.get(indexReproduccion)[5])Recursos.soundKick3.play();
                }
                if(indexMovimiento==0 && indexReproduccion<misNotas.size()){
                    switch(misNotas.get(indexReproduccion)[0]){
                        case A08:Recursos.I1A08.play();break;
                        case A09:Recursos.I1A09.play();break;
                        case A10:Recursos.I1A10.play();break;
                        case A11:Recursos.I1A11.play();break;
                        case A12:Recursos.I1A12.play();break;
                        case B01:Recursos.I1B01.play();break;
                        case B02:Recursos.I1B02.play();break;
                        case B03:Recursos.I1B03.play();break;
                        case B04:Recursos.I1B04.play();break;
                        case B05:Recursos.I1B05.play();break;
                        case B06:Recursos.I1B06.play();break;
                        case B07:Recursos.I1B07.play();break;
                        case B08:Recursos.I1B08.play();break;
                        case B09:Recursos.I1B09.play();break;
                        case B10:Recursos.I1B10.play();break;
                        case B11:Recursos.I1B11.play();break;
                        case B12:Recursos.I1B12.play();break;
                        case C01:Recursos.I1C01.play();break;
                        case C02:Recursos.I1C02.play();break;
                        case C03:Recursos.I1C03.play();break;
                        case C04:Recursos.I1C04.play();break;
                        case C05:Recursos.I1C05.play();break;
                        case C06:Recursos.I1C06.play();break;
                    }
                    switch(misNotas.get(indexReproduccion)[1]){
                        case A08:Recursos.I2A08.play();break;
                        case A09:Recursos.I2A09.play();break;
                        case A10:Recursos.I2A10.play();break;
                        case A11:Recursos.I2A11.play();break;
                        case A12:Recursos.I2A12.play();break;
                        case B01:Recursos.I2B01.play();break;
                        case B02:Recursos.I2B02.play();break;
                        case B03:Recursos.I2B03.play();break;
                        case B04:Recursos.I2B04.play();break;
                        case B05:Recursos.I2B05.play();break;
                        case B06:Recursos.I2B06.play();break;
                        case B07:Recursos.I2B07.play();break;
                        case B08:Recursos.I2B08.play();break;
                        case B09:Recursos.I2B09.play();break;
                        case B10:Recursos.I2B10.play();break;
                        case B11:Recursos.I2B11.play();break;
                        case B12:Recursos.I2B12.play();break;
                        case C01:Recursos.I2C01.play();break;
                        case C02:Recursos.I2C02.play();break;
                        case C03:Recursos.I2C03.play();break;
                        case C04:Recursos.I2C04.play();break;
                        case C05:Recursos.I2C05.play();break;
                        case C06:Recursos.I2C06.play();break;
                    }
                    switch(misNotas.get(indexReproduccion)[2]){
                        case A08:Recursos.I3A08.play();break;
                        case A09:Recursos.I3A09.play();break;
                        case A10:Recursos.I3A10.play();break;
                        case A11:Recursos.I3A11.play();break;
                        case A12:Recursos.I3A12.play();break;
                        case B01:Recursos.I3B01.play();break;
                        case B02:Recursos.I3B02.play();break;
                        case B03:Recursos.I3B03.play();break;
                        case B04:Recursos.I3B04.play();break;
                        case B05:Recursos.I3B05.play();break;
                        case B06:Recursos.I3B06.play();break;
                        case B07:Recursos.I3B07.play();break;
                        case B08:Recursos.I3B08.play();break;
                        case B09:Recursos.I3B09.play();break;
                        case B10:Recursos.I3B10.play();break;
                        case B11:Recursos.I3B11.play();break;
                        case B12:Recursos.I3B12.play();break;
                        case C01:Recursos.I3C01.play();break;
                        case C02:Recursos.I3C02.play();break;
                        case C03:Recursos.I3C03.play();break;
                        case C04:Recursos.I3C04.play();break;
                        case C05:Recursos.I3C05.play();break;
                        case C06:Recursos.I3C06.play();break;
                    }
                    switch(misNotas.get(indexReproduccion)[3]){
                        case A08:Recursos.I4A08.play();break;
                        case A09:Recursos.I4A09.play();break;
                        case A10:Recursos.I4A10.play();break;
                        case A11:Recursos.I4A11.play();break;
                        case A12:Recursos.I4A12.play();break;
                        case B01:Recursos.I4B01.play();break;
                        case B02:Recursos.I4B02.play();break;
                        case B03:Recursos.I4B03.play();break;
                        case B04:Recursos.I4B04.play();break;
                        case B05:Recursos.I4B05.play();break;
                        case B06:Recursos.I4B06.play();break;
                        case B07:Recursos.I4B07.play();break;
                        case B08:Recursos.I4B08.play();break;
                        case B09:Recursos.I4B09.play();break;
                        case B10:Recursos.I4B10.play();break;
                        case B11:Recursos.I4B11.play();break;
                        case B12:Recursos.I4B12.play();break;
                        case C01:Recursos.I4C01.play();break;
                        case C02:Recursos.I4C02.play();break;
                        case C03:Recursos.I4C03.play();break;
                        case C04:Recursos.I4C04.play();break;
                        case C05:Recursos.I4C05.play();break;
                        case C06:Recursos.I4C06.play();break;
                    }
                }
                for(int i=indexReproduccion;i<misNotas.size();i++){
                    for(int j=0;j<misNotas.get(i).length;j++){
                        if(misNotas.get(i)[j]!=-1){
                            gl.glTranslatef(0, 0, -(indexMovimiento*Configuracion.profundidadNota/4+Configuracion.profundidadNota*indexReproduccion));
                            if(i==indexReproduccion)
                                NotaGrafica.pintar(gl, j, misNotas.get(i)[j], i, NotaGrafica.SONANDO);
                            else
                                NotaGrafica.pintar(gl, j, misNotas.get(i)[j], i, NotaGrafica.NORMAL);
                            gl.glTranslatef(0, 0, +(indexMovimiento*Configuracion.profundidadNota/4+Configuracion.profundidadNota*indexReproduccion));
                        }
                    }
                }
                for(int i=0;i<misGolpes.size();i++){
                    for (int j = 0; j < misGolpes.get(i).length; j++) {
                        if(misGolpes.get(i)[j]){
                            gl.glTranslatef(0, 0, -(indexMovimiento*Configuracion.profundidadNota/4+Configuracion.profundidadNota*indexReproduccion));
                            if(i==indexReproduccion)
                                NotaGrafica.pintar(gl, 4, j, i, NotaGrafica.SONANDO);
                            else
                                NotaGrafica.pintar(gl, 4, j, i, NotaGrafica.NORMAL);
                            gl.glTranslatef(0, 0, +(indexMovimiento*Configuracion.profundidadNota/4+Configuracion.profundidadNota*indexReproduccion));
                        }
                    }
                }
                break;
        }
        try {Thread.sleep(35);} catch (InterruptedException ex) {}
    }

    /**
     * Called back before the OpenGL context is destroyed. Release resource such
     * as buffers.
     */
    public void dispose(GLAutoDrawable drawable) {
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {
        switch(estado){
            case EST_MENU:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        if(indexMenu==0 || indexMenu==1)indexMenu=0;
                        if(indexMenu==2 || indexMenu==3)indexMenu=2;
                        Util.playSound("Sonido/Menu/move.wav");
                        
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(indexMenu==0 || indexMenu==1)indexMenu=1;
                        if(indexMenu==2 || indexMenu==3)indexMenu=3;
                        Util.playSound("Sonido/Menu/move.wav");
                        break;
                    case KeyEvent.VK_UP:
                        if(indexMenu==2)indexMenu=0;
                        if(indexMenu==3)indexMenu=1;
                        Util.playSound("Sonido/Menu/move.wav");
                        break;
                    case KeyEvent.VK_DOWN:
                        if(indexMenu==0)indexMenu=2;
                        if(indexMenu==1)indexMenu=3;
                        Util.playSound("Sonido/Menu/move.wav");
                        break;
                    case KeyEvent.VK_ENTER:
                        if(indexMenu==0){
                            estado=EST_EDICION;
                            misNotas=new ArrayList<int[]>();
                            misGolpes=new ArrayList<Boolean[]>();
                            fCentrarCam();
                        }
                        if(indexMenu==1){
                            estado=EST_EDICION;
                            fCentrarCam();
                        }
                        if(indexMenu==3)System.exit(0);
                        break;
                }
                break;
            case EST_EDICION:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        if(cameraOn)
                            yCamara+=0.1f;
                        else
                            if(edicionY<22)edicionY++;
                        break;
                    case KeyEvent.VK_DOWN:
                        if(cameraOn)
                            yCamara-=0.1f;
                        else
                            if(edicionY>0)edicionY--;
                        break;
                    case KeyEvent.VK_LEFT:
                        if(cameraOn)
                            xCamara-=0.1f;
                        else
                            if(edicionX>0)edicionX--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(cameraOn)
                            xCamara+=0.1f;
                        else
                            if(edicionX<4)edicionX++;
                        break;
                    case KeyEvent.VK_MINUS:
                        if(cameraOn)
                            zCamara+=0.1f;
                        else
                            if(edicionZ>0){
                                edicionZ--;
                                zCamara-=Configuracion.profundidadNota;
                            }
                        break;
                    case KeyEvent.VK_PLUS:
                        if(cameraOn)
                            zCamara-=0.1f;
                        else{
                            edicionZ++;
                            zCamara+=Configuracion.profundidadNota;
                        }
                        break;
                    case KeyEvent.VK_SPACE:
                        indexReproduccion=0;
                        indexMovimiento=0;
                        estado=EST_REPRODUCIENDO;
                        break;
                    case KeyEvent.VK_F1:
                        cameraOn=!cameraOn;
                        break;
                    case KeyEvent.VK_F2:
                        edicionX=0;
                        edicionY=0;
                        edicionZ=0;
                        fCentrarCam();
                        break;
                    case KeyEvent.VK_ENTER:
                        if(edicionX<4){
                            while(misNotas.size()<edicionZ+1){
                                misNotas.add(new int[]{OOO,OOO,OOO,OOO});
                            }
                            if(misNotas.get(edicionZ)[edicionX]!=edicionY)
                                misNotas.get(edicionZ)[edicionX]=edicionY;
                            else
                                misNotas.get(edicionZ)[edicionX]=-1;
                        }
                        else{
                            while(misGolpes.size()<edicionZ+1){
                                misGolpes.add(new Boolean[]{O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O, O});
                                System.out.println("Add new line golpe");
                            }
                            if(misGolpes.get(edicionZ)[edicionY]!=X)
                                misGolpes.get(edicionZ)[edicionY]=X;
                            else
                                misGolpes.get(edicionZ)[edicionY]=O;
                        }
                        break;
                }
                break;
            case EST_REPRODUCIENDO:
                switch(e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        yCamara+=0.1f;
                        break;
                    case KeyEvent.VK_DOWN:
                        yCamara-=0.1f;
                        break;
                    case KeyEvent.VK_LEFT:
                        xCamara-=0.1f;
                        break;
                    case KeyEvent.VK_RIGHT:
                        xCamara+=0.1f;
                        break;
                    case KeyEvent.VK_MINUS:
                        zCamara+=0.1f;
                        break;
                    case KeyEvent.VK_PLUS:
                        zCamara-=0.1f;
                        break;
                    case KeyEvent.VK_ENTER:
                        //Util.playSound("Sonido/Principal/b6.mp3");
                        break;
                    case KeyEvent.VK_SPACE:
                        estado=EST_EDICION;
                        indexReproduccion=0;
                        indexMovimiento=0;
                        break;
                }
                break;
        }
        
    }

    public void keyReleased(KeyEvent e) {}

    private void fCentrarCam() {
        switch(estado){
            case EST_EDICION:
            case EST_REPRODUCIENDO:
                xCamara=Configuracion.anchoNota*2;
                yCamara=Configuracion.altoNota*9;
                zCamara=12;
                break;
        }
    }
}
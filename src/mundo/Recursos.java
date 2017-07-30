/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Jose Capera
 * @author Carlos Marulanda
 */
public class Recursos {
    
    //Sonidos de golpe
    public static BufferSonido soundKick1;
    public static BufferSonido soundKick2;
    public static BufferSonido soundKick3;
    public static BufferSonido soundSnare1;
    public static BufferSonido soundSnare2;
    public static BufferSonido soundPalito1;
    
    //Instrumento 1
    public static BufferSonido I1A08;
    public static BufferSonido I1A09;
    public static BufferSonido I1A10;
    public static BufferSonido I1A11;
    public static BufferSonido I1A12;
    
    public static BufferSonido I1B01;
    public static BufferSonido I1B02;
    public static BufferSonido I1B03;
    public static BufferSonido I1B04;
    public static BufferSonido I1B05;
    public static BufferSonido I1B06;
    public static BufferSonido I1B07;
    public static BufferSonido I1B08;
    public static BufferSonido I1B09;
    public static BufferSonido I1B10;
    public static BufferSonido I1B11;
    public static BufferSonido I1B12;
    
    public static BufferSonido I1C01;
    public static BufferSonido I1C02;
    public static BufferSonido I1C03;
    public static BufferSonido I1C04;
    public static BufferSonido I1C05;
    public static BufferSonido I1C06;
    
    //Instrumento 2
    public static BufferSonido I2A08;
    public static BufferSonido I2A09;
    public static BufferSonido I2A10;
    public static BufferSonido I2A11;
    public static BufferSonido I2A12;
    
    public static BufferSonido I2B01;
    public static BufferSonido I2B02;
    public static BufferSonido I2B03;
    public static BufferSonido I2B04;
    public static BufferSonido I2B05;
    public static BufferSonido I2B06;
    public static BufferSonido I2B07;
    public static BufferSonido I2B08;
    public static BufferSonido I2B09;
    public static BufferSonido I2B10;
    public static BufferSonido I2B11;
    public static BufferSonido I2B12;
    
    public static BufferSonido I2C01;
    public static BufferSonido I2C02;
    public static BufferSonido I2C03;
    public static BufferSonido I2C04;
    public static BufferSonido I2C05;
    public static BufferSonido I2C06;
    
    //Instrumento 3
    public static BufferSonido I3A08;
    public static BufferSonido I3A09;
    public static BufferSonido I3A10;
    public static BufferSonido I3A11;
    public static BufferSonido I3A12;
    
    public static BufferSonido I3B01;
    public static BufferSonido I3B02;
    public static BufferSonido I3B03;
    public static BufferSonido I3B04;
    public static BufferSonido I3B05;
    public static BufferSonido I3B06;
    public static BufferSonido I3B07;
    public static BufferSonido I3B08;
    public static BufferSonido I3B09;
    public static BufferSonido I3B10;
    public static BufferSonido I3B11;
    public static BufferSonido I3B12;
    
    public static BufferSonido I3C01;
    public static BufferSonido I3C02;
    public static BufferSonido I3C03;
    public static BufferSonido I3C04;
    public static BufferSonido I3C05;
    public static BufferSonido I3C06;
    
    //Instrumento 4
    public static BufferSonido I4A08;
    public static BufferSonido I4A09;
    public static BufferSonido I4A10;
    public static BufferSonido I4A11;
    public static BufferSonido I4A12;
    
    public static BufferSonido I4B01;
    public static BufferSonido I4B02;
    public static BufferSonido I4B03;
    public static BufferSonido I4B04;
    public static BufferSonido I4B05;
    public static BufferSonido I4B06;
    public static BufferSonido I4B07;
    public static BufferSonido I4B08;
    public static BufferSonido I4B09;
    public static BufferSonido I4B10;
    public static BufferSonido I4B11;
    public static BufferSonido I4B12;
    
    public static BufferSonido I4C01;
    public static BufferSonido I4C02;
    public static BufferSonido I4C03;
    public static BufferSonido I4C04;
    public static BufferSonido I4C05;
    public static BufferSonido I4C06;
    
    public static void main(String args[]){
        System.out.println("Cangando Sonidos");
        soundKick1=new BufferSonido("Sonido/Golpe/kick1.wav");
        soundKick2=new BufferSonido("Sonido/Golpe/kick2.wav");
        soundKick3=new BufferSonido("Sonido/Golpe/kick3.wav");
        soundSnare1=new BufferSonido("Sonido/Golpe/snare1.wav");
        soundSnare2=new BufferSonido("Sonido/Golpe/snare2.wav");
        soundPalito1=new BufferSonido("Sonido/Golpe/palito1.wav");
        
        Main.miInterfazCarga.jProgressBar.setValue(10);
        
        //Instrumento 1
        I1A08=new BufferSonido("Sonido/Instrumento1/a08.wav");
        I1A09=new BufferSonido("Sonido/Instrumento1/a09.wav");
        I1A10=new BufferSonido("Sonido/Instrumento1/a10.wav");
        I1A11=new BufferSonido("Sonido/Instrumento1/a11.wav");
        I1A12=new BufferSonido("Sonido/Instrumento1/a12.wav");
        
        I1B01=new BufferSonido("Sonido/Instrumento1/b01.wav");
        I1B02=new BufferSonido("Sonido/Instrumento1/b02.wav");
        I1B03=new BufferSonido("Sonido/Instrumento1/b03.wav");
        I1B04=new BufferSonido("Sonido/Instrumento1/b04.wav");
        I1B05=new BufferSonido("Sonido/Instrumento1/b05.wav");
        I1B06=new BufferSonido("Sonido/Instrumento1/b06.wav");
        I1B07=new BufferSonido("Sonido/Instrumento1/b07.wav");
        I1B08=new BufferSonido("Sonido/Instrumento1/b08.wav");
        I1B09=new BufferSonido("Sonido/Instrumento1/b09.wav");
        I1B10=new BufferSonido("Sonido/Instrumento1/b10.wav");
        I1B11=new BufferSonido("Sonido/Instrumento1/b11.wav");
        I1B12=new BufferSonido("Sonido/Instrumento1/b12.wav");
        
        I1C01=new BufferSonido("Sonido/Instrumento1/c01.wav");
        I1C02=new BufferSonido("Sonido/Instrumento1/c02.wav");
        I1C03=new BufferSonido("Sonido/Instrumento1/c03.wav");
        I1C04=new BufferSonido("Sonido/Instrumento1/c04.wav");
        I1C05=new BufferSonido("Sonido/Instrumento1/c05.wav");
        I1C06=new BufferSonido("Sonido/Instrumento1/c06.wav");
        
        Main.miInterfazCarga.jProgressBar.setValue(20);
        //Instrumento 2
        I2A08=new BufferSonido("Sonido/Instrumento2/a08.wav");
        I2A09=new BufferSonido("Sonido/Instrumento2/a09.wav");
        I2A10=new BufferSonido("Sonido/Instrumento2/a10.wav");
        I2A11=new BufferSonido("Sonido/Instrumento2/a11.wav");
        I2A12=new BufferSonido("Sonido/Instrumento2/a12.wav");
        
        I2B01=new BufferSonido("Sonido/Instrumento2/b01.wav");
        I2B02=new BufferSonido("Sonido/Instrumento2/b02.wav");
        I2B03=new BufferSonido("Sonido/Instrumento2/b03.wav");
        I2B04=new BufferSonido("Sonido/Instrumento2/b04.wav");
        I2B05=new BufferSonido("Sonido/Instrumento2/b05.wav");
        I2B06=new BufferSonido("Sonido/Instrumento2/b06.wav");
        I2B07=new BufferSonido("Sonido/Instrumento2/b07.wav");
        I2B08=new BufferSonido("Sonido/Instrumento2/b08.wav");
        I2B09=new BufferSonido("Sonido/Instrumento2/b09.wav");
        I2B10=new BufferSonido("Sonido/Instrumento2/b10.wav");
        I2B11=new BufferSonido("Sonido/Instrumento2/b11.wav");
        I2B12=new BufferSonido("Sonido/Instrumento2/b12.wav");
        
        I2C01=new BufferSonido("Sonido/Instrumento2/c01.wav");
        I2C02=new BufferSonido("Sonido/Instrumento2/c02.wav");
        I2C03=new BufferSonido("Sonido/Instrumento2/c03.wav");
        I2C04=new BufferSonido("Sonido/Instrumento2/c04.wav");
        I2C05=new BufferSonido("Sonido/Instrumento2/c05.wav");
        I2C06=new BufferSonido("Sonido/Instrumento2/c06.wav");
        
        Main.miInterfazCarga.jProgressBar.setValue(40);
        //Instrumento 3
        I3A08=new BufferSonido("Sonido/Instrumento3/a08.wav");
        I3A09=new BufferSonido("Sonido/Instrumento3/a09.wav");
        I3A10=new BufferSonido("Sonido/Instrumento3/a10.wav");
        I3A11=new BufferSonido("Sonido/Instrumento3/a11.wav");
        I3A12=new BufferSonido("Sonido/Instrumento3/a12.wav");
        
        I3B01=new BufferSonido("Sonido/Instrumento3/b01.wav");
        I3B02=new BufferSonido("Sonido/Instrumento3/b02.wav");
        I3B03=new BufferSonido("Sonido/Instrumento3/b03.wav");
        I3B04=new BufferSonido("Sonido/Instrumento3/b04.wav");
        I3B05=new BufferSonido("Sonido/Instrumento3/b05.wav");
        I3B06=new BufferSonido("Sonido/Instrumento3/b06.wav");
        I3B07=new BufferSonido("Sonido/Instrumento3/b07.wav");
        I3B08=new BufferSonido("Sonido/Instrumento3/b08.wav");
        I3B09=new BufferSonido("Sonido/Instrumento3/b09.wav");
        I3B10=new BufferSonido("Sonido/Instrumento3/b10.wav");
        I3B11=new BufferSonido("Sonido/Instrumento3/b11.wav");
        I3B12=new BufferSonido("Sonido/Instrumento3/b12.wav");
        
        I3C01=new BufferSonido("Sonido/Instrumento3/c01.wav");
        I3C02=new BufferSonido("Sonido/Instrumento3/c02.wav");
        I3C03=new BufferSonido("Sonido/Instrumento3/c03.wav");
        I3C04=new BufferSonido("Sonido/Instrumento3/c04.wav");
        I3C05=new BufferSonido("Sonido/Instrumento3/c05.wav");
        I3C06=new BufferSonido("Sonido/Instrumento3/c06.wav");
        
        Main.miInterfazCarga.jProgressBar.setValue(60);
        //Instrumento 4
        I4A08=new BufferSonido("Sonido/Instrumento4/a08.wav");
        I4A09=new BufferSonido("Sonido/Instrumento4/a09.wav");
        I4A10=new BufferSonido("Sonido/Instrumento4/a10.wav");
        I4A11=new BufferSonido("Sonido/Instrumento4/a11.wav");
        I4A12=new BufferSonido("Sonido/Instrumento4/a12.wav");
        
        I4B01=new BufferSonido("Sonido/Instrumento4/b01.wav");
        I4B02=new BufferSonido("Sonido/Instrumento4/b02.wav");
        I4B03=new BufferSonido("Sonido/Instrumento4/b03.wav");
        I4B04=new BufferSonido("Sonido/Instrumento4/b04.wav");
        I4B05=new BufferSonido("Sonido/Instrumento4/b05.wav");
        I4B06=new BufferSonido("Sonido/Instrumento4/b06.wav");
        I4B07=new BufferSonido("Sonido/Instrumento4/b07.wav");
        I4B08=new BufferSonido("Sonido/Instrumento4/b08.wav");
        I4B09=new BufferSonido("Sonido/Instrumento4/b09.wav");
        I4B10=new BufferSonido("Sonido/Instrumento4/b10.wav");
        I4B11=new BufferSonido("Sonido/Instrumento4/b11.wav");
        I4B12=new BufferSonido("Sonido/Instrumento4/b12.wav");
        
        I4C01=new BufferSonido("Sonido/Instrumento4/c01.wav");
        I4C02=new BufferSonido("Sonido/Instrumento4/c02.wav");
        I4C03=new BufferSonido("Sonido/Instrumento4/c03.wav");
        I4C04=new BufferSonido("Sonido/Instrumento4/c04.wav");
        I4C05=new BufferSonido("Sonido/Instrumento4/c05.wav");
        I4C06=new BufferSonido("Sonido/Instrumento4/c06.wav");
        Main.miInterfazCarga.jLabelConsola.setText("Cargando texturas");
        Main.miInterfazCarga.jProgressBar.setValue(80);
    }
}
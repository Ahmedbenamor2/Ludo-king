/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo.king;

import java.io.File;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author USER
 */
public class diceRoller implements Runnable{
    Random random=new Random();
    private ImageView diceImage;
    private int rand;
    private String state;
    diceRoller(ImageView diceImage){
        this.diceImage=diceImage;
    }
    public void setRand(int n){
        this.rand=n;
    }
    @Override
    public void run() {
        System.out.println("Thread Running");
                try {
                    int n=0;
                    for (int i = 0; i < 15; i++) {
                        n=random.nextInt(6)+1;
                        //System.out.println(i);
                        this.setRand(n);
                        File file = new File("C:\\Users\\USER\\Desktop\\dice" + n+".png");
                        this.diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                        
                    }
                    this.setRand(n);
                    //rollButton.setDisable(false);
                    //Grid.setConstraints(circ, array[rand][1], array[rand][0]);
                    //System.out.println(rand);
                    //System.out.println(array[0][0]+","+array[0][1]);
                    this.setstate("thread is finished");
                    System.out.println("Thread is not Running");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public int getRand(){
        return this.rand;
    }
    public String getState(){
        return this.state;
    }
    public void setstate(String ch){
        this.state=ch;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo.king;

import javafx.scene.shape.Circle;

/**
 *
 * @author USER
 */
public class Pion{
    private Circle circle=new Circle();
    private int x;
    private int y;
    private int initX;
    private int initY;
    private boolean isHome=true;
    Pion(int x,int y){
        //this.circle=circle;
        this.x=x;
        this.y=y;
        this.initX=x;
        this.initY=y;
    }
    
    public int getx(){
        return this.x;
    }
    
    public int gety(){
        return this.y;
    }
    
    public void setCoord(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public Circle getCircle(){
        return this.circle;
    }
    
    public boolean getIsHome(){
        return this.isHome;
    }
    
    public void setIsHome(boolean b){
        this.isHome=b;}
    
    public int getInitX(){
        return this.initX;
    }
    
    public int getInitY(){
        return this.initY;
    }
    
    public void setCircle(Circle c){
        this.circle=c;
    }
}

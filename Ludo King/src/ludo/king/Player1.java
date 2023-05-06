/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo.king;

import java.util.ArrayList;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author USER
 */
public class Player1 extends Player{
    private int[][] roadMap;
    private  Pion pion1,pion2,pion3,pion4;
    
    private boolean tour=false;
    private boolean tourPlayed;
    private ArrayList<Pion> listPion=new ArrayList<>();
    //private boolean isHome=true;
    Player1(Pion pion1,Pion pion2,Pion pion3,Pion pion4){
        this.pion1=pion1;
        this.pion2=pion2;
        this.pion3=pion3;
        this.pion4=pion4;
        
    }
    @Override
    public int[][] getRoadMap(){
        int[][] array={{6,1},{6,2},{6,3},{6,4},{6,5},{5,6},{4,6},{3,6},{2,6},{1,6},{0,6},{0,7},{0,8}
        ,{1,8},{2,8},{3,8},{4,8},{5,8},{6,9},{6,10},{6,11},{6,12},{6,13},{6,14},{7,14},{8,14},{8,13}
        ,{8,12},{8,11},{8,10},{8,9},{9,8},{10,8},{11,8},{12,8},{13,8},{14,8},{14,7},{14,6},{13,6}
        ,{12,6},{11,6},{10,6},{9,6},{8,5},{8,4},{8,3},{8,2},{8,1},{8,0},{7,0},{7,1},{7,2},{7,3},{7,4},{7,5},{7,6}};
        return array;
    }
    
    
    
    public Integer getPosInRoad(Pion p){
        int n=0;
        for(int i=0;i<this.getRoadMap().length;i++){
            if((this.getRoadMap()[i][0]==p.getx()) && (this.getRoadMap()[i][1]==p.gety())){
                n=i;
                break;
            }
        }
        return n;
    }
    
    
    public Pion getPion1(){
        return this.pion1;
    }
    
    public Pion getPion2(){
        return this.pion2;
    }
    
    public Pion getPion3(){
        return this.pion3;
    }
    
    public Pion getPion4(){
        return this.pion4;
    }
    
    public boolean getTour(){
        return this.tour;
    }
    
    public void setTour(boolean val){
        this.tour=val;
    }
    
    public boolean getTourPlayed(){
        return this.tourPlayed;
    }
    
    public void setTourPlayed(boolean val){
        this.tourPlayed=val;
    }
    
    public void addListPion(Pion p){
        this.listPion.add(p);
    }
    
    public ArrayList<Pion> getListPion(){
        return this.listPion;
    }
}

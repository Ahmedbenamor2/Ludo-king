/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo.king;

import java.util.ArrayList;

/**
 *
 * @author USER
 */
public abstract class Player {
    abstract public int[][] getRoadMap();
    
    abstract public Integer getPosInRoad(Pion p);
    
    abstract public Pion getPion1();
    
    abstract public Pion getPion2();
    
    abstract public Pion getPion3();
    
    abstract public Pion getPion4();
    
    abstract public boolean getTour();
    
    abstract public void setTour(boolean b);
    
    abstract public boolean getTourPlayed();
    
    abstract public void setTourPlayed(boolean val);
    
    abstract public void addListPion(Pion p);
    
    abstract public ArrayList<Pion> getListPion();
    
    public int getPosPlayer(ArrayList<Player> array,Player p){
        int n=0;
        for(int i=0;i<array.size();i++){
            if(array.get(i)==p){
                n=i;
                break;
            }
        }
        return n;
    }
}

    
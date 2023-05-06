/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ludo.king;

import java.io.File;
import static java.lang.Thread.State.TERMINATED;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import static javafx.print.PaperSource.MAIN;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Pair;
import javax.swing.JLabel;

/**
 *
 * @author USER
 */
public class controller implements Initializable{
    
    private Circle circ11,circ12,circ13,circ14,circ21,circ22,circ23,circ24,circ31,circ32,circ33,circ34,circ41,circ42,circ43,circ44;
    @FXML
    private GridPane Grid;
    @FXML
    private Button rollButton;
    @FXML
    private ImageView diceImage;
    @FXML
    Label label;
    
    ArrayList<Player> arrayPlayer=new ArrayList<Player>();
    
    CaseSpeciale cs1=new CaseSpeciale(6,1);
    CaseSpeciale cs2=new CaseSpeciale(2,6);
    CaseSpeciale cs3=new CaseSpeciale(1,8);
    CaseSpeciale cs4=new CaseSpeciale(6,12);
    CaseSpeciale cs5=new CaseSpeciale(8,13);
    CaseSpeciale cs6=new CaseSpeciale(12,8);
    CaseSpeciale cs7=new CaseSpeciale(13,6);
    CaseSpeciale cs8=new CaseSpeciale(8,2);
    CaseSpeciale[] arrayCase={cs1,cs2,cs3,cs4,cs5,cs6,cs7,cs8};
    
    diceRoller roller;
    int res;
    Thread createCircPlayer1=new Thread(){
        @Override
        public void run(){
            circ11=new Circle(0,0,11);
            circ11.setFill(Color.BLUE);
            Grid.add(circ11, 3, 3);
            
            
            circ12=new Circle(0,0,11);
            circ12.setFill(Color.BLUE);
            Grid.add(circ12, 2, 3);
            
            circ13=new Circle(0,0,11);
            circ13.setFill(Color.BLUE);
            Grid.add(circ13, 3, 2);
            
            circ14=new Circle(0,0,11);
            circ14.setFill(Color.BLUE);
            Grid.add(circ14, 2, 2);
        }
    };
    
    Thread createCircPlayer2=new Thread(){
        @Override
        public void run(){
            circ21=new Circle(1,0,11);
            circ21.setFill(Color.valueOf("#FA8072"));
            Grid.add(circ21, 12, 3);
            
            circ22=new Circle(0,0,11);
            circ22.setFill(Color.valueOf("#FA8072"));
            Grid.add(circ22, 11, 3);
            
            circ23=new Circle(0,0,11);
            circ23.setFill(Color.valueOf("#FA8072"));
            Grid.add(circ23, 12, 2);
            
            circ24=new Circle(0,0,11);
            circ24.setFill(Color.valueOf("#FA8072"));
            Grid.add(circ24, 11, 2);
        }
    };
    
    Thread createCircPlayer3=new Thread(){
        @Override
        public void run(){
            circ31=new Circle(1,0,11);
            circ31.setFill(Color.GREEN);
            Grid.add(circ31, 12, 12);
            
            circ32=new Circle(0,0,11);
            circ32.setFill(Color.GREEN);
            Grid.add(circ32, 11, 12);
            
            circ33=new Circle(0,0,11);
            circ33.setFill(Color.GREEN);
            Grid.add(circ33, 12, 11);
            
            circ34=new Circle(0,0,11);
            circ34.setFill(Color.GREEN);
            Grid.add(circ34, 11, 11);
        }
    };
    
    Thread createCircPlayer4=new Thread(){
        @Override
        public void run(){
            circ41=new Circle(1,0,11);
            circ41.setFill(Color.valueOf("#F4BC1C"));
            Grid.add(circ41, 3, 12);
            
            circ42=new Circle(0,0,11);
            circ42.setFill(Color.valueOf("#F4BC1C"));
            Grid.add(circ42, 2, 12);
            
            circ43=new Circle(0,0,11);
            circ43.setFill(Color.valueOf("#F4BC1C"));
            Grid.add(circ43, 3, 11);
            
            circ44=new Circle(0,0,11);
            circ44.setFill(Color.valueOf("#F4BC1C"));
            Grid.add(circ44, 2, 11);
        }
    };
    
    Pion p11=new Pion(3,3);
    Pion p12=new Pion(3,2);
    Pion p13=new Pion(2,3);
    Pion p14=new Pion(2,2);
    Player1 p1=new Player1(p11,p12,p13,p14);
    
    Pion p21=new Pion(3,12);
    Pion p22=new Pion(3,11);
    Pion p23=new Pion(2,12);
    Pion p24=new Pion(2,11);
    Player2 p2=new Player2(p21,p22,p23,p24);
    
    Pion p31=new Pion(12,12);
    Pion p32=new Pion(12,11);
    Pion p33=new Pion(11,12);
    Pion p34=new Pion(11,11);
    Player3 p3=new Player3(p31,p32,p33,p34);
    
    Pion p41=new Pion(12,3);
    Pion p42=new Pion(12,2);
    Pion p43=new Pion(11,3);
    Pion p44=new Pion(11,2);
    Player4 p4=new Player4(p41,p42,p43,p44);
    
    
    public void aGagne(Player p){
        boolean test=true;
        for(int i=0;i<p.getListPion().size();i++){
            if(p.getListPion().get(i).getx()!=p.getRoadMap()[p.getRoadMap().length-1][0] && p.getListPion().get(i).gety()!=p.getRoadMap()[p.getRoadMap().length-1][1]){
                test=false;
                break;
            }
        }
        
        if(test==true){
            Alert a=new Alert(AlertType.INFORMATION);
            a.setContentText(label.getText()+" a gagné!");
            a.show();
        }
    }
    
    
    public void alignement(Player player,Pion p){
        boolean test=false;
        for(int i=0;i<arrayCase.length;i++){
            if(arrayCase[i].getX()==p.getx() && arrayCase[i].getY()==p.gety()){
                test=true;
                break;
            }
        }
        
        if(test==true){
            p.getCircle().setRadius(6);
            if(player==p1){
                Grid.setHalignment(p.getCircle(),HPos.LEFT);
                Grid.setValignment(p.getCircle(),VPos.BOTTOM);
            }
            
            else if(player==p2){
                Grid.setHalignment(p.getCircle(),HPos.RIGHT);
                Grid.setValignment(p.getCircle(),VPos.BOTTOM);
            }
            
            else if(player==p3){
                Grid.setHalignment(p.getCircle(),HPos.LEFT);
                Grid.setValignment(p.getCircle(),VPos.TOP);
            }
            
            else if(player==p4){
                Grid.setHalignment(p.getCircle(),HPos.RIGHT);
                Grid.setValignment(p.getCircle(),VPos.TOP);
            }
        }
        else{
            p.getCircle().setRadius(11);
            Grid.setHalignment(p.getCircle(),HPos.CENTER);
            Grid.setValignment(p.getCircle(),VPos.CENTER);
        }
    }
    
    
    
    public void verif(ArrayList<Player> array,Player player,Pion p){
        boolean test=false;
        for(int i=0;i<arrayCase.length;i++){
            if(arrayCase[i].getX()==p.getx() && arrayCase[i].getY()==p.gety()){
                test=true;
                break;
            }
        }
        
        if(test==false){
            for(int i=0;i<array.size();i++){
                if(array.get(i)!=player){
                    for(int j=0;j<array.get(i).getListPion().size();j++){
                        if(array.get(i).getListPion().get(j).getx()==p.getx() && array.get(i).getListPion().get(j).gety()==p.gety()){
                            array.get(i).getListPion().get(j).setCoord(array.get(i).getListPion().get(j).getInitX(), array.get(i).getListPion().get(j).getInitY());
                            Grid.setConstraints(array.get(i).getListPion().get(j).getCircle(),array.get(i).getListPion().get(j).getInitY(),array.get(i).getListPion().get(j).getInitX());
                            array.get(i).getListPion().get(j).setIsHome(true);
                            
                            if(player==p1){
                                p1.setTour(false);
                                p1.setTourPlayed(true);
                                p2.setTour(false);
                                p3.setTour(false);
                                p4.setTour(true);
                                          }
                            else if(player==p2){
                                p2.setTour(false);
                                p2.setTourPlayed(true);
                                p1.setTour(true);
                                p3.setTour(false);
                                p4.setTour(false);
                             }
                            else if(player==p3){
                                p3.setTour(false);
                                p3.setTourPlayed(true);
                                p1.setTour(false);
                                p2.setTour(true);
                                p4.setTour(false);
                             }
            
                            else if(player==p4){
                                p4.setTour(false);
                                p4.setTourPlayed(true);
                                p1.setTour(false);
                                p2.setTour(false);
                                p3.setTour(true);
                                }
                        }
                    }
                }
            }
        }
        if(p.getx()==player.getRoadMap()[player.getRoadMap().length-1][0] && p.gety()==player.getRoadMap()[player.getRoadMap().length-1][1]){
            int n=player.getPosPlayer( arrayPlayer,player);
            if(n!=0){
            player.setTour(false);
            arrayPlayer.get(n-1).setTour(true);}
            else{
                player.setTour(false);
                p4.setTour(true);
            }
        }
    }
    
    
    
    
    public void movePion(Player player,Pion p,int n,Circle c){
        if(player.getTour()==true && player.getTourPlayed()==false){
        if(n==6 && p.getIsHome()==true){
            p.setIsHome(false);
            p.setCoord(player.getRoadMap()[0][0],player.getRoadMap()[0][1]);
            Grid.setConstraints(c,player.getRoadMap()[0][1],player.getRoadMap()[0][0]);
            player.setTourPlayed(true);
            alignement(player,p);
        }
        else if(p.getIsHome()==false){
            Thread thread2=new Thread(){
                @Override
                public void run(){
                    try{
                        if(player.getRoadMap().length-1>=player.getPosInRoad(p)+n){
                        for(int i=0;i<n;i++){
                            
                         p.setCoord(player.getRoadMap()[player.getPosInRoad(p)+1][0], player.getRoadMap()[player.getPosInRoad(p)+1][1]);
                         Grid.setConstraints(c,player.getRoadMap()[player.getPosInRoad(p)][1],player.getRoadMap()[player.getPosInRoad(p)][0]);
                         alignement(player,p);
                         Thread.sleep(500);
                        }
                        player.setTourPlayed(true);
                        }
                        else{
                            System.out.println("Tu doit avoir "+Integer.toString(player.getRoadMap().length-1-player.getPosInRoad(p))+" pour terminer!");
                        }
                        if(player==p1){
                            verif(arrayPlayer,p1,p);
                        }
                        else if(player==p2){
                            verif(arrayPlayer,p2,p);
                        }
                        else if(player==p3){
                            verif(arrayPlayer,p3,p);
                        }
                        else if(player==p4){
                            verif(arrayPlayer,p4,p);
                        }
                        
                        
                        
                        }
                        catch(Exception e){
                            System.out.println(e.getStackTrace());
                                           }
          
                                   }
             
            };
           thread2.start();
           aGagne(player);
          }
       
        }
        
    }
    
    
    
    @FXML
    void roll(ActionEvent event) throws InterruptedException {
        //File file = new File("dice" + (random.nextInt(6)+1)+".png");
        //diceImage.setImage(new Image(file.toURI().toString()));
        rollButton.setDisable(true);
        if(res!=6){
        /*if(p1.getTour()==true){
            p1.setTour(false);
            p2.setTour(true);
            System.out.println("c'est le tour de p2");
        }
        else if(p2.getTour()==true){
            p2.setTour(false);
            p1.setTour(true);
            System.out.println("c'est le tour de p1");
        }*/
        for(int i=0;i<arrayPlayer.size();i++){
            if(i!=(arrayPlayer.size()-1)){
                if(arrayPlayer.get(i).getTour()==true){
                    arrayPlayer.get(i).setTour(false);
                    arrayPlayer.get(i+1).setTour(true);
                    System.out.println("C'est le tour de p"+(i+2));
                    label.setText("player"+(i+2));
                    break;
                }
            }
            else{
                if(arrayPlayer.get(arrayPlayer.size()-1).getTour()==true){
                   arrayPlayer.get(arrayPlayer.size()-1).setTour(false);
                   arrayPlayer.get(0).setTour(true);
                   System.out.println("C'est le tour de p1");
                   label.setText("player1");
                }
            }
        }
        }
        
        p1.setTourPlayed(false);
        p2.setTourPlayed(false);
        p3.setTourPlayed(false);
        p4.setTourPlayed(false);
        roller=new diceRoller( diceImage);
        Thread thread=new Thread(roller);
        /*
        Thread thread = new Thread(){
            public void run(){
                System.out.println("Thread Running");
                try {
                    
                    for (int i = 0; i < 15; i++) {
                        rand=random.nextInt(6)+1;
                        File file = new File("C:\\Users\\USER\\Desktop\\dice" + rand+".png");
                        diceImage.setImage(new Image(file.toURI().toString()));
                        Thread.sleep(50);
                        
                    }
                    rollButton.setDisable(false);
                    Grid.setConstraints(circ, array[rand][1], array[rand][0]);
                    System.out.println(rand);
                    //System.out.println(array[0][0]+","+array[0][1]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }*/
        //};
        
        thread.start();
        thread.join();
        res=roller.getRand();
        
        circ11.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #1!");
            movePion(p1,p11,roller.getRand(),p11.getCircle());
            //p1.setTourPlayed(true);
        });
                
        circ12.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #2!");
            movePion(p1,p12,roller.getRand(),circ12);
            //p1.setTourPlayed(true);
        });
        
        circ13.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #3!");
            movePion(p1,p13,roller.getRand(),circ13);
            //p1.setTourPlayed(true);
        });
        
        circ14.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #4!");
            movePion(p1,p14,roller.getRand(),circ14);
            //p1.setTourPlayed(true);
        });
        
        
        
        
        circ21.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #1!");
            movePion(p2,p21,roller.getRand(),circ21);
            //p2.setTourPlayed(true);
        });
                
        circ22.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #2!");
            movePion(p2,p22,roller.getRand(),circ22);
            //p2.setTourPlayed(true);
        });
        
        circ23.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #3!");
            movePion(p2,p23,roller.getRand(),circ23);
            //p2.setTourPlayed(true);
        });
        
        circ24.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #4!");
            movePion(p2,p24,roller.getRand(),circ24);
            //p2.setTourPlayed(true);
        });
        
        
        circ31.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #1!");
            movePion(p3,p31,roller.getRand(),circ31);
            //p2.setTourPlayed(true);
        });
                
        circ32.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #2!");
            movePion(p3,p32,roller.getRand(),circ32);
            //p2.setTourPlayed(true);
        });
        
        circ33.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #3!");
            movePion(p3,p33,roller.getRand(),circ33);
            //p2.setTourPlayed(true);
        });
        
        circ34.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #4!");
            movePion(p3,p34,roller.getRand(),circ34);
            
        });
        
        
        
        circ41.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #1!");
            movePion(p4,p41,roller.getRand(),circ41);
            //p2.setTourPlayed(true);
        });
                
        circ42.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #2!");
            movePion(p4,p42,roller.getRand(),circ42);
            //p2.setTourPlayed(true);
        });
        
        circ43.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #3!");
            movePion(p4,p43,roller.getRand(),circ43);
            //p2.setTourPlayed(true);
        });
        
        circ44.setOnMouseClicked(e ->{
            System.out.println("mouse clicked in #4!");
            movePion(p4,p44,roller.getRand(),circ44);
            //p2.setTourPlayed(true);
        });
        
        rollButton.setDisable(false);
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        createCircPlayer1.start(); 
        try {
            createCircPlayer1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createCircPlayer2.start();
        try {
            createCircPlayer2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createCircPlayer3.start();
        try {
            createCircPlayer3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        createCircPlayer4.start();
        try {
            createCircPlayer4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p11.setCircle(circ11);p12.setCircle(circ12);p13.setCircle(circ13);p14.setCircle(circ14);
        p21.setCircle(circ21);p22.setCircle(circ22);p23.setCircle(circ23);p24.setCircle(circ24);
        p31.setCircle(circ31);p32.setCircle(circ32);p33.setCircle(circ33);p34.setCircle(circ34);
        p41.setCircle(circ41);p42.setCircle(circ42);p43.setCircle(circ43);p44.setCircle(circ44);
       
       p1.addListPion(p11);p1.addListPion(p12);p1.addListPion(p13);p1.addListPion(p14);
       p2.addListPion(p21);p2.addListPion(p22);p2.addListPion(p23);p2.addListPion(p24);
       p3.addListPion(p31);p3.addListPion(p32);p3.addListPion(p33);p3.addListPion(p34);
       p4.addListPion(p41);p4.addListPion(p42);p4.addListPion(p43);p4.addListPion(p44);
       
       arrayPlayer.add(p1);arrayPlayer.add(p2);arrayPlayer.add(p3);arrayPlayer.add(p4);
       
}
}
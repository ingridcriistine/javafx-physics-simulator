package com.desktop;

import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class Start implements Initializable{
    @FXML
    private VBox box;
    
    @FXML
    private Canvas canva;


    public static Scene CreateScene() throws Exception{
        URL sceneUrl = Start.class
            .getResource("bg.fxml");

        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Start controller = loader.getController();
        Timer timero = new Timer();

        timero.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){
                controller.canva.setWidth(scene.getWidth());
                controller.canva.setHeight(scene.getHeight());
            }
        }, 50, 50);

        return scene;
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Mass mass = new Mass(30, 30,50,0, 0);
        // Mass mass2 = new Mass(30, 40,0,0 , 0);
        // Spring spring = new Spring(mass, mass2, 50, 50);

        ArrayList<Mass> massa = new ArrayList<>();
        ArrayList<Spring> mola = new ArrayList<>();

        for(int i=0;i<10;i++){
            massa.add(new Mass(20, Math.random()*100, Math.random()*100, 0, 0));
            for(int j=0;j<i;j++){
                mola.add(new Spring(massa.get(j), massa.get(i), 20, 50));
            }
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){

                var g = canva.getGraphicsContext2D();
                g.clearRect(0, 0, canva.getWidth(), canva.getHeight());
                // mass.Calculate(0.05, canva.getHeight(), canva.getWidth());
                // mass2.Calculate(0.05, canva.getHeight(), canva.getWidth());
                // spring.CalculateSpring();
                
                // spring.DrawSpring(g);
                // mass.DrawMass(g,Color.RED);
                // mass2.DrawMass(g,Color.BLUE);


                for (Mass massas : massa) {
                    massas.Calculate(0.05,canva.getHeight(), canva.getWidth());
                }
                for (Spring molas : mola) {
                    molas.CalculateSpring();
                }

                for (Mass massas : massa) {
                    massas.DrawMass(g,Color.rgb((int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255), 1.0));
                }

                for (Spring molas : mola) {
                    molas.DrawSpring(g);
                }
            }
        }, 50, 50);
    }


    Timer timer = new Timer();



    @FXML
    public void MouseEntered(MouseEvent e){
        
    }
    
    @FXML
    public void  GetMouse(MouseEvent e){
    }

    @FXML
    public void MouseDown(MouseEvent e){
    }


    private void draw(){
    }

    private void setCanva() {
        
    } 

}
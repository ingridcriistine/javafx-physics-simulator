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

        Mass mass = new Mass(10, 200,0,0, 0,Color.RED);
        Mass mass2 = new Mass(10, 300,0,0 , 0,Color.BLUE);
        Mass mass3 = new Mass(10, 200,100,0 , 0,Color.PURPLE);
        Mass mass4 = new Mass(10, 300,100,0 , 0,Color.GREEN);

        Spring spring = new Spring(mass, mass2, 111, 100);
        Spring spring2 = new Spring(mass, mass3, 111, 100);

        Spring spring3 = new Spring(mass4, mass2, 111, 100);
        Spring spring4 = new Spring(mass4, mass3, 111, 100);
        
        Spring spring5 = new Spring(mass, mass4, 111, 141.42135623730950488016887242097);
        Spring spring6 = new Spring(mass2, mass3, 111, 141.42135623730950488016887242097);


        

        ArrayList<Mass> massa = new ArrayList<>();
        ArrayList<Spring> mola = new ArrayList<>();

        for(int i=0;i<0;i++){
            massa.add(new Mass(50, Math.random()*100, Math.random()*100, 0, 0,Color.rgb((int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255),(int)Math.round(Math.random()*255), 1.0)));
            for(int j=0;j<i;j++){
                mola.add(new Spring(massa.get(j), massa.get(i), 1, 300));
            }
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){

                var g = canva.getGraphicsContext2D();
                g.clearRect(0, 0, canva.getWidth(), canva.getHeight());

                mass.Calculate(0.05, canva.getHeight(), canva.getWidth());
                mass2.Calculate(0.05, canva.getHeight(), canva.getWidth());
                mass3.Calculate(0.05, canva.getHeight(), canva.getWidth());
                mass4.Calculate(0.05, canva.getHeight(), canva.getWidth());

                spring.CalculateSpring();
                spring2.CalculateSpring();
                spring3.CalculateSpring();
                spring4.CalculateSpring();
                spring5.CalculateSpring();
                spring6.CalculateSpring();

                spring.DrawSpring(g);
                spring2.DrawSpring(g);
                spring3.DrawSpring(g);
                spring4.DrawSpring(g);
                spring5.DrawSpring(g);
                spring6.DrawSpring(g);
                mass.DrawMass(g);
                mass2.DrawMass(g);
                mass3.DrawMass(g);
                mass4.DrawMass(g);

                for (Mass massas : massa) {
                    massas.Calculate(0.05,canva.getHeight(), canva.getWidth());
                }

                for (Spring molas : mola) {
                    molas.CalculateSpring();
                }

                for (Spring molas : mola) {
                    molas.DrawSpring(g);
                }

                for (Mass massas : massa) {
                    massas.DrawMass(g);
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
}
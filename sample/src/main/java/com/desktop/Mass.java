package com.desktop;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;



public class Mass {

    private double weigth;
    private double x;
    private double y;
    private double vx;
    private double vy;


    public Mass(double weigth,double x,double y,double vx,double vy){
        this.weigth = weigth;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
    }

    public void Calculate(double time, double height, double width){

        this.vy += 980 * time;
        this.y += this.vy * time;
        this.x += this.vx * time;
        
        if(this.y+this.weigth>=height){
            this.vy *= -0.9;
            this.y = height-this.weigth;
        }else if(this.y+this.weigth<=0){
            this.vy *= -0.9;
            this.y = 0 ;
        }

        if(this.x>=width){
            this.vx *= -0.9;
            this.x = width;
        }else if(this.x<=0){
            this.vx *= -0.9;
            this.x = 0 ;
        }        
    }

    public void DrawMass(GraphicsContext g,Color color) {
        g.setFill(color);
        g.fillArc(this.x - this.weigth / 2,this.y, this.weigth, this.weigth,0, 360, ArcType.ROUND);
    }

    public double getWeigth() {
        return weigth;
    }

    public void setWeigth(double weigth) {
        this.weigth = weigth;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getVx() {
        return vx;
    }

    public void setVx(double vx) {
        this.vx = vx;
    }

    public double getVy() {
        return vy;
    }

    public void setVy(double vy) {
        this.vy = vy;
    }



}

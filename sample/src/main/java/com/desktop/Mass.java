package com.desktop;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;

public class Mass {

    private double weigth;
    private double x;
    private double y;
    private double vx;
    private double vy;
    private Color color;

    public Mass(double weigth,double x,double y,double vx,double vy, Color color){
        this.weigth = weigth;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.color = color;
    }

    public void Calculate(double time, double height, double width){

        this.vy += 980 * time;
        this.y += this.vy * time;
        this.x += this.vx * time;
        
        if(this.y+this.weigth>=height){
            this.vy *= -0.8;
            this.y = height-this.weigth;
        }else if(this.y+this.weigth<=0){
            this.vy *= -0.8;
            this.y = 0 ;
        }

        if(this.x>=width){
            this.vx *= -0.8;
            this.x = width;
        }else if(this.x<=0){
            this.vx *= -0.8;
            this.x = 0 ;
        }        
    }

    public void DrawMass(GraphicsContext g) {
        g.setFill(this.color);
        g.fillArc(this.x - this.weigth / 2,this.y, this.weigth, this.weigth,0, 360, ArcType.ROUND);
        g.setFill(Color.BLACK);
        g.setFont(new Font(this.weigth/4));
        g.fillText(String.valueOf(this.weigth), this.x - this.weigth / 3, this.y + this.weigth/2);
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

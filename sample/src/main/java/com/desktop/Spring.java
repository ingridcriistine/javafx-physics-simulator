package com.desktop;

import javafx.scene.canvas.GraphicsContext;

public class Spring {
    public Spring(Mass m1,Mass m2,double k, double len){
        this.m1 = m1;
        this.m2 = m2;
        this.k = k;
        this.len = len;
    };

    private Mass m1;
    private Mass m2;
    private double k;
    private double len;


    public void CalculateSpring(){
        double C = Math.pow(m1.getX() - m2.getX(), 2);
        double B = Math.pow(m1.getY() - m2.getY(), 2);
        double A = Math.sqrt(B + C);

        double deformation = this.len - A;
        
        double Fe = deformation * this.k;

        double ux = Math.abs(m1.getX() - m2.getX())== 0? 0 :(m1.getX() - m2.getX())/Math.abs(m1.getX() - m2.getX());
        double uy = Math.abs(m1.getY() - m2.getY())== 0? 0 :(m1.getY() - m2.getY())/Math.abs(m1.getY() - m2.getY());

        double fx = Fe * ux;
        double fy = Fe * uy;

        m1.setVx(m1.getVx()+((fx)/m1.getWeigth()));
        m2.setVx(m2.getVx()+((fx*-1)/m2.getWeigth()));

        m1.setVy(m1.getVy()+((fy)/m1.getWeigth()));
        m2.setVy(m2.getVy()+((fy*-1)/m2.getWeigth()));

    }


    public void DrawSpring(GraphicsContext g) {
        g.strokeLine(m1.getX(), m1.getY()+m1.getWeigth()/2, m2.getX(), m2.getY()+m2.getWeigth()/2);
    }
}

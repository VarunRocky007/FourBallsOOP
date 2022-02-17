package com.thoughtworks;

import processing.core.PApplet;

import java.util.ArrayList;

public class FourBalls extends PApplet {

    public static final int HEIGHT = 480;
    public static final int WIDTH = 640;
    public static final int DIVISOR = 5;
    ArrayList<Ball> ballList;
    public int position=1;
    public static void main(String[] args) {
        PApplet.main("com.thoughtworks.FourBalls",args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        initializeBalls();
        setValues();
    }

    @Override
    public void draw() {
        drawBall();
    }

    private void drawBall() {
        for (int index=0;index<4;index++){
            int position = getXAxisPosition(ballList.get(index).getSpeed());
            int height = getYAxisPosition(ballList.get(index).getSpeed());
            int diameter = ballList.get(index).getDiameter();
            ellipse(position,height,diameter,diameter);
        }
        position+=1;
    }
    public int getXAxisPosition(int speed){
        return this.position*speed;
    }
    public int getYAxisPosition(int speed){
        return HEIGHT*speed /DIVISOR;
    }

    public void initializeBalls(){
        ballList = new ArrayList<Ball>();
        for(int index = 0;index<4;index++){
            ballList.add(new Ball());
        }
    }
    public void setValues(){
        for (int index=0;index<4;index++){
            Ball ball = ballList.get(index);
            ball = setSpecificationsOfBall(ball,index+1);
            ballList.set(index,ball);
        }
    }
    public Ball setSpecificationsOfBall(Ball ball,int speed){
        ball.setSpeed(speed);
        ball.setDiameter(5);
        return ball;
    }
}

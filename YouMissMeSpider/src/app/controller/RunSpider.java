/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.model.Cell;
import app.view.MainView;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Amador Salas
 */
public class RunSpider implements Runnable{
    private Cell actual;
    private ArrayList<Cell> path;
    private MainView mainView;
    public boolean running=true;

    public RunSpider(MainView mainView, ArrayList<Cell> path) {
        this.mainView=mainView;
        this.path=path;
        this.actual=mainView.spider;
    }
    public void StartMovement() throws InterruptedException{
        int index=0;
        Thread.sleep(1000);
        while(running){
            if(index<path.size()){
                this.actual.setIcon(new ImageIcon("./src/app/util/wood.jpg"));
                this.actual=path.get(index);
                setNewPosition(actual);
            }else{
                running=false;
                break;
            }
        }
    }
    @Override
    public void run() {
        try {
            this.StartMovement();
        } catch (InterruptedException ex) {
           
        }
    }

    private void setNewPosition(Cell actual) {
        actual.setIcon(new ImageIcon("./src/app/util/spider.jpg"));
        mainView.spider=actual;
    }
    
}

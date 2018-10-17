/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import app.model.Cell;
import app.view.MainView;

/**
 *
 * @author Daniel Amador Salas
 */
public class RunSpider implements Runnable{
    private Cell actual;
    private Cell[] path;
    private MainView mainView;

    public RunSpider(MainView mainView, Cell[] path) {
        this.mainView=mainView;
        this.path=path;
        this.actual=mainView.spider;
    }
    public void StartMovement(){
        
    }
    @Override
    public void run() {
        
    }
    
}

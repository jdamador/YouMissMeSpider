/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.model;

import app.view.MainView;

public class Connection {
    MainView mainView;
    public Connection(MainView mainView) {
        this.mainView=mainView;
    }

    public Cell[] getPath() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if(i+1<=6)
                    asociate(mainView.maze[i][j].name, mainView.maze[i+1][j].name);
                if(i-1>=0)
                    asociate(mainView.maze[i][j].name, mainView.maze[i-1][j].name);
                if(j+1<=6)
                    asociate(mainView.maze[i][j].name, mainView.maze[i][j+1].name);
                if(j-1>=0)
                    asociate(mainView.maze[i][j].name, mainView.maze[i][j-1].name);
            }
        }
        return searchPath(mainView.spider.name, mainView.wasp.name);
    }
    
    public void asociate(String A , String B){
        System.out.println("A>"+A+" B>"+B);
    }

    private Cell[] searchPath(String spider, String wasp) {
        return null;
    }
    
}

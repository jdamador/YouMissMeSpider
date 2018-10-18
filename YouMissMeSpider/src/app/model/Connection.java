/******************************************************************************\
 * Logic paradigm implementation in Java
 * Author: Daniel Amador Salas
 * Version: 1.0
 * Date: October 16th
\******************************************************************************/
package app.model;

import app.view.MainView;
import org.jpl7.Query;

public class Connection {
    MainView mainView;
    public Connection(MainView mainView) {
        this.mainView=mainView;
    }
    public Connection() {
       
    }
    public String[] getPath() {
        String queryPL= "consult('prolog.pl')";
        Query queryRest = new Query(queryPL);
        if(queryRest.hasSolution()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if(mainView.maze[i][j].allow){
                        if(i+1<=8)
                            if(mainView.maze[i+1][j].allow)
                                asociate(mainView.maze[i][j].name, mainView.maze[i+1][j].name);
                        if(i-1>=0)
                            if(mainView.maze[i-1][j].allow)
                                asociate(mainView.maze[i][j].name, mainView.maze[i-1][j].name);
                        if(j+1<=8)
                            if(mainView.maze[i][j+1].allow)
                                asociate(mainView.maze[i][j].name, mainView.maze[i][j+1].name);
                        if(j-1>=0)
                            if(mainView.maze[i][j-1].allow)
                                asociate(mainView.maze[i][j].name, mainView.maze[i][j-1].name);
                    }
                }
            }
        }
        return searchPath(mainView.spider.name, mainView.wasp.name);
    }
    public void asociate(String A , String B){
          String queryPL= "addNode("+A+","+B+",1)";
          Query queryRest = new Query(queryPL);
          queryRest.hasSolution();
    }
    private String[] searchPath(String spider, String wasp) {
        
        String queryPL= "go("+spider+","+wasp+",X)";
        Query queryRest = new Query(queryPL);
        String path="";
        while(queryRest.hasNext())
            path=queryRest.nextSolution().get("X").toString();
       
        return cleanPath(path);
    }
    public String[] cleanPath(String ruta){
        return ruta.replace("[","").replace("|", "").replace("'", "").replace("]","").replace("(", "").replace(")", "").replace(" ","").split(",");
    }

    public void clear() {
        String queryPL= "consult('prolog.pl')";
        Query queryRest = new Query(queryPL);
        if(queryRest.hasSolution()){
           queryPL= "clearAll(X,Y,P)";
           queryRest = new Query(queryPL);
        }
    }
    
}

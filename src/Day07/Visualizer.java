package Day07;

public class Visualizer { // Visualizer class start
    // 매개변수 o, 반환값 o -> String ~~(매개변수)
    String getStarts( int x ){
        String result = "";
        for ( int i = 0; i < x; i++){
            result += "★";
        }
        return result;
    }
} // Visualizer class end

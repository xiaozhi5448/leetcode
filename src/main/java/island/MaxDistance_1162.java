package island;

import java.util.HashSet;

public class MaxDistance_1162 {
    int distance;
    class Point implements Comparable{
        int rol,col;

        public Point(int rol, int col) {
            this.rol = rol;
            this.col = col;
        }

        @Override
        public int compareTo(Object o) {
            Point rel = (Point)o;
            if(this.rol == rel.rol && this.col == rel.col){
                return 0;
            }else{
                return -1;
            }
        }

        public int distance(Point other){
            return Math.abs(this.col - other.getCol()) + Math.abs(this.rol - other.getRol());
        }

        public int getRol() {
            return rol;
        }

        public void setRol(int rol) {
            this.rol = rol;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }
    public int maxDistance(int[][] grid) {
        distance = 0;
        HashSet<Point> islandPoints = new HashSet<>();
        HashSet<Point> oceanPoints = new HashSet<>();
        for(int row= 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 0){
                    oceanPoints.add(new Point(row, col));
                }else{
                    islandPoints.add(new Point(row, col));
                }
            }
        }
        if(islandPoints.isEmpty() || oceanPoints.isEmpty()){
            return -1;
        }
        int tmp;
        for(Point point: oceanPoints){
            tmp = Integer.MAX_VALUE;
            for(Point end: islandPoints){
                tmp = point.distance(end) < tmp? point.distance(end): tmp;

            }
            distance = tmp>distance? tmp:distance;
        }
        return distance;
    }
}

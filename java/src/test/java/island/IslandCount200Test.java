package island;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IslandCount200Test {

    @Test
    public void testScanner(){
        List<Integer> items = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            items.add(scanner.nextInt());
        }
        System.out.println(items.toString());
        
    }

    @Test
    public void numIslands() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1',  '0', '0'},
                {'0', '0', '0',  '1',  '1'}
        };
        IslandCount_200 obj = new IslandCount_200();
        int res = obj.numIslands(grid);
        System.out.println(res);
        List<Integer> items = new ArrayList<>();
        items.add(3);
        StringBuilder sb = new StringBuilder();

    }
}
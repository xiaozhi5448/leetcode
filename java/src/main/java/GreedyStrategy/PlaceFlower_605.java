package GreedyStrategy;

public class PlaceFlower_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0;
        for(int i = 0; i<flowerbed.length;i++){
            if(flowerbed[i] ==0){
                if(i-1 >= 0){
                    if(flowerbed[i-1] == 1){
                        continue;
                    }
                }
                if(i+1 < flowerbed.length){
                    if(flowerbed[i+1] == 1){
                        continue;
                    }
                }
                flowerbed[i] = 1;
                res++;
            }
        }
        return res >= n;

    }
}

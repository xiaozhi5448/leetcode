package middle;

import GreedyStrategy.VideoStitching;
import org.junit.Test;

public class VideoStitchingTest {

    @Test
    public void videoStitching() {
        VideoStitching obj = new VideoStitching();
        int[][] clips = {{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}};
        int res = obj.videoStitching(clips, 10);
    }
}
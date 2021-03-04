package UnionSet;

import junit.framework.TestCase;

public class AreaSplit_959Test extends TestCase {

    public void testRegionsBySlashes() {
        AreaSplit_959 util = new AreaSplit_959();
        String[] grid = {" /", "/ "};
        int count = util.regionsBySlashes(grid);
        System.out.println(count);
    }
}
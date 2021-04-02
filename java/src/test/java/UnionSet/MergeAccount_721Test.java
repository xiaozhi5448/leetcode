package UnionSet;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeAccount_721Test {

    @Test
    public void accountsMerge() {
        MergeAccount_721 util = new MergeAccount_721();
        List<List<String>> accounts = new LinkedList<>();
        accounts.add(new LinkedList<String>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
        accounts.add(new LinkedList<String>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts.add(new LinkedList<String>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
        accounts.add(new LinkedList<String>(Arrays.asList("Mary", "mary@mail.com")));
        List<List<String>> res = util.accountsMerge(accounts);
        System.out.println(res.toString());
    }
}
package UnionSet;

import java.util.*;

public class MergeAccount_721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<Integer, String> indexToEmail = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int emailCount = 0;
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                String email = account.get(i);
                if(emailToIndex.containsKey(email)){
                    continue;
                }
                emailToIndex.put(email, emailCount);
                indexToEmail.put(emailCount, email);
                emailToName.put(email, name);
                emailCount += 1;
            }
        }
        UnionFind uf = new UnionFind(emailCount);
        for(List<String> account: accounts){
            for(int i = 2; i < account.size(); i++){
                int id1 =  emailToIndex.get(account.get(i-1));
                int id2 = emailToIndex.get(account.get(i));
                uf.union(id1, id2);
            }
        }
        Map<Integer, List<String>> emailsSet = new HashMap<>();
        for(int i = 0; i < emailCount; i++){
            int p = uf.find(i);
            if(!emailsSet.containsKey(p)){
                emailsSet.put(p, new LinkedList<>());
            }
            String email = indexToEmail.get(i);
            emailsSet.get(p).add(email);
        }
        List<List<String>> res = new LinkedList<>();
        for(Integer p: emailsSet.keySet()){
            List<String> account = emailsSet.get(p);
            String email = indexToEmail.get(p);
            String name = emailToName.get(email);
            Collections.sort(account);
            account.add(0, name);
            res.add(account);
        }
        return res;
    }

}

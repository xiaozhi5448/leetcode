package UnionSet;

import java.util.*;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
 * 其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
 * 一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。
 * 账户本身可以以任意顺序返回。
 */
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

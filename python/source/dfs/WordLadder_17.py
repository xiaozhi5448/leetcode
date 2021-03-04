import collections


class Solution:

    def dfs(self, path, trans_dict, visited, endWord):
        beginWord = path[-1]
        if beginWord == endWord:
            self.res = path.copy()
            return
        next_words = []
        for i in range(len(beginWord)):
            key = beginWord[:i] + '*' + beginWord[i + 1:]
            next_words.extend(trans_dict[key])

        for next_word in next_words:
            if not visited[next_word]:
                visited[next_word] = True
                path.append(next_word)
                self.dfs(path, trans_dict, visited, endWord)
                path.pop(-1)
                visited[next_word] = False

    def findLadders(self, beginWord: str, endWord: str, wordList) :
        trans_dict = collections.defaultdict(list)
        visited = dict()
        self.res = []
        for word in wordList:
            visited[word] = False
            for i in range(len(word)):
                key = word[:i] + '*' + word[i + 1:]
                trans_dict[key].append(word)
        path = [beginWord]
        visited[beginWord] = True
        self.dfs(path, trans_dict, visited, endWord)
        return self.res

if __name__ == '__main__':
    so = Solution()
    tests = [{
        'begin':'hit', 'end': 'cog', 'words': ["hot","dot","dog","lot","log","cog"]
    }]
    res = so.findLadders(tests[0]['begin'], tests[0]['end'], tests[0]['words'])
    print(res)
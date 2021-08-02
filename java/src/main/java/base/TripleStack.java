package base;

public class TripleStack {
    int size;
    int stackSize;
    int[] nums;
    int[][] indexs;

    public TripleStack(int Size) {
        size = Size * 3;
        stackSize = Size;
        nums = new int[size];
        indexs = new int[3][2];
        for (int i = 0; i < 3; i++) {
            indexs[i][0] = indexs[i][1] = i * stackSize;
        }

    }

    public void push(int stackNum, int value) {
        if (indexs[stackNum][1] - indexs[stackNum][0] >= stackSize) {
            return;
        } else {
            nums[indexs[stackNum][1]] = value;
            indexs[stackNum][1]++;

        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        int res = nums[indexs[stackNum][1] - 1];
        indexs[stackNum][1] -= 1;
        return res;
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }
        return nums[indexs[stackNum][1] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return indexs[stackNum][0] == indexs[stackNum][1];
    }
}

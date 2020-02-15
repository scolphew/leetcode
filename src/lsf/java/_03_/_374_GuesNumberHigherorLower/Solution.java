package lsf.java._03_._374_GuesNumberHigherorLower;

public class Solution extends GuessGame {

    public Solution(int a) {
        super(a);
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int tmp = guess(mid);
            if (tmp == 0) {
                return mid;
            } else if (tmp == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        System.out.println(new Solution(1702766719).guessNumber(2126753390));
    }


}

class GuessGame {
    int a;

    public GuessGame(int a) {
        this.a = a;
    }

    int guess(int i) {
        return a == i ? 0 : i < a ? 1 : -1;
    }
}

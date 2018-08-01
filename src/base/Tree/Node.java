package base.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        return val + "";
    }

    public static Node example = new Node(
            1,
            Arrays.asList(
                    new Node(3, Arrays.asList(
                            new Node(5, new ArrayList<>()),
                            new Node(6, new ArrayList<>())
                    )),
                    new Node(2, new ArrayList<>()),
                    new Node(4, new ArrayList<>())
            )
    );
}

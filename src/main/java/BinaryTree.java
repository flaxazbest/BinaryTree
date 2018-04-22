import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTree {
    private Node root = null;
    private long n;

    public static void main(String[] args) {
        Node r = new Node(50);
        BinaryTree nbt = new BinaryTree(r);

        nbt.insert(new Node(60));
        System.out.println(nbt.ttoString());
    }

    public BinaryTree() {
        root = new Node();
        n = 1;
    }

    public BinaryTree(Node root) {

        this.root = root;
        n = 1;

    }
    private void exchange(Node a, Node b ){

        Node ta = a.clone();
        Node tb = b.clone();



        a.changeLeft(tb.getLeft());
        a.changeRight(tb.getRight());
        b.changeLeft(ta.getLeft());
        b.changeRight(ta.getRight());


        a.setParent(tb.getParent());
        b.setParent(ta.getParent());

    }
    private void swim(Node node){

        while (node.getParent()!=null && node.getTrans().compareTo( node.getParent().getTrans() ) > 0  ){

            exchange(node, node.getParent());
        }

    }
    public void insert(Node node) {
        long t = ++n;
        Node place = root;
        ArrayList<Long> chain = new ArrayList<>();

        if (t == 1) {
            chain.add(new Long(0));
        }

        while (t != 1) {
            chain.add(t % 2);
            t /= 2;
        }
        for(int i=chain.size()-1; i>0; i--)
        {
            if (chain.get(i) % 2 == 0)
                place = place.getLeft();
            else place = place.getRight();
        }

        if (chain.get(0) % 2 == 0) {
            place.setLeft(node);

        } else {
            place.setRight(node);
        }
        swim(node);
    }

//    @Override
    public String ttoString() {

        if (root == null) {
            return "Empty\n";
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<Node> queue = new LinkedList<>();
        int k = 1;
        int i = 0;

        queue.add(root);
        while (!queue.isEmpty()) {
            i++;
            Node t = queue.pop();
            sb.append(t.getTrans().getTime()).append('\t');
            if (t.isExistLeft()) queue.add(t.getLeft());
            if (t.isExistRight()) queue.add(t.getRight());
            if (i==k) {
                sb.append('\n');
                k *= 2;
                i = 0;
            }
        }

        return sb.toString();
    }
}

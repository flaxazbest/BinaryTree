public class Node {

    private TransAction trans;
    private Node left;
    private Node right;
    private Node parent;

    public void changeLeft(Node left) {
        this.left = left;
    }

    public void changeRight(Node right) {
        this.right = right;
    }

    public boolean isExistLeft(){
        return left != null;
    }

    public boolean isExistRight(){
        return right != null;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

    public Node(long n) {
        trans = new TransAction(n);
        left = null;
        right = null;
        parent = null;
    }

    public Node clone() {
        Node t = new Node(trans.getTime());
        t.setParent(parent);
        t.changeLeft(left);
        t.changeRight(right);
        return t;
    }

    public Node() {
        trans = new TransAction();
        left = null;
        right = null;
        parent = null;

    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public TransAction getTrans() {
        return trans;
    }

    public void setTrans(TransAction trans) {
        this.trans = trans;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
        left.setParent(this);
    }

    public Node getRight() {
        return right;

    }

    public void setRight(Node right) {
        this.right = right;
        right.setParent(this);
    }

    @Override
    public String toString() {
        return "Node{" +
                "trans=" + trans +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

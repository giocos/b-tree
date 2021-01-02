public class Node<T> {
    private T key;
    private Node<T> dx;
    private Node<T> sx;

    public Node(T key) {
        this.key = key;
        this.dx = null;
        this.sx = null;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getDx() {
        return dx;
    }

    public void setDx(Node<T> dx) {
        this.dx = dx;
    }

    public Node<T> getSx() {
        return sx;
    }

    public void setSx(Node<T> sx) {
        this.sx = sx;
    }
}

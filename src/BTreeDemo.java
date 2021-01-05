import java.util.TreeMap;

public class BTreeDemo {

    static void postOrder(final Node<Integer> node) {
        if (node == null) {
            return;
        }
        postOrder(node.getDx());
        postOrder(node.getSx());
        System.out.print(node.getKey() + " ");
    }

    static void preOrder(final Node<Integer> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getKey() + " ");
        preOrder(node.getSx());
        preOrder(node.getDx());
    }

    static void inOrder(final Node<Integer> node) {
        if (node == null) {
            return;
        }
        inOrder(node.getSx());
        System.out.print(node.getKey() + " ");
        inOrder(node.getDx());
    }

    static <T> boolean findElement(final T key, final Node<Integer> node) {
        if (node == null) {
            return false;
        }

        if (node.getKey() == key) {
            return true;
        }
        return findElement(key, node.getDx()) || findElement(key, node.getSx());
    }

    static int size(final Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return size(node.getDx()) + size(node.getSx()) + 1;
    }

    public static void main(String[] args) {
        // leafs
        final Node<Integer> leaf1 = new Node<>(14);
        final Node<Integer> leaf2 = new Node<>(13);
        final Node<Integer> leaf3 = new Node<>(11);
        final Node<Integer> leaf4 = new Node<>(10);
        final Node<Integer> leaf5 = new Node<>(9);
        final Node<Integer> leaf6 = new Node<>(8);

        // childs
        final Node<Integer> child1 = new Node<>(7);
        final Node<Integer> child2 = new Node<>(6);
        final Node<Integer> child3 = new Node<>(5);
        final Node<Integer> child4 = new Node<>(4);

        child1.setSx(leaf1);
        child2.setDx(leaf2);
        child3.setDx(leaf3);
        child3.setSx(leaf4);
        child4.setDx(leaf5);
        child4.setSx(leaf6);

        // parents
        final Node<Integer> parent1 = new Node<>(3);
        final Node<Integer> parent2 = new Node<>(2);

        parent1.setDx(child1);
        parent1.setSx(child2);
        parent2.setDx(child3);
        parent2.setSx(child4);

        // root
        final Node<Integer> root = new Node<>(1);
        root.setDx(parent1);
        root.setSx(parent2);

        System.out.print("inOrder: ");
        inOrder(root);
        System.out.print("\npreOrder: ");
        preOrder(root);
        System.out.print("\npostOrder: ");
        postOrder(root);
        // find by key
        final int key = 9;
        System.out.println("\nKey " +  key + " is" + (findElement(key, root) ? " " : " NOT ") + "present");
        // tree size
        System.out.println("BTree size: " + size(root));
    }
}

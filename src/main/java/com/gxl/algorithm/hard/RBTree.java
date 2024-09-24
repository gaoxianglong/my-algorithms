package com.gxl.algorithm.hard;

import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 红黑树
 *
 * @author gxl
 * @version Id: 1.0.0
 * @since 2023/11/23 18:51
 */
public class RBTree {
    enum Color {
                RED, BLACK;
    }

    class Node {
        int   key, value;
        Node  parent, left, right;
        Color color = Color.RED;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", value=" + value + ", parent=" + (Objects.nonNull(parent) ? parent.key : null) + ", left=" + (Objects.nonNull(left) ? left.key : null)
                   + ", right=" + (Objects.nonNull(right) ? right.key : null) + ", color=" + color + '}';
        }
    }

    Node root;

    void insert(int key, int value) {
        var n = new Node(key, value);
        if (Objects.isNull(root)) {
            root = n;
        } else {
            insert(root, null, n);
        }
        i_fixup(n);
    }

    void insert(Node n1, Node n2, Node n3) {
        if (Objects.isNull(n1)) {
            if (n3.key < n2.key) {
                n2.left = n3;
            } else {
                n2.right = n3;
            }
            n3.parent = n2;
            return;
        }
        insert(n3.key < n1.key ? n1.left : n1.right, n1, n3);
    }

    void i_fixup(Node n) {
        if (root == n) {
            root.color = Color.BLACK;
            return;
        }
        if (Objects.isNull(n) || n.parent.color == Color.BLACK) {
            return;
        }
        var parent = n.parent;
        var gand = parent.parent;
        if (gand.left == parent) {
            var uncle = gand.right;
            if (Objects.nonNull(uncle) && uncle.color == Color.RED) {
                gand.color = Color.RED;
                parent.color = Color.BLACK;
                uncle.color = Color.BLACK;
                i_fixup(gand);
            } else {
                if (parent.left == n) {
                    gand.color = Color.RED;
                    parent.color = Color.BLACK;
                    rightRotate(gand);
                } else {
                    leftRotate(parent);
                    i_fixup(parent);
                }
            }
        } else {
            var uncle = gand.left;
            if (Objects.nonNull(uncle) && uncle.color == Color.RED) {
                gand.color = Color.RED;
                parent.color = Color.BLACK;
                uncle.color = Color.BLACK;
                i_fixup(gand);
            } else {
                if (parent.right == n) {
                    gand.color = Color.RED;
                    parent.color = Color.BLACK;
                    leftRotate(gand);
                } else {
                    rightRotate(parent);
                    i_fixup(parent);
                }
            }
        }
    }

    void rightRotate(Node n) {
        var left = n.left;
        n.left = left.right;
        if (Objects.nonNull(left.right)) {
            left.right.parent = n;
        }
        left.right = n;
        reset(left, n);
    }

    void leftRotate(Node n) {
        var right = n.right;
        n.right = right.left;
        if (Objects.nonNull(right.left)) {
            right.left.parent = n;
        }
        right.left = n;
        reset(right, n);
    }

    void reset(Node n1, Node n2) {
        if (root == n2) {
            root = n1;
        } else if (n2.parent.left == n2) {
            n2.parent.left = n1;
        } else {
            n2.parent.right = n1;
        }
        n1.parent = n2.parent;
        n2.parent = n1;
    }

    Integer getMin() {
        return getMin(root);
    }

    Integer getMin(Node n) {
        if (Objects.nonNull(n)) {
            var rlt = getMin(n.left);
            return Objects.nonNull(rlt) ? rlt : n.key;
        }
        return null;
    }

    Integer getMax() {
        return getMax(root);
    }

    Integer getMax(Node n) {
        if (Objects.nonNull(n)) {
            var rlt = getMax(n.right);
            return Objects.nonNull(rlt) ? rlt : n.key;
        }
        return null;
    }

    int getSize() {
        return getSize(root);
    }

    int getSize(Node n) {
        if (Objects.nonNull(n)) {
            return 1 + getSize(n.left) + getSize(n.right);
        }
        return 0;
    }

    int getHeight() {
        return getHeight(root);
    }

    int getHeight(Node n) {
        if (Objects.nonNull(n)) {
            return 1 + Math.max(getHeight(n.left), getHeight(n.right));
        }
        return 0;
    }

    int getBlackSize() {
        return getBlackSize(root);
    }

    int getBlackSize(Node n) {
        if (Objects.nonNull(n)) {
            return (n.color == Color.BLACK ? 1 : 0) + getBlackSize(n.left) + getBlackSize(n.right);
        }
        return 0;
    }

    void getBlackHeight() {
        var paths = new ArrayList<String>();
        getBlackHeight(root, null, "", paths, 0);
        paths.forEach(System.out::println);
        System.out.println();
    }

    void getBlackHeight(Node n1, Node n2, String path, List<String> paths, int size) {
        if (Objects.nonNull(n1)) {
            path = String.format("%s%s(%s)->", path, n1.key, n1.color);
            getBlackHeight(n1.left, n1, path, paths, n1.color == Color.BLACK ? 1 + size : size);
            getBlackHeight(n1.right, n1, path, paths, n1.color == Color.BLACK ? 1 + size : size);
            return;
        }
        if (Objects.isNull(n2.left) && Objects.isNull(n2.right)) {
            path = path.substring(0, path.lastIndexOf("->"));
            path = String.format("%s,size:%s", path, size);
            if (!paths.contains(path)) {
                paths.add(path);
            }
        }
    }

    void inOrder() {
        inOrder(root);
        System.out.println();
    }

    void inOrder(Node n) {
        if (Objects.isNull(n)) {
            return;
        }
        inOrder(n.left);
        System.out.println(n);
        inOrder(n.right);
    }

    Node getNode(int key) {
        if (Objects.nonNull(root)) {
            return key == root.key ? root : getNode(key, root);
        }
        return null;
    }

    Node getNode(int key, Node n) {
        if (Objects.nonNull(n)) {
            if (key == n.key) {
                return n;
            }
            return getNode(key, key < n.key ? n.left : n.right);
        }
        return null;
    }

    Node getSucceedNode(int key) {
        var n = getNode(key);
        if (Objects.nonNull(n)) {
            return getSucceedNode(n.left);
        }
        return null;
    }

    Node getSucceedNode(Node n) {
        if (Objects.nonNull(n)) {
            var sn = getSucceedNode(n.right);
            return Objects.nonNull(sn) ? sn : n;
        }
        return null;
    }

    boolean delete(int key) {
        var n = getNode(key);
        if (Objects.nonNull(n)) {
            delete(n);
            return true;
        }
        return false;
    }

    void delete(Node n) {
        Node n1 = null, n2 = null;
        if (Objects.nonNull(n.left) && Objects.nonNull(n.right)) {
            var sn = getSucceedNode(n.key);
            n.key = sn.key;
            n.value = sn.value;
            n.left.parent = n;
            n.right.parent = n;
            delete(sn);
            return;
        }
        if (Objects.isNull(n.parent)) {
            root = Objects.nonNull(n.left) ? n.left : n.right;
            if (Objects.nonNull(root.parent)) {
                root.parent = null;
            }
            n1 = root;
        } else {
            var cn = Objects.nonNull(n.left) ? n.left : n.right;
            if (n.parent.left == n) {
                n.parent.left = cn;
            } else {
                n.parent.right = cn;
            }
            if (Objects.nonNull(cn)) {
                cn.parent = n.parent;
            }
            n1 = cn;
            n2 = n.parent;
        }
        if (n.color == Color.BLACK) {
            d_fixup(n1, n2);
        }
    }

    void d_fixup(Node n1, Node n2) {
        Node bro = null;
        while ((Objects.isNull(n1) || n1.color == Color.BLACK) && root != n1) {
            if (n2.left == n1) {
                bro = n2.right;
                if (Objects.nonNull(bro) && bro.color == Color.RED) {
                    n2.color = Color.RED;
                    bro.color = Color.BLACK;
                    leftRotate(n2);
                    bro = n2.right;
                }
                if ((Objects.isNull(bro.left) || bro.left.color == Color.BLACK) && (Objects.isNull(bro.right) || bro.right.color == Color.BLACK)) {
                    if (n2.color == Color.RED) {
                        n2.color = Color.BLACK;
                        bro.color = Color.RED;
                        break;
                    } else {
                        bro.color = Color.RED;
                        n1 = n2;
                        n2 = n1.parent;
                    }
                } else {
                    if (Objects.nonNull(bro.left) && bro.left.color == Color.RED) {
                        bro.left.color = n2.color;
                        n2.color = Color.BLACK;
                        rightRotate(bro);
                        leftRotate(n2);
                    } else {
                        bro.color = n2.color;
                        n2.color = Color.BLACK;
                        bro.right.color = Color.BLACK;
                        leftRotate(n2);
                    }
                    break;
                }
            } else {
                bro = n2.left;
                if (Objects.nonNull(bro) && bro.color == Color.RED) {
                    n2.color = Color.RED;
                    bro.color = Color.BLACK;
                    rightRotate(n2);
                    bro = n2.left;
                }
                if ((Objects.isNull(bro.left) || bro.left.color == Color.BLACK) && (Objects.isNull(bro.right) || bro.right.color == Color.BLACK)) {
                    if (n2.color == Color.RED) {
                        n2.color = Color.BLACK;
                        bro.color = Color.RED;
                        break;
                    } else {
                        bro.color = Color.RED;
                        n1 = n2;
                        n2 = n1.parent;
                    }
                } else {
                    if (Objects.nonNull(bro.right) && bro.right.color == Color.RED) {
                        bro.right.color = n2.color;
                        n2.color = Color.BLACK;
                        leftRotate(bro);
                        rightRotate(n2);
                    } else {
                        bro.color = n2.color;
                        n2.color = Color.BLACK;
                        bro.left.color = Color.BLACK;
                        rightRotate(n2);
                    }
                    break;
                }
            }
        }
        if (Objects.nonNull(n1)) {
            n1.color = Color.BLACK;
        }
    }

    boolean isValidBST() {
        if (Objects.isNull(root)) {
            return false;
        }
        var list = new ArrayList<Integer>();
        inOrder(root, list);
        int i = 0, j = 1, n = list.size();
        for (; j < n; i++, j++) {
            if (list.get(i) >= list.get(j)) {
                return false;
            }
        }
        return true;
    }

    void inOrder(Node n, List<Integer> list) {
        if (Objects.isNull(n)) {
            return;
        }
        inOrder(n.left, list);
        list.add(n.key);
        inOrder(n.right, list);
    }

    void clear() {
        if (Objects.isNull(root)) {
            return;
        }
        root = null;
    }

    public static void main(String[] agrs) {
        var tree = new RBTree();
        Arrays.asList(200, 100, 300, 250, 400, 350).forEach(x -> tree.insert(x, x));
        tree.inOrder();
        tree.getBlackHeight();
        Assert.assertEquals(4, tree.getBlackSize());
        Assert.assertEquals(6, tree.getSize());
        Assert.assertEquals(100, tree.getMin().intValue());
        Assert.assertEquals(400, tree.getMax().intValue());
        Assert.assertEquals(4, tree.getHeight());
        Assert.assertFalse(tree.delete(500));
        Assert.assertTrue(tree.delete(100));
        Assert.assertEquals(300, tree.root.key);
        Assert.assertEquals(200, tree.getMin().intValue());
        Assert.assertEquals(3, tree.getHeight());
        Assert.assertTrue(tree.delete(250));
        Assert.assertTrue(tree.delete(300));
        Assert.assertTrue(tree.delete(200));
        Assert.assertEquals(2, tree.getHeight());
        Assert.assertEquals(Color.RED, tree.root.right.color);
        Assert.assertEquals(1, tree.getBlackSize());
        Assert.assertEquals(true, tree.isValidBST());

        tree.clear();
        Arrays.asList(200, 100, 400, 250, 500).forEach(x -> tree.insert(x, x));
        Assert.assertEquals(3, tree.getBlackSize());
        tree.inOrder();
        tree.getBlackHeight();
        Assert.assertEquals(250, tree.getSucceedNode(400).key);
        Assert.assertTrue(tree.delete(250));
        Assert.assertTrue(tree.delete(500));
        tree.inOrder();
        Assert.assertEquals(2, tree.getHeight());
        Assert.assertTrue(tree.delete(400));
        Assert.assertEquals(2, tree.getSize());
        Assert.assertEquals(1, tree.getBlackSize());
        tree.inOrder();
        tree.getBlackHeight();
        Assert.assertEquals(true, tree.isValidBST());

        tree.clear();
        Arrays.asList(200, 500, 300, 120, 250, 400, 350).forEach(x -> tree.insert(x, x));
        tree.delete(300);
        tree.delete(250);
        tree.insert(1, 1);
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.getBlackHeight();
        Assert.assertEquals(200, tree.root.key);
        Assert.assertEquals(10, tree.root.left.key);
        Assert.assertEquals(Color.RED, tree.root.left.color);
        Assert.assertEquals(1, tree.root.left.left.key);
        Assert.assertEquals(Color.BLACK, tree.root.left.left.color);
        Assert.assertEquals(120, tree.root.left.right.key);
        Assert.assertEquals(Color.BLACK, tree.root.left.right.color);
        Assert.assertEquals(10, tree.root.left.right.parent.key);
        Assert.assertEquals(15, tree.root.left.right.left.key);
        Assert.assertEquals(Color.RED, tree.root.left.right.left.color);

        Assert.assertEquals(400, tree.root.right.key);
        Assert.assertEquals(Color.BLACK, tree.root.right.color);
        Assert.assertEquals(350, tree.root.right.left.key);
        Assert.assertEquals(Color.RED, tree.root.right.left.color);
        Assert.assertEquals(500, tree.root.right.right.key);
        Assert.assertEquals(Color.RED, tree.root.right.right.color);
    }
}

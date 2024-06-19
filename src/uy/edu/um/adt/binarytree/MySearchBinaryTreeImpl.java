
package uy.edu.um.adt.binarytree;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

public class MySearchBinaryTreeImpl<K extends Comparable<K>, V> implements
        MySearchBinaryTree<K, V> {

    private TreeNode<K, V> root;

    @Override
    public void add(K key, V value) {
        TreeNode<K, V> elementToAdd = new TreeNode<K,V>(key, value);

        if (root == null) {

            root = elementToAdd;

        } else {

            root.add(key, value);

        }
    }

    public V find(K key) {
        return find(key, root);
    }

    private V find(K keyToSearch, TreeNode<K, V> root) {
        V value = null;

        if (root != null) {

            int nValue = keyToSearch.compareTo(root.getKey());

            if (nValue == 0) {

                value = root.getValue();

            } else if (nValue > 0) {

                value = find(keyToSearch, root.getRight());

            } else {

                value = find(keyToSearch, root.getLeft());

            }

        }

        return value;
    }

    public boolean contains(K key) {
        return contains(key, root);
    }

    private boolean contains(K keyToSearch, TreeNode<K, V> root) {
        boolean contains = false;

        if (root != null) {

            int nValue = keyToSearch.compareTo(root.getKey());

            if (nValue == 0) {

                contains = true;

            } else if (nValue > 0) {

                contains = contains(keyToSearch, root.getRight());

            } else {

                contains = contains(keyToSearch, root.getLeft());

            }

        }

        return contains;
    }


    @Override
    public void remove(K key) {

        if (root != null) {

            root = root.remove(key);

        }

    }

    @Override
    public MyList<K> inOrder() {
        MyList<K> inOrderTraverse = new MyLinkedListImpl<>();

        if (root != null) {

            root.inOrderTraverse(inOrderTraverse);

        }

        return inOrderTraverse;
    }
    @Override
    public MySearchBinaryTree<K, V> parseLinkedListToTree(MyList<K> linkedList, MyList<V> linkedList2) {
        MySearchBinaryTree searchBinaryTree = new MySearchBinaryTreeImpl();
        for (int i=0; i<linkedList.size(); i++) {
            searchBinaryTree.add(linkedList.get(i), linkedList2.get(i));
        }
        return searchBinaryTree;
    }
    public K getsmallestkey(){
        for(TreeNode<K, V> current = this.root; current != null; current = current.getLeft()){
            if(current.getLeft() == null){
                return current.getKey();
            }
        }
        return this.root.getKey();
    }
    public TreeNode<K, V> getleft(K  key){
        TreeNode<K, V> current = this.root;
        while(current != null){
            int nValue = key.compareTo(current.getKey());
            if(nValue == 0){
                return current.getLeft();
            }else if(nValue > 0){
                current = current.getRight();
            }else{
                current = current.getLeft();
            }
        }
        return null;
    }
    public TreeNode<K, V> getleftofnode(TreeNode<K, V> node){
        return node.getLeft();
    }
}

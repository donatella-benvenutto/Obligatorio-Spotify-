
package uy.edu.um.adt.binarytree;

import uy.edu.um.adt.linkedlist.MyList;

public interface MySearchBinaryTree<K extends Comparable<K>, V> {

	void add(K key, V value);

	void remove(K key);

	boolean contains(K key);

	V find(K key);

	MyList<K> inOrder();

	MySearchBinaryTree<K, V> parseLinkedListToTree(MyList<K> linkedList2,MyList<V> linkedList);

	K getsmallestkey();

	TreeNode<K, V> getleft(K key);
	//K getKeyofNode(TreeNode<K, V> node);

	TreeNode<K, V> getleftofnode(TreeNode<K, V> node);
	TreeNode<K, V> findNode(K key);
	MyList<TreeNode<K, V>> findNodesByDate(K dateKey);
	MyList<TreeNode<K, V>> findNodesByDateRange(K startDate, K endDate);
}
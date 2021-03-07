package com.graphs;

public class BinaryTreeInorderPostOrderConstruction {


	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	class Solution {

		int po=0;

		public TreeNode buildTree(int[] inorder, int[] postorder) {

			po = postorder.length-1;
			int io = inorder.length-1;   

			return buildTree(inorder, 0, io, postorder);

		}

		private TreeNode buildTree(int[] inorder, int start, int end, int[] postorder){

			if(start > end || start < 0)
				return null;

			TreeNode node = new TreeNode(postorder[po]); //just add postorder last element and check if that value is present in inorder, once found then recru for both left and right subtree

			po--;

			int index=0;

			for(int i=start; i<=end; i++){
				if(inorder[i]==node.val){
					index=i; //once the root value from post order is found in inorder then break
					break;
				}
			}

			//first recur for right subtree., then only recur for left subtree
			node.right = buildTree(inorder, index+1, end, postorder);
			node.left = buildTree(inorder, start, index-1, postorder);



			return node;


		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

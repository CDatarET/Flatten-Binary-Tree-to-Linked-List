# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def preorder(self, root, arr):
        if not root:
            return
        
        arr.append(root.val)
        self.preorder(root.left, arr)
        self.preorder(root.right, arr)

    def flatten(self, root):
        if not root:
            return
        
        arr = []
        self.preorder(root, arr)
        root.left = None
        root.right = None
        current = root
        for n in arr[1:len(arr)]:
            t = TreeNode(n, None, None)
            current.right = t
            current = current.right

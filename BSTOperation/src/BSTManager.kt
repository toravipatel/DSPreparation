import org.w3c.dom.Node
import java.util.*

class BSTManager {

    var root: TreeNode? = null

    //Function to perform inorder traversal . Iterative Way.
    fun inOrderTraversalIterative(root: TreeNode?) {

        if (root == null)
            return
        var current = root
        var nodeStack = Stack<TreeNode>()
        while (current != null || nodeStack.size > 0) {
            while (current != null) {
                nodeStack.push(current)
                current = current!!.left
            }
            val topElement = nodeStack.pop()
            current = topElement.right
            print("${topElement.`val`} + ->")
        }
    }

    //Function to perform pre order traversal . Iterative Way.
    fun preOrderTraversalIterative(root: TreeNode?) {

        if (root == null)
            return
        var current = root
        var nodeStack = Stack<TreeNode>()
        while (current != null || nodeStack.size > 0) {

            print("${current!!.`val`} + ->")

            //while (current != null){
            current!!.right?.let { nodeStack.push(it) }
            current!!.left?.let { nodeStack.push(it) }
            //current = current!!.left
            //}
            if (nodeStack.isEmpty())
                return
            val topElement = nodeStack.pop()
            current = topElement
            //print("${topElement.`val`} + ->")
        }
    }

    //Function to perform post order traversal . Iterative Way. Using 2 stack
    fun postOrderTraversalIterative(root: TreeNode?) {

        if (root == null)
            return
        var current = root
        var nodeStack = Stack<TreeNode>()
        var finalStack = Stack<TreeNode>()
        nodeStack.push(current)
        while (nodeStack.size > 0) {
            val topElement = nodeStack.pop()
            finalStack.push(topElement)
            topElement!!.left?.let { nodeStack.push(it) }
            topElement!!.right?.let { nodeStack.push(it) }

        }

        while (!finalStack.isEmpty()) {
            print("${finalStack.pop().`val`} + ->")
        }
    }

    //Function to perform inorder traversal . Recursive way.
    fun inOrderTraversal(node: TreeNode?) {
        if (node == null)
            return
        inOrderTraversal(node!!.left)
        print("${node.`val`} + ->")
        inOrderTraversal(node!!.right)
    }

    //Function to perform pre order traversal . Recursive way.
    fun preOrderTraversal(node: TreeNode?) {
        if (node == null)
            return
        print("${node.`val`} + ->")
        preOrderTraversal(node!!.left)
        preOrderTraversal(node!!.right)
    }

    //Function to perform  postOrder traversal . Recursive way.
    fun postOrderTraversal(node: TreeNode?) {
        if (node == null)
            return
        postOrderTraversal(node!!.left)
        postOrderTraversal(node!!.right)
        print("${node.`val`} + ->")

    }

    // function to check if not exists or not
    fun isNodeExists(node: TreeNode?, data: Int): Boolean {
        if (node == null)
            return false
        if (node!!.`val` == data)
            return true
        return if (node!!.`val` > data) {
            isNodeExists(node!!.left, data)
        } else {
            isNodeExists(node!!.right, data)
        }
    }

    //function to find inorder successor
    fun getInOrderSuccessor(node: TreeNode?, mNode: TreeNode?): TreeNode? {


        if (mNode!!.right != null) {
            var current = mNode!!.right
            while (current!!.left != null) {
                current = current!!.left
            }
            return current
        }


        var current = node
        var nodeStack = Stack<TreeNode>()
        var previousValue = Int.MAX_VALUE
        while (current != null || nodeStack.size > 0) {
            while (current != null) {
                nodeStack.push(current)
                current = current!!.left
            }
            val topElement = nodeStack.pop()
            if (previousValue == mNode!!.`val`)
                return topElement

            previousValue = topElement.`val`

            current = topElement.right
            print("${topElement.`val`} + ->")
        }
        return null

    }

}

fun main() {
    var bstManager = BSTManager()
    bstManager.root = TreeNode(10)
    bstManager.root!!.left = TreeNode(6)
    bstManager.root!!.left!!.left = TreeNode(4)
    bstManager.root!!.left!!.right = TreeNode(7)
    bstManager.root!!.right = TreeNode(14)
    bstManager.root!!.right!!.right = TreeNode(20)
    bstManager.root!!.right!!.left = TreeNode(12)

    println("node exist ${bstManager.isNodeExists(bstManager.root, 7)}")
    println("Inorder Traversal--------------------------------------------")
    bstManager.inOrderTraversal(bstManager.root)
    println("--------------------------------------------")
    bstManager.inOrderTraversalIterative(bstManager.root)
    println("\nPreorder Traversal--------------------------------------------")

    bstManager.preOrderTraversal(bstManager.root)
    println("\n--------------------------------------------")
    bstManager.preOrderTraversalIterative(bstManager.root)

    println("\nPostOrder Traversal--------------------------------------------")
    bstManager.postOrderTraversal(bstManager.root)
    println("\n")
    bstManager.postOrderTraversalIterative(bstManager.root)


    println("------------------")
    println("inOrderSuccessor for ${bstManager.root!!.left!!.right!!.`val`} is ${bstManager.getInOrderSuccessor(bstManager.root, bstManager.root!!.left!!.right)!!.`val`}")


}
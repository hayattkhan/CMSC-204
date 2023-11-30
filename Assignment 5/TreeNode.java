/**
 * 
 * @author hayatullahkhan
 *
 * @param <T>
 */

public class TreeNode <T> 
{
	public T data;
	public TreeNode<T> left, right;
	
	public TreeNode(T dataNode)
	{
		this.data = dataNode;
		this.left = null;
		this.right = null;
	}
	
	public TreeNode(TreeNode<T> node)
	{
		this.data = node.data;
		this.left = node.left;
		this.right = node.right;
	}
	
	public T getData()
	{
		return this.data;
	}

}

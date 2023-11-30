/**
 * @author hayatullahkhan
 */

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>
{
	private TreeNode<String> mctRoot;
	
	public MorseCodeTree()
	{
		mctRoot = new TreeNode<String>("");
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() 
	{
		return mctRoot;
	}


	@Override
	public void setRoot(TreeNode<String> newNode) 
	{
		mctRoot = newNode;
	}
	

	@Override
	public String fetch(String code) 
	{
		try 
		{
			return fetchNode(mctRoot, code);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String fetchNode(TreeNode<String> root, String code)
	{
		if (code.length() < 1)
		{
			return " ";
		}
		
		if (code.length() == 1)
		{
			if (code.equals("."))
			{
				return root.left.getData();
			}
			else if(code.equals("-"))
			{
				return root.right.getData();
			}
		}

		//recursion
		if (code.charAt(0) == '.')
		{
			return fetchNode(root.left, code.substring(1));
		}
		else
		{
			return fetchNode(root.right, code.substring(1));
		}
	}

	@Override
	public void buildTree() 
	{
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h"); 
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	@Override
	public void insert(String code, String result) 
	{
		if(mctRoot == null)
		{
			TreeNode<String> insertion = new TreeNode<>("");
			mctRoot = insertion;
		}

		addNode(mctRoot, code, result);
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
	{
		if(code.charAt(0) == '.')
		{
			if(root.left == null)
			{
				TreeNode<String> firstTestNode = new TreeNode<String>(letter);
				root.left = firstTestNode;
			}
			else 
			{
				addNode(root.left, code.substring(1), letter);
			}
		}
		
		if(code.charAt(0) == '-')
		{
			if(root.right == null)
			{
				TreeNode<String> secondTestNode = new TreeNode<String>(letter);
				root.right = secondTestNode;
			}
			else
			{
				addNode(root.right, code.substring(1), letter);
			}
		}
	}
	
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) 
	{
		if (root.left == null)
		{
			list.add(root.getData());
			return;
		}
		
		//recursion
		LNRoutputTraversal(root.left, list);
		list.add(root.getData());
		if(!(root.right == null))
		{
			LNRoutputTraversal(root.right, list);
		}
	}
	
	@Override
	public ArrayList<String> toArrayList() 
	{
		ArrayList<String> arrayToReturn = new ArrayList<String>();
		LNRoutputTraversal(mctRoot, arrayToReturn);
		
		return arrayToReturn;
	}
	
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException 
	{
		throw new UnsupportedOperationException();
	}
}

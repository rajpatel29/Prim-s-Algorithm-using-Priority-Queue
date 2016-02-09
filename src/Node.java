
public class Node 
{
	public int node_No;
	public int priority;
	public String path;
	
	public Node(int node , int  weight ) 
	{
		node_No = node;
		priority = weight;
	}
	
	public Node(int node , int  weight  , String path) 
	{
		node_No = node;
		priority = weight;
		this.path = path;
	}
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getNode_No() 
	{
		return node_No;
	}
	
	public void setNode_No(int node_No) 
	{
		this.node_No = node_No;
	}
	
	public int getpriority() 
	{
		return priority;
	}
	
	public void setpriority(int priority) 
	{
		this.priority = priority;
	}
	
}

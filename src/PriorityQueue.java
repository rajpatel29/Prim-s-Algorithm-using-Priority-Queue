
public class PriorityQueue 
{
	int number_Of_Nodes;
	Node nodes[] ;
	static int index = 0;
	
	int node_index[];
	
	
	public PriorityQueue(int n) 
	{
		number_Of_Nodes = n;
		nodes  = new Node[number_Of_Nodes];
		node_index = new int[number_Of_Nodes];
	}
	
	public void showList()
	{
		for (int i = 0; i < index ; i++)
		{
//			if(nodes[i] == null)
//			{
//				break;
//			}		
			Node tmp =  nodes[i];
			System.out.print("(" + tmp.node_No + " , " + tmp.priority +  " )" +  "   : "  );			
		}
		
		
		System.out.println("Node Index:");
		for (int i = 0; i < number_Of_Nodes; i++) 
		{
			System.out.println("(" + i + " , " + node_index[i] + ")");
		}
		
		System.out.println("index : " + index);
	}


	public void  offer(Node n)
	{
		nodes[index] = n;
		node_index[n.node_No] =index;
		index++;
		
		int childIndex = index - 1;
		
		Node parent,child;
		while(childIndex != 0)
		{
			int parentIndex = (childIndex  - 1 )/2;
			
			parent = nodes[parentIndex];
			child  = nodes[childIndex];
			
			if(child.priority < parent.priority)
			{
				nodes[childIndex] = parent;
				nodes[parentIndex] = child;
				
				node_index[parent.node_No]= childIndex;
				node_index[child.node_No] = parentIndex;
				
			}
			else
			{
				break;
			}
			
			childIndex = parentIndex;
		}
	}

	
	public Node poll()
	{
		Node out = null;
		
		if(index == 1)
		{
			node_index[nodes[0].node_No] = -1; 
			
			out = nodes[0];
			index--;
			return out;
		}
		
		node_index[nodes[0].node_No] = -1; 
		out = nodes[0];
		
		
		int lastIndex = index - 1;
		Node last = nodes[lastIndex];
		index--;
		node_index[last.node_No] = 0;
		
		nodes[0] = last;
		
		int parentIndex = 0;
		
		while(true)
		{
			Node smallest , parent , child_1 , child_2;
			int child_1_Index, child_2_Index , smallestIndex ;
			
			
			child_1_Index = parentIndex * 2 + 1; 
			child_2_Index = parentIndex * 2 + 2;
			
			if(child_1_Index > index - 1)
			{
				break;
			}
			
			parent = nodes[parentIndex];
			child_1 = nodes[child_1_Index];
			
			if(child_2_Index > index - 1)
			{
				smallest = child_1;
				smallestIndex = child_1_Index ;
			}
			else
			{
				child_2 = nodes[child_2_Index];
				
				if(child_1.priority < child_2.priority)
				{
					smallest = child_1;
					smallestIndex = child_1_Index ;
				}
				else
				{
					smallest = child_2;
					smallestIndex = child_2_Index ;
				}
			}
			
			if(smallest.priority < parent.priority)
			{
				nodes[parentIndex] = smallest;
				nodes[smallestIndex] = parent;
				
				node_index[smallest.node_No] = parentIndex;
				node_index[parent.node_No] = smallestIndex;
				
			}
			else
			{
				break;
			}
			
			
			parentIndex = smallestIndex;
		}
		
		return out;
	}
	
	
	public void Update(Node n)
	{
		int ind = node_index[n.node_No];
		
		nodes[ind] = n;
		
		int childIndex = ind;
		
		Node parent,child;
		while(childIndex != 0)
		{
			int parentIndex = (childIndex  - 1 )/2;
			parent = nodes[parentIndex];
			child = nodes[childIndex];
			
			if(child.priority < parent.priority)
			{
				nodes[childIndex] = parent;
				nodes[parentIndex] = child;
				
				node_index[parent.node_No]= childIndex;
				node_index[child.node_No] = parentIndex;
				
			}
			else
			{
				break;
			}
			
			childIndex = parentIndex; 
		}
	}
	
	public int getPriority(int i)
	{
		int ind = node_index[i];
		Node node = nodes[ind];
		return node.priority;
	}
	
	
	
//	public void add(Node x)
//	{	
//		nodes[index] = x;
//		index++;
//	}

}

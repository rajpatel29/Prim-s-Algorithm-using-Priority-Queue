import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MainClass 
{
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		final int NO_OF_NODES = Integer.parseInt(br.readLine());
		
		String line;
		int node1;
		int node2;
		int weight;
		
		ArrayList<ArrayList<Integer>> neighbours = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < NO_OF_NODES; i++) 
		{
			neighbours.add(new ArrayList<Integer>());
		}
		
		while((line = br.readLine()) != null)
		{
			StringTokenizer tokenizer = new StringTokenizer(line);
		
			node1 = Integer.parseInt(tokenizer.nextToken());
			node2 = Integer.parseInt(tokenizer.nextToken());
			weight = Integer.parseInt(tokenizer.nextToken());
			
			neighbours.get(node1).add(node2);
			neighbours.get(node1).add(weight);
			
			neighbours.get(node2).add(node1);
			neighbours.get(node2).add(weight);
		}
		
		
		PriorityQueue queue = new PriorityQueue(NO_OF_NODES);
		Set<Integer> explored = new HashSet<>();
		Set<Integer> unExplored = new HashSet<>();

		
		
		//Initialize an empty Priority queue
		for (int i = 0; i < NO_OF_NODES; i++) 
		{
			unExplored.add(i);
			
			if(i == 0)
			{
				queue.offer(new Node(i, 0));
				continue;
			}
			
			queue.offer(new Node(i, 100000));
			
		}
	
		int sum = 0;
		
		long startTime = System.currentTimeMillis();	
		while(!unExplored.isEmpty())
		{
			Node min = queue.poll();
			
			
			explored.add(min.node_No);
			unExplored.remove(min.node_No);
			
			for (int i = 0; i < neighbours.get(min.node_No).size() ; i = i+ 2)
			{
				int nei = neighbours.get(min.node_No).get(i);
				int wei = neighbours.get(min.node_No).get(i+1);
				if(unExplored.contains(nei)   &&   wei < queue.getPriority(nei))
				{
					String str = min.node_No + " - " + nei; 
					queue.Update(new Node(nei, wei, str));
				}
			}
			
			System.out.println();
			sum = sum + min.priority;
			
			if(min.node_No == 0)
			{
				
			}
			else
			{
				System.out.println("Node number: " + min.node_No + "   weight: "  + min.priority + " edge: " + min.path);
			}
		}
		long endTime = System.currentTimeMillis();
		
		System.out.println();
		System.out.println("MST " + sum);
		System.out.println(endTime - startTime);

		
	}

	
}

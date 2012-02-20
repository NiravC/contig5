import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;



public class Cache {

	HashMap <Integer, Integer> idPositionMap;
	ByteBuffer edgeList;
	
	ByteArrayOutputStream b;
	
	public Cache(){
		b= new ByteArrayOutputStream();
		idPositionMap = new HashMap();
	}
	
	public void assignNeighbour(int parentID, Set <Integer>childrenID) throws IOException{
		
		int childrenNumber = childrenID.size();

		int currentPosition = b.size();
		
		idPositionMap.put(parentID, currentPosition);
		
		ByteBuffer tmp = ByteBuffer.allocate(4);
		tmp.putInt(childrenNumber);
		
		
		b.write(tmp.array());
		
		Iterator <Integer>it = childrenID.iterator();
		while(it.hasNext()){
			int child = it.next();

			tmp = ByteBuffer.allocate(4);
			tmp.putInt(child);
			b.write(tmp.array());
		}
		childrenID= null;									//very important remove entry from original vector once it has been copied into 'edgeList'
	}
 

	
	public Vector getNeighbours(int id){
		
		int position = idPositionMap.get(id);
		edgeList.position(position);
		
		int childrenNumber = edgeList.getInt();

		Vector children = new Vector(childrenNumber);
		
		while((edgeList.position()-(position+4))/4 < childrenNumber)
			children.add(edgeList.getInt());
		
		return children;
	}
	
	public int getNeighboursNum(int id){
		int position = idPositionMap.get(id);

		edgeList.position(position);
		
		return edgeList.getInt();
	}
	
	public void commit(){
		edgeList = ByteBuffer.wrap(b.toByteArray());

	}
}

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;


public class main {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub

		
		


		Fetcher f = new Fetcher ();


		
		

		
		
		System.out.println("Running BFS...");
		
		long startTime = System.nanoTime();		
		
		int end = f.BFS(0, 6321440);

		long stopTime = System.nanoTime();
		long duration = stopTime - startTime;
		
		System.out.println("BFS duration: "+duration);
		System.out.println("BFS layout overhead: "+f.dur+". Misses: "+f.count);
		System.out.println("visited: "+end);
		int num = f.c.edgeList.capacity()/28;
		System.out.println("Buffer size: "+f.c.edgeList.capacity()+" -> "+num+" nodes");
	}

}

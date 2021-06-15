package tar2;

import java.io.File;
import java.io.FileNotFoundException;

public class Main extends Exception {

	public static void main( String[] args )
	{
	 JsonBuilder avraham = null;
	 try
	 {
	 avraham = new JsonBuilder( new File( args[0] ));
	 System.out.println( avraham );
	System.out.println(avraham.get( "issue" ).get("Ketura").get(2));
	 }
	 catch( JsonQueryException e )
	 {
	 e.printStackTrace();
	 }
	 catch (FileNotFoundException e)
	 {
	 e.printStackTrace();
	 }
	}

}

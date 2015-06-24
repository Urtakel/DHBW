
package p2b5a1;

/**
 *
 * @author swe
 */
public class P2B5A1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        BaseCollection a = new BaseCollection();
        
        a.addAtBegin("Hallo");
        a.addAtEnd("Peter");
        String t = a.getAt(0).toString();
        System.out.println(t);
        System.out.println(a.remove("Hallo"));
             System.out.println(a.remove("Hatllo"));
       
        
 
    }
    
}

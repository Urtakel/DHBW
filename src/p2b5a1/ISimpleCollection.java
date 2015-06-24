
package p2b5a1;

/**
 *
 * @author swe
 */
public interface ISimpleCollection
{
    
    public boolean add(Object a, int pos);
    public boolean addAtEnd(Object a);
    public boolean addAtBegin(Object a);
    public boolean remove(Object a);
    public boolean sort(int dir);
    public ISimpleCollection next();
    public boolean isIn(Object a);
    public Object getAt(int i);
    
}

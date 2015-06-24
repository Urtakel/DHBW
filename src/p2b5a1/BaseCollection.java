package p2b5a1;

/**
 *
 * @author swe
 */
public class BaseCollection implements ISimpleCollection
{

    private int size;
    private Node first;
    private Node last;
    private Node position;

    public BaseCollection()
    {
        size = 0;
    }

    private class Node
    {

        Object data;
        Node next;
        Node prev;

        public Node(Object a)
        {
            this.data = a;
        }

        public void setNext(Node n)
        {
            this.next = n;
        }

        public void setPrev(Node p)
        {
            this.prev = p;
        }

        public Node getNext()
        {
            return this.next;
        }

        public Node getPrev()
        {
            return this.prev;
        }

    }

    @Override
    public boolean add(Object a, int pos)
    {

        if (size == 0 || last == null || first == null)
        {
            System.out.println("Einfügeposition liegt außerhalb des Listenbereichs : 0 - " + size);
            return false;
        } else
        {
            Node tmp_prev;
            Node tmp_next;
            Node neuNode = new Node(a);
            tmp_prev = getNodeAt(pos);
            tmp_next = tmp_prev.getNext();
            neuNode.setNext(tmp_next);
            neuNode.setPrev(tmp_prev);
            tmp_prev.setNext(neuNode);
            tmp_next.setPrev(neuNode);

        }
        return true;
    }

    private Node getNodeAt(int i)
    {
        int pos = 0;
        Node next = first;
        if (next == null)
        {
            return null;
        }
        while (pos < i)
        {
            if (next.getNext() != null)
            {
                next = next.getNext();
                break;
            } else
            {
                return null;
            }
        }
        return next;
    }

    private int find(Object a)
    {
        Node pos_a = first;
        Node pos_b = last;
        int i_a = 0;
        int i_b = size - 1;
        while (pos_a != pos_b)
        {

            if (pos_a.data.equals(a))
            {
                return i_a;
            }
            if (pos_b.data.equals(a))
            {
                return i_b;
            }

            pos_a = pos_a.getNext();
            pos_b = pos_b.getPrev();
            i_a++;
            i_b--;

        }
        return -1;
    }

    @Override
    public boolean addAtEnd(Object a)
    {

        if (last == null)
        {
            Node neuNode = new Node(a);
            neuNode.setNext(null);
            neuNode.setPrev(null);
            first = neuNode;
            last = neuNode;
        } else
        {

            Node neuNode = new Node(a);
            last.setNext(neuNode);
            neuNode.setNext(null);
            neuNode.setPrev(last);
            last = neuNode;
        }
        size++;
        return true;

    }

    @Override
    public boolean addAtBegin(Object a)
    {
        Node tmp;
        if (first == null)
        {
            Node neuNode = new Node(a);
            neuNode.setNext(null);
            neuNode.setPrev(null);
            first = neuNode;
            last = neuNode;
        } else
        {
            tmp = first;
            Node neuNode = new Node(a);
            tmp.setPrev(neuNode);
            neuNode.setNext(tmp);
            neuNode.setPrev(null);
            first = neuNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object a)
    {
        Node tmp;
        int pos = find(a);

        if (pos > -1)
        {
            tmp = getNodeAt(pos);
            if (tmp.getPrev() != null)
            {

                tmp.getPrev().setNext(tmp.getNext());

            } else
            {
                first = tmp.getNext();
            }
            if (tmp.getNext() != null)
            {
                tmp.getNext().setPrev(tmp.getPrev());

            } else
            {
                last = tmp.getPrev();
            }
            size--;
            return true;
        } else
        {
            return false;
        }

    }

    @Override
    public boolean sort(int dir)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ISimpleCollection next()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isIn(Object a)
    {
        if (find(a) > -1)
        {
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public Object getAt(int i)
    {
        return getNodeAt(i).data;
    }

}

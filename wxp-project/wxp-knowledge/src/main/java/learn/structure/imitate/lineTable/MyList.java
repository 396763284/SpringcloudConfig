package learn.structure.imitate.lineTable;

public interface MyList {

    int size();

    void add(int index, Object e);

    void add(Object e);

    Object get(int index);

    boolean isEmpty();

    void remove(int index);

    void remove(Object e);

    void replice(int index, Object e);

    String toString();

}

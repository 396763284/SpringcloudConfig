package DesignPatterns.Composite;

public class TextFile extends AbstractFile{
    private String name;

    public  TextFile(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {

    }

    @Override
    public void remove(AbstractFile file) {

    }

    @Override
    public AbstractFile getChild(int i) {
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("text="+name);
    }
}

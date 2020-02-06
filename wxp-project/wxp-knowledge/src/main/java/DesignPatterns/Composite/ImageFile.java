package DesignPatterns.Composite;

public class ImageFile extends AbstractFile {
    private String name;

    public  ImageFile(String name) {
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
        System.out.println("img="+name);
    }
}

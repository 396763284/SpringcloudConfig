package DesignPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends AbstractFile {
    private List<AbstractFile> list= new ArrayList<AbstractFile>();


    private String name;

    public  Folder(String name) {
        this.name = name;
    }

    @Override
    public void add(AbstractFile file) {
            list.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        list.remove(file);
    }

    @Override
    public AbstractFile getChild(int i) {
        return list.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("****对文件夹'" + name + "'进行杀毒"); //模拟
        for (AbstractFile file: list) {
            file.killVirus();
        }
    }
}

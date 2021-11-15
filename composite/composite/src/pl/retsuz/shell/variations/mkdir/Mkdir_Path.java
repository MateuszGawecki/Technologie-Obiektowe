package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_Path extends CommandVariation {
    public Mkdir_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {
        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        int idx = params.lastIndexOf("/");
        String nameOfNewElement = params.substring(idx+1);
        String Path = params.substring(0, idx);

        try {
            IComposite elem = c.findElementByPath(Path);
            Composite newElement = new Composite();
            newElement.setName(nameOfNewElement);
            ((Composite) elem).addElement(newElement);
        }catch(Exception e){
            System.out.println("Docelowy element nie jest katalogiem.");
        }
    }
}

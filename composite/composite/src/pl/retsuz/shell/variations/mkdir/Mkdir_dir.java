package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_dir extends CommandVariation {
    public Mkdir_dir(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\_]*");
    }

    @Override
    public void make(String params) {
        Composite c= (Composite) (this.getParent().getContext().getCurrent());

        try {
            Composite newElement = new Composite();
            newElement.setName(params);
            c.addElement(newElement);
        }catch(Exception e){
            System.out.println("Coś nie tak/Dir.");
        }
    }
}

package pl.retsuz.shell.variations.rm;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Rm_dir extends CommandVariation {
    public Rm_dir(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\_]*");
    }

    @Override
    public void make(String params) {
        Composite c= (Composite) (this.getParent().getContext().getCurrent());

        try {
            Composite elementToRemove = new Composite();
            elementToRemove.setName(params);
            c.removeElement(elementToRemove);
        }catch(Exception e){
            System.out.println("Nie udało się usunąc.");
        }
    }
}

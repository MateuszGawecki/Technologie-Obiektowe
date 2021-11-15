package pl.retsuz.shell.variations.rm;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Rm_Path extends CommandVariation {
    public Rm_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {
        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        int idx = params.lastIndexOf("/");
        String Path = params.substring(0,idx);
        String nameOfElementToRemove = params.substring(idx+1);

        try {
            IComposite elem = c.findElementByPath(Path);
            Composite elementToRemove = new Composite();
            elementToRemove.setName(nameOfElementToRemove);
            ((Composite) elem).removeElement(elementToRemove);
        }catch(Exception e){
            System.out.println("Docelowy element nie jest katalogiem.");
        }
    }
}

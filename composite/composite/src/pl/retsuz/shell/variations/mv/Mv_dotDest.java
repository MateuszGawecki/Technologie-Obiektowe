package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_dotDest extends CommandVariation {
    public Mv_dotDest(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*\\s\\.");
    }

    @Override
    public void make(String params) {

        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        String[] par = params.split(" ");
        String src = par[0];
        String nameOfElementToMove = src.substring(src.lastIndexOf("/")+1);

        try {
            IComposite source = c.findElementByPath(src).getParent();
            IComposite destination = c;
            Composite elementToMove = new Composite();
            elementToMove.setName(nameOfElementToMove);

            Composite.moveElement(source,destination,elementToMove);

        }catch(Exception e){
            System.out.println("Nieudalo sie przeniesc.");
        }

    }
}

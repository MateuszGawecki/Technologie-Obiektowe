package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mv_Path extends CommandVariation {
    public Mv_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*\\s[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {

        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        int idx = params.lastIndexOf(" ");
        String srcWithElement = params.substring(0,idx);
        int idx1 = srcWithElement.lastIndexOf("/");
        String src = srcWithElement.substring(0, idx);
        String nameOfElementToMove = srcWithElement.substring(idx1+1);
        String dest = params.substring(idx+1);

        try {
            IComposite source = c.findElementByPath(src).getParent();
            IComposite destination = c.findElementByPath(dest);
            Composite elementToMove = new Composite();
            elementToMove.setName(nameOfElementToMove);

            Composite.moveElement(source,destination,elementToMove);

        }catch(Exception e){
            System.out.println("Docelowy element nie jest katalogiem lub obecny katalog nie zawiera elementu.");
        }

    }
}

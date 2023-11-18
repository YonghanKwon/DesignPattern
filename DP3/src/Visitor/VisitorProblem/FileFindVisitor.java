package Visitor.VisitorProblem;
import java.util.Iterator;

public class FileFindVisitor extends Visitor {
	private String extensions;
	private String currentdir="";
	public FileFindVisitor(String extensions) {
		this.extensions=extensions;
	}
	public void visit(File file) {
		if(file.getName().contains(".")) {
			String[] split_file=(file.getName()).split("\\.");
			if(split_file[1].equals(extensions)) {
				System.out.println(split_file[0]);
			}
		}
	}
	public void visit(Directory directory) {
		String savedir = currentdir;
		currentdir=currentdir+"/"+directory.getName();
		Iterator it = directory.iterator();
		while(it.hasNext()) {
			Entry entry = (Entry)it.next();
			entry.accept(this);
		}
		currentdir=savedir;
	}
}
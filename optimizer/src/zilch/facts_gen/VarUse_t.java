package facts_gen;
import java.io.*;

public class VarUse_t extends Var_t {
	
	public int ic;

	public VarUse_t(String meth_name, int ic, String temp) {
		super(meth_name, temp);
		this.ic = ic;
	}

	public void writerec(PrintWriter writer, boolean print) {
		String ret = "varUse(" + this.meth_name + ", " + this.ic + ", " + this.temp + ").";
		if (print) System.out.println(ret);
		writer.println(ret);
	}

}

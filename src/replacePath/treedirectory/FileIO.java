package replacePath.treedirectory;

import java.io.File;
import java.util.List;

public final class FileIO {

	protected File input;
	protected File output;
	protected List<String> stringsForReplace;

	public FileIO(File input, File output, List<String> stringsForReplace) {
		this.input = input;
		this.output = output;
		this.stringsForReplace = stringsForReplace;
	}


	
}

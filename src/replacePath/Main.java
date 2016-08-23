package replacePath;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import replacePath.treedirectory.DirectoryIterator;
import replacePath.treedirectory.FileIO;
import replacePath.treedirectory.ScannerDirectory;

public class Main {

	public static void main(String[] args) throws IOException {

		String caminho = "D:\\Ultimate Collection\\info\\umdominioqualquer.com\\";
		File raizDiretorio = new File(caminho);
		String pathOutput = "D:\\Ultimate Collection\\info\\copia\\";
		File output = new File(pathOutput);

		List<String> stringsForReplace = new ArrayList<String>();
		stringsForReplace.add("http://umdominioqualquer.com");
		stringsForReplace.add("");

		FileIO fileIO = new FileIO(raizDiretorio, output, stringsForReplace);

		DirectoryIterator scannerDirectory = new ScannerDirectory();
		scannerDirectory.setPathInputOutput(fileIO);
		scannerDirectory.startScanner();
	}

}

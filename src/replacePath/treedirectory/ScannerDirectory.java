package replacePath.treedirectory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ScannerDirectory implements DirectoryIterator {

	private File root;
	private File output;
	private File[] rootFiles;
	private List<String> stringsForReplace;
	private ScannerFileDirectory fileDirectory;

	public ScannerDirectory() {

	}

	@Override
	public void setPathInputOutput(FileIO fileIO) {
		this.root = fileIO.input;
		this.output = createPathOutput(fileIO.output);

		this.output.mkdir();

		this.stringsForReplace = fileIO.stringsForReplace;
	}

	@Override
	public void startScanner() {
		this.rootFiles = root.listFiles();
		enterDirectory(rootFiles);
	}

	private void enterDirectory(File[] rootFiles) {
		for (File file : rootFiles) {
			if (file.isDirectory()) {
				mkdir(file);
				enterDirectory(file.listFiles());
			} else if (file.isFile()) {
				copyFile(file);
			}
		}
	}

	private void mkdir(File file) {
		file = createPathOutput(file);
		System.out.println("Criando diretorio " + file.getPath());
		file.mkdir();
	}

	private void copyFile(File file) {

		if (stringsForReplace.isEmpty() || inListExclusion(file)) {

			try {
				Files.copy(file.toPath(), createPathOutput(file).toPath());
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			fileDirectory = new ScannerFileDirectory(file, createPathOutput(file), stringsForReplace);
			fileDirectory.replaceStringContent();
			fileDirectory.copyFile();

		}

	}

	private boolean inListExclusion(File file) {
		if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".gif"))
			return true;
		return false;
	}

	private File createPathOutput(File file) {
		String path = root.getPath().replace(root.getPath(), file.getPath() + "\\");
		return new File(path);
	}

}

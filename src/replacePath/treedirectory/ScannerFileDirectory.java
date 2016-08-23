package replacePath.treedirectory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ScannerFileDirectory {
	private File input;
	private File output;
	private List<String> stringsForReplace;
	private String fileData;

	public ScannerFileDirectory(File input, File output, List<String> stringsForReplace) {
		this.input = input;
		this.output = output;
		this.stringsForReplace = stringsForReplace;
	}

	public ScannerFileDirectory(File input, File output) {
		this.input = input;
		this.output = output;
	}


	public void copyFile() {
		try {
			
			BufferedWriter br = Files.newBufferedWriter(output.toPath());
			br.write(fileData);
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void replaceStringContent() {
		fileData = readFile();
		List<String> text = new ArrayList<String>();
		List<String> textModification = new ArrayList<String>();

		if (stringsForReplace.size() % 2 == 0) {
			for (int i = 0; i < stringsForReplace.size(); i++) {
				if (i % 2 == 0)
					text.add(stringsForReplace.get(i));
				else
					textModification.add(stringsForReplace.get(i));
			}

			for (int i = 0; i < text.size(); i++) {
				fileData = fileData.replaceAll(text.get(i), textModification.get(i));

			}

		}
	}

	@SuppressWarnings("resource")
	private String readFile() {
		String texto = "";
		System.out.println(input.getPath());
		try {
		
			BufferedReader reader = new BufferedReader(new FileReader(input));
			//TODO: verificar como obter o encode do arquivo
			//BufferedReader reader = Files.newBufferedReader(input.toPath(),StandardCharsets.UTF_8);
			String linha = reader.readLine();
			while (linha != null) {
				texto += linha;
				linha = reader.readLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return texto;
	}

}
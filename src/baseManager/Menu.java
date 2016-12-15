package baseManager;

import java.util.Scanner;

public interface Menu {
	Scanner kb = new Scanner(System.in);
	
	default void listMenu(String[] options, int bfr) {
		StringBuilder menu = new StringBuilder("");
		int buffer = bfr;
		int menuWidth = (2 * buffer + options[0].length());
		//Print Header
		for (int i = 0; i <= menuWidth; i++) {
			menu.append("-");
		}
		//print title
		menu.append("\n").append(addBlankSpace(buffer)).append(options[0]).append("\n");
		for (int i = 0; i <= menuWidth; i++) {
			menu.append("-");
		}
		menu.append("\n");
		
		for (int i = 1 ; i<options.length; i++){
			if (options[i] != "" || options[i] != null){
				menu.append(String.format("[%d] %s", i, options[i]));
				menu.append("\n");
			}
		}
		//print footer
		for (int i = 0; i <= menuWidth; i++) {
			menu.append("-");
		}
		System.out.println(menu.toString());
		
	}

	default String addBlankSpace(int numSpaces){
		StringBuilder spaces = new StringBuilder();
		for (int i = 0; i <= numSpaces; i++) {
			spaces.append(" ");
		}
		return spaces.toString();
	}
	
	default String[] createMenu(String... args){
		String[] option = new String[args.length];
		for (int i = 0; i<args.length; i++){
			option[i]= args[i];
		}
		return option;
	}

	String getSelection();
	
	void makeSelection(String choice);

	void executeSelection(String choice);
	

}

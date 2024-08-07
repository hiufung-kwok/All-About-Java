package com.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Similar to path, which is another primary entrypoint for IO package. Which is a static class
 * and return Path class mainly for result. Can think of a Static helper class to make good use 
 * of Path object
 */
public class File_test {
	public static void main(String[] args) {
		
		final String stmt = "File %s %s: %b\n";
		
		
		//Wilcard can be use!
		Path path = Paths.get("./resources/charFile.txt");
		boolean isitDir = Files.isDirectory(path);
		System.out.format(stmt, path.getFileName(),"is Dir",  isitDir);
		
		boolean fileExist = Files.exists(path);
		System.out.format(stmt, path.getFileName(), "exist or not", fileExist );
		
		//Also normal File IO can launch under Files interface
		try (BufferedReader jin = Files.newBufferedReader(path)) {
			String content = jin.readLine();
			
			while (content != null) {
				System.out.println(content);
				content = jin.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		boolean readable = Files.isReadable(path);
		System.out.format(stmt, path.getFileName(), "readable", readable );
		
		boolean writable = Files.isWritable(path);
		System.out.format(stmt, path.getFileName(), "writeable", writable );
		
		boolean exeable = Files.isExecutable(path);
		System.out.format(stmt, path.getFileName(), "executable", exeable  );
		
		
		//of course normal IO process are included, stuff like: Copy || Delete
		//Copy option can be found on java.nio.file.StandardCopyOption.*;

		//META
		boolean symbolLink = Files.isSymbolicLink(path);
		System.out.format(stmt, path.getFileName(), "symbolicLink", symbolLink );
		//Any way u get idea, can ask all sort of question start with isxxxxxx(),
		//Dun forget to check the path whether exist or not first.
		
		
		
	}
}

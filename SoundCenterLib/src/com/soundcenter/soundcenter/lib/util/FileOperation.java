package com.soundcenter.soundcenter.lib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {

	public static void saveObject(File file, Object object) throws IOException {
		file.createNewFile();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(object);
		out.close();
	}
	
	public static Object loadObject(File file) throws IOException, ClassNotFoundException {
		if (!file.exists())
			return null;
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Object object = in.readObject();
		in.close();
		return object;
	}
	
	public static String getExtension(File file) {
		return getExtension(file.getName());
	}
	
	public static String getExtension(String fileName) {
		String extension = "";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    extension = fileName.substring(i+1);
		}
		
		return extension;
	}
	
	public static List<File> listAllFiles(File directory) {
		List<File> resultList = new ArrayList<File>();
		
		// get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList) {
		    if (file.isFile()) {
		        resultList.add(file);
		    } else if (file.isDirectory()) {
		        resultList.addAll(listAllFiles(file));
		    }
		}
		return resultList;
	}
	
	public static boolean fileIsMidi(File file) {
		String name = file.getName();
		return getExtension(name).equalsIgnoreCase("mid") || getExtension(name).equalsIgnoreCase("midi");
	}
	
	public static long getDirectorySize(File directory) {
        long directorySize = 0;
        File[] fileList = directory.listFiles();
        if (fileList == null) {
        	return 0;
        }
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isDirectory()) {
                directorySize += getDirectorySize(fileList[i]);
            } else {
                directorySize += fileList[i].length();
            }
        }
        return directorySize;
	}
	
}

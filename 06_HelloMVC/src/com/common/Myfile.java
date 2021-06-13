package com.common;

import java.io.*;
import java.text.*;
import java.util.*;

import com.oreilly.servlet.multipart.*;

public class Myfile implements FileRenamePolicy{

	@Override
	public File rename(File oldName) {
		File newFile = null;
		do{
			long currentTime= System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd_hh_mmssSSS");
			int rndNum =(int) (Math.random()*10000+1);
			
//			확장자 추출
			String oriName = oldName.getName();
			String ext = "";
			int dot= oriName.lastIndexOf(".");
			if(dot!=-1) {
				ext = oriName.substring(dot);
			}

//			새 이름으로 넣어주기
			String newName = sdf.format(new Date(currentTime))+"_"+rndNum+ext;
			newFile = new File(oldName.getParent(), newName);
			
			
			
		}while(!createNewFile(newFile));
		return newFile;
	}
	
	private boolean createNewFile(File newFile) {
		try {
			newFile.createNewFile();
		} catch(IOException e) {
			return false;
		}
		
		
		return true;
	}

}

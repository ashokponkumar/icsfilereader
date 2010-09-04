/**
 * 
 */
package com.ashokponkumar.icsreader;

import java.io.File;
import java.io.FilenameFilter;


/**
 * @author ashokponkumar
 *
 */
public class ICSFilesFilter implements FilenameFilter {

	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	public boolean accept(File dir, String filename) {
		if(filename.endsWith(".ics"))
			return true;
		else
			return false;
	}

}

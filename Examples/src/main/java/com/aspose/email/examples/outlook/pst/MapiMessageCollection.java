package com.aspose.email.examples.outlook.pst;

import java.io.FilenameFilter;
import java.util.Iterator;
import java.util.regex.Pattern;

import com.aspose.email.MapiMessage;

public class MapiMessageCollection implements Iterable<MapiMessage> {
	private String path;

	public MapiMessageCollection(String path) {
		this.path = path;
	}

	public Iterator<MapiMessage> iterator() {
		return new MapiMessageEnumerator(this.path);
	}

	public class MapiMessageEnumerator implements Iterator<MapiMessage> {
		private String[] files;

		private int position = -1;

		public MapiMessageEnumerator(String path) {
			this.files = Directory.getFiles(path);
		}

		public boolean hasNext() {
			position++;
			return (position < this.files.length);
		}

		public void reset() {
			position = -1;
		}

		public MapiMessage next() {
			try {
				return MapiMessage.fromFile(files[position]);
			} catch (IndexOutOfBoundsException e) {
				throw new IllegalStateException();
			}
		}

		public void dispose() {
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}

class Directory {
	public static String[] getFiles(String path) {
		if (path == null)
			throw new RuntimeException("path");

		return getFiles(path, "*.*");
	}

	public static String[] getFiles(String path, final String searchPattern) {
		if (path == null)
			throw new RuntimeException("path");

		java.io.File dir = new java.io.File(path);

		FilenameFilter filter = new PatternFileFilter(searchPattern, true);

		String[] result = new String[0];
		String[] fileNames = dir.list(filter);
		if (fileNames != null) {
			result = new String[fileNames.length];

			for (int i = 0; i < result.length; i++) {
                result[i] = fileNames[i];
            }
		}
		return result;
	}
}

class PatternFileFilter implements FilenameFilter {
	private Pattern mPattern;

	private boolean _isFile;

	public PatternFileFilter(String pattern, boolean isFile) {
		if (pattern == "*.*") {
            mPattern = Pattern.compile("^.*$");
        } else {
            pattern = pattern.replace(".", "\\.");
            mPattern = Pattern.compile("^" + pattern.replace("*", ".*").replace("?", ".") + "$", Pattern.CASE_INSENSITIVE);
        }
		_isFile = isFile;
	}

	public boolean accept(java.io.File dir, String name) {
		String filePath = name;
		java.io.File file = new java.io.File(filePath);
		if ((_isFile && file.isFile()) || (!_isFile && file.isDirectory())) {
			if (file.isFile()) {
				if (!name.contains(".")) {
					String mask = mPattern.pattern();
					if (mask.endsWith("..*$")) {
                        mask = mask.replace("\\..*$", ".*$");
                    }
					if (mask.endsWith(".$")) {
                        mask = mask.replace("\\.$", "$");
                    }
					Pattern tmpPattern = Pattern.compile(mask);
					return tmpPattern.matcher(name).find();
				}
			}
			return mPattern.matcher(file.getName()).find();
		}
		else{
			return false;
		}
	}
}
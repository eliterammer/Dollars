package com.dollars.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * Extracts links from a http link
 */
public class ImageLinksParser {

	List<String> parseLinksFromContents(String contents) throws IOException {
		List<String> parsedLinks = new ArrayList<String>();
		int sIndex = 0, lIndex = 0;
		int index = -1;
		while ((sIndex = contents.indexOf("<img", lIndex)) != -1) {
			index = getIndexWithinLimits(contents, "src", sIndex, ">");
			sIndex = getIndexWithinLimits(contents, "'", index, ">");
			lIndex = getIndexWithinLimits(contents, "'", sIndex+1, ">");
			if (sIndex == -1 || lIndex == -1) {
				sIndex = getIndexWithinLimits(contents, "\"", index, ">");
				lIndex = getIndexWithinLimits(contents, "\"", sIndex+1, ">");
			}
			String link = extractLink(contents, sIndex+1, lIndex);
			if (link != null) {
				parsedLinks.add(link);
			}
		}
		return parsedLinks;

	}

	List<String> parseLinks(String uri) throws IOException {
		String contents = getContentsFromUri(uri).toString().toLowerCase();
		return parseLinksFromContents(contents);

	}

	private String extractLink(String contents, int sIndex, int lIndex) {
		if (sIndex == -1 || lIndex == -1) {
			return null;
		}
		return contents.substring(sIndex, lIndex);
	}

	private int getIndexWithinLimits(String contents, String toFind,
			int sIndex, String limit) {
		if (sIndex == -1) {
			return -1;
		}
		int limitIndex = contents.indexOf(limit, sIndex);
		int lIndex = contents.indexOf(toFind, sIndex);
		return (lIndex < limitIndex) ? lIndex : -1;
	}

	private StringBuilder getContentsFromUri(String uri) throws IOException {
		URL url = new URL(uri);
		StringBuilder sb = new StringBuilder();
		char buff[] = new char[4096];
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				url.openStream()))) {
			int noOfChars = -1;
			while ((noOfChars = br.read(buff)) != -1) {
				sb.append(buff, 0, noOfChars);
			}
		}
		return sb;
	}
}

package com.dollars.core;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ImageLinksParserTest {

	@Test
	public void testWithSingleQuotes() throws IOException {
		ImageLinksParser parser = new ImageLinksParser();
		List<String> links = parser
				.parseLinksFromContents("<img src = 'test.jpg'>");
		assertEquals(1, links.size());
		assertEquals("test.jpg", links.get(0));
	}

	@Test
	public void testWithDoubleQuotes() throws IOException {
		ImageLinksParser parser = new ImageLinksParser();
		List<String> links = parser
				.parseLinksFromContents("<img src = \"test.jpg\">");
		assertEquals(1, links.size());
		assertEquals("test.jpg", links.get(0));
	}

	@Test
	public void testWithMultipleImages() throws IOException {
		ImageLinksParser parser = new ImageLinksParser();
		List<String> links = parser
				.parseLinksFromContents("<img src = \"test.jpg\">"
						+ "<img src = \"test1.jpg\">");
		assertEquals(2, links.size());
		assertEquals("test.jpg", links.get(0));
		assertEquals("test1.jpg", links.get(1));
	}
}

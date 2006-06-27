package io;

import java.io.PrintStream;

import javax.swing.JTextArea;

import junit.framework.TestCase;

import com.darwinsys.io.TextAreaOutputStream;

public class TextAreaOutputStreamTest extends TestCase {
	private static final String HELLO_WORLD = "Hello World";
	
	JTextArea ta = new JTextArea();
	
	public void testOne() {
		PrintStream x = new PrintStream(new TextAreaOutputStream(ta));
		x.print("Hello");
		x.print(' ');
		x.println("World");
		assertEquals(HELLO_WORLD, ta.getText());
	}
	
	public void testSetOut() {
		PrintStream oldOut = System.out;
		System.setOut(new PrintStream(new TextAreaOutputStream(ta)));
		System.out.println(HELLO_WORLD);
		assertEquals(HELLO_WORLD, ta.getText());
		System.setOut(oldOut);
		System.out.println("If you don't see this, something is still wrong");
	}
}
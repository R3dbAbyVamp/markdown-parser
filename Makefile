MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse;
	echo: "Java file updated"
	 
MarkdownParseTest.class: MarkdownParse.java MarkdownParseTest.java 
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java;
	echo: "Tester file updated or recompiled" 
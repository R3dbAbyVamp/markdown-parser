test: MarkdownParse.java
	javac MarkdownParse.java
	echo "Java file updated"

	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
	echo "Tester file updated or recompiled" 
	 
MarkdownParseTest.class: MarkdownParse.java MarkdownParseTest.java 
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
	echo "Tester file updated or recompiled" 
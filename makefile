
default: build


build:
	javac Encryptor.java

clean:
	rm *.class

run: build
	java Encryptor

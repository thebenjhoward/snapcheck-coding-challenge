default: build


build:
	javac Encryptor.java

clean:
	rm *.class

run: build
	java Encryptor

test: build # requires pytest
	pytest -vv test_encryptor.py

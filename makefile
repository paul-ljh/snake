default:
	@echo "Compiling..."
	javac -sourcepath src src/*.java src/*/*.java -d out

run: 
	@echo "Running..."
	java -cp out src/Main 

clean:
	rm -rf out/*

JAVAC = javac
JAVA = java

# Ruta a los archivos fuente
SRC_DIR = src/main/java
PKG_DIR = com/gabriel/todolist
LIB = lib/gson-2.10.1.jar

# Archivos fuente
SRC = $(wildcard $(SRC_DIR)/$(PKG_DIR)/*.java)

# Clase principal con su nombre completo
MAIN = App

# Regla por defecto
all: compile

compile:
	javac -cp $(LIB) $(SRC)

run:
	$(JAVA) $(MAIN)

clean:
	find $(SRC_DIR) -name "*.class" -delete

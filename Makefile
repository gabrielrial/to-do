JAVAC = javac
JAVA = java

SRC_DIR = src/main/java
PKG_DIR = com/gabriel/todolist
LIB = lib/gson-2.10.1.jar
OUT = out

SRC = $(wildcard $(SRC_DIR)/$(PKG_DIR)/*.java)
MAIN = com.gabriel.todolist.App

all: compile

compile:
	mkdir -p $(OUT)
	$(JAVAC) -cp $(LIB) -d $(OUT) $(SRC)

run:
	$(JAVA) -cp "$(LIB):$(OUT)" $(MAIN)

clean:
	rm -rf $(OUT)

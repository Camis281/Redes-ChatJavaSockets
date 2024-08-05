@echo off
setlocal
set SRC_DIR=src
set BIN_DIR=bin

if not exist %BIN_DIR% (
    mkdir %BIN_DIR%
)

javac -d %BIN_DIR% %SRC_DIR%\com\example\*.java

echo Compilação concluída!
endlocal

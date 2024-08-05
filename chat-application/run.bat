@echo off
setlocal
set BIN_DIR=bin

echo Executando o servidor...
start cmd /k "java -cp %BIN_DIR% com.example.Server"

timeout /t 2 /nobreak >nul

echo Executando o cliente...
start cmd /k "java -cp %BIN_DIR% com.example.Client"

endlocal

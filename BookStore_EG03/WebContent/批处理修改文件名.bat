@echo off  
set num = 0  
For /r  . %%i in (*.html) do (  
set /a num += 1  
echo %%i  
call echo 第 %%num%% 个文件处理成功  
ren %%i *.jsp)   
echo 共%num%个文件被处理成功  
pause>nul 
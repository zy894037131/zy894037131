@echo off  
set num = 0  
For /r  . %%i in (*.html) do (  
set /a num += 1  
echo %%i  
call echo �� %%num%% ���ļ�����ɹ�  
ren %%i *.jsp)   
echo ��%num%���ļ�������ɹ�  
pause>nul 
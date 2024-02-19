call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo Cannot open runcrud.bat
goto fail

:runbrowser
start opera "http://localhost:8080/crud/v1/tasks/"

:fail
echo.
echo There were errors
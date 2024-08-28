@echo off
call Scripts\activate.bat
python ./py_src/main.py
call Scripts\deactivate.bat
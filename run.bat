@echo off
call Scripts\activate.bat
python ./src/main.py
call Scripts\deactivate.bat
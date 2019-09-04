
## FoSCI (Dynamic-Analysis Aided Approach)
- Directory: `/FoSCI`
- [Paper](https://ieeexplore.ieee.org/document/8686152)
- [Original Source Code](https://github.com/jinwuxia/RS17_project_program) 
- Tool used to collect execution logs: [Kieker](http://kieker-monitoring.net/download/)  
- To run: 
    1. Deploy/run your benchmark application
    2. Set up Kieker to monitor execution traces  
    3. Run the app's functional test suite
    4. Store the .dat logs under `/FoSCI/kieker_logs/INSERT_APP_NAME_HERE/`
    5. Install the requirements: `pip install -r requirements.txt`
    6. Run the shell script: `bash runFoSCI.sh` 


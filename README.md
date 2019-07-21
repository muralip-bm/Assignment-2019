# daviesgroup-techchallenge

Testing Environment:
--------------------
Operating System: Windows 10
Browser: Chrome
Technologies/Tools: Maven, Selenium WebDriver, TestNG

Steps to execute the scripts:
1.	Download the code from git repository - link below:
https://github.com/muraliputtaparthi/daviesgroup-techchallenge.git

2.	Import the maven project in to an IDE (Eclipse).

3.	Add ChromeDriver files in path C:\Files.
ChromeDriver can be downloaded from the path: 
https://chromedriver.storage.googleapis.com/index.html?path=2.42/

Download the file meant for operating System. (for windows - chromedriver_win32.zip) 
Please create folder ‘File’ in C: directory, Unzip the file and place in foldder c:\File. 

4.	For some reason, if the above file can’t be placed in C drive. Place them in any path and update the same in Base.java file. 
(value of System.setProperty) 

5.	To test with Account Creation and Login – Please change the value of “createAccountMailID” to a new mail ID in the configdetails.properties file in the package daviesgroup.techchallenge.config

6.	Run testng.xml as TEstNG Suite. File located in folder Technical Challenge.

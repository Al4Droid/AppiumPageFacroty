Grid Hub:
java -jar selenium-server-standalone-3.0.1.jar -role hub

WARNING: Be sure to turn off the firewalls on the machine running your hub and nodes. Otherwise you may get connection errors.

Add the Appium Client jar to Library in project can be found at https://appium.io/downloads.html

 appium -a 192.168.1.14 -p 4723 -cp 4723 -bp 2345 -U192.168.57.101:5555
appium -a 192.168.1.14 -p 4724 -cp 4724 -bp 4567 -U192.168.57.102:5555

appium --port 4723 --nodeconfig /Users/almogood/Automation/node1.json        
appium --port 4724 --nodeconfig /Users/almogood/Automation/node2.json        
Kill all nodes
killall -9 node         

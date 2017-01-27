# AdServer


Steps to setup the code:
1. unzip the contents
2. open eclipse
3. create maven web project
4. import the files
5. copy pom file - update the mavn this will download all required jar files
6. Copy web.xml files
6. configure and run the apache server

1. to test and list out all the ads use below url (mime type application/xml) in chrome or rest webservice client
http://localhost:8080/AdServer/ad/AdServer/listallad

2. to create a new Ad (mime type JSON) in chrome or rest webservice client
http://localhost:8080/AdServer/ad/AdServer/createnewad

Request:
{"partner_id": "127","duration": 3000,"ad_content": "this is my SECOND ad","createdTime":"2017-12-11"}

try to execute above command twice without changing the partner_id, it will give error saying ad is already created

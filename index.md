So I played with datashare. it was fun.. but really I need something more easily extendable. I think the system is really cool for journalists and self-hosted applications... but without an orchestration feature I am not really sure how to scale it out.  I have a vision for an open source graph of US Jurisprudence. The intent behind it is to build a tool that anyone can access via the web.  Data Share is not really what I am looking for. Rather I want to build something that enables me to maintain a web app, a database serving it, and all of the ml workflows.  So,I think i can just use gcp.. I mean i am playing with Maestro from netflix as well. But IDK it is is really what I want to use.. Also the learning curve is pretty high for me as I am not really a java developer.

Alright so I'm going to build locally with docker containers first.  As it goes yanno.  So my stack will involve just a postgesql db serving a web application.  I will start there and then see how it goes. 

So what stack do i need. 

So the back end. I already have the data parsed in bigquery. I'll drop it into a posgresql db

A flask server to answer requests and return information

a front end.... Yeah this is some other beast to play with..

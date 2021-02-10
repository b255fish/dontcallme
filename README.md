# Design and implementation of system environment for safe IoT operation

#### This is Graduation project (3 people)

  > These are our thoughts at that time.
  >> “We are no longer students. We can't just look at the one-dimensional side to get into society soon. So, before we start a project, we need to choose software based on licenses and availability, and know how to deploy and maintain. if possible, let's us do it ourselves."

#
## Result
  In the video, we made a mistake of joining the rest of the nodes as manager nodes, so I newly upload the picture that works well as a worker node. Also, the code may be incomplete because the source was written in JSP and then moved to Java code. (It is different from the video.)

[![Watch the video](https://img.youtube.com/vi/Ky5RnD2LzeE/maxresdefault.jpg)](https://youtu.be/Ky5RnD2LzeE)

![example code](rsrc/Graduation_project_(1).png)

g#

## Purposes

### 1. Security in layers

  We thought about how to design the system safely. First, we set up a rough structure as shown in the picture below, and we selected the software by considering future-oriented factors.
  ![4C](rsrc/4c.png)
    [Overview_of_Cloud_Native_Security] (<https://kubernetes.io/docs/concepts/security/overview/#the-4c-s-of-cloud-native-security>)

- Code
  - Java was chosen as the language used; Because the team member in charge of the front-end was better at Java among Python and Java.
  
- Container
  - Docker is open-source software. (Binaries: Freemium software as a service, Source code: Apache License 2.0)
    So we selected this.
  
- Cluster
  - When I was studying Docker, I used Docker Swarm because the site also had Docker Swarm. I found Kubernetes later and tried to move it to it, but the project was running out of time. So I used Docker Swarm to proceed.

- Cloud
  - If there is time left for the project, I tried to challenge it, but I couldn't get there because we ran out of time.


#
### 2. Front-end & Back-end

    1. Static page
        Crawling on extension .xml file. I used lxml library wrapped in C language for fast processing speed.
        The amount of data in en.wiktionary is very large.
        They distributed as xml file separately so I used them. 
        However, since it exceeds 10GB, I made a demo version file and tested it. 
        I knew I had to split the file in order to process quickly with multi-threading.
        However, this project has not been written that way.
        "src/enwiktionary/legacyParsing.py" is for the former and "src/enwiktionary/parsing.py" is for the latter. The latter has still not been updated.
        Files in "src/test" is main code for this.

    2. Dynamic page
        Crawling Using Selenium and ChromeDriver. For this, I used the site of the BTD6 game.
        Files in "src/etc" is main code for this.
    
#
### 3. Distribution and Maintenance
    1. Code formatter
      - autopep8, yapf, black
        There are several code formatters to make the code look pretty.
        But I choose "black" because I thought it was the best.
        I have the same opinion as the author in the link below.
        //
        Reference
          [Compare_Code_formatter] (https://www.kevinpeters.net/auto-formatters-for-python)

    2. Code checker
      - Pylint, Flake8
        I choose this because Flake8 is better at catching the error by searching several comments from the community site. 

#
### 4. Documentation
    I learned that documentation for maintenance is a very important process.
    There are several formats for documentation. 
    Among them, the format created by Google was the cleanest (*my opinion*), so I choose it.
    After that, I was able to create an orderly document by automatically making an html file in conjunction with Sphinx and ReadTheDocs. 
      //
      Reference
        [Compare_Documentation_Format] (https://stackoverflow.com/questions/3898572/what-is-the-standard-python-docstring-format)


#
#

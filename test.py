from urllib.request import urlopen
from bs4 import BeautifulSoup

import os
import csv #csv data: https://github.com/AlisonYao/HCDS-Bechdel-Test-Final-Project
import time

html = urlopen("https://bechdeltest.com/?list=all")
bsObj = BeautifulSoup(html, "html.parser")

div = bsObj.findAll('div', {"class":"movie"})

# get user input
user_input = input("Enter a movie to print: ")

for link in div:
    # find movie title 

    passFail = (link.img['src'])
    if passFail == "/static/pass.png":
        # do something
        print(user_input + 'passes the Bechdel Test\n')

    else:
       # do something
       print(user_input + 'does not pass the Bechdel Test\n')


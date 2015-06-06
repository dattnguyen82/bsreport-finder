__author__ = '212391398'

import urllib2
import re
import os
import dateutil.parser
import string
import json
from BSContentObject import BSContentObject

exclude = set(string.punctuation)

#base_url = 'http://espn.go.com/espnradio/clipArchive?showID=bsreport'
base_url = 'http://sports.espn.go.com/espnradio/podcast/archive?id=12515776'

content_objs = []
download_urls = []

elemBegTag = '<b>B.S. Report'
elemBegTagAlt = '<b>The B.S. Report'
elemEndTag = '<br><br>'

audBegTag = '="'
audEndTag = '.mp3'

dateBegTag = '555555;">'
dateEndTag = '</i><br/>'

infoBegTag = '</i><br/>'
infoEndTag = ''

page = ""
for i in range(1, 53):
    page = '&page=' + str(i)
    if i == 1:
        page = ""

    url = base_url + page

    req = urllib2.Request(url)
    response = urllib2.urlopen(req)
    pageData = response.read()

    print url

    startIndices = [(m.start(0)) for m in re.finditer(elemBegTag, pageData)]

    #endIndices = [(m.start(0)) for m in re.finditer(elemEndTag, pageData)]

    if len(startIndices) <= 0:
          startIndices = [(m.start(0)) for m in re.finditer(elemBegTagAlt, pageData)]
    #print pageData
    #print startIndices

    for j in range(0, len(startIndices)):

        endIndex = pageData.find(elemEndTag, startIndices[j])
        elem = pageData[startIndices[j]:endIndex] + os.linesep
        #print elem

        audEndIdx = [(m.start(0)) for m in re.finditer(audEndTag, elem)]

        if len(audEndIdx) <= 0:
            print "Page: " + page + " ERROR: " + elem + "indices: " + str(startIndices[j]) + ", " + str(endIndex) + os.linesep
            continue

        audEndIdx = audEndIdx[0]

        audBegIdx = elem.rfind(audBegTag, 0, audEndIdx)
        link = elem[audBegIdx+len(audBegTag):audEndIdx+len(audEndTag)]

        dateEndIdx = [(m.start(0)) for m in re.finditer(dateEndTag, elem)]
        dateEndIdx = dateEndIdx[0]
        dateBegIdx = elem.rfind(dateBegTag, 0, dateEndIdx)
        dateString = elem[dateBegIdx+len(dateBegTag):dateEndIdx]

        date = dateutil.parser.parse(dateString).date()

        infoBegIdx = elem.rfind(infoBegTag, 0, endIndex)
        info = elem[infoBegIdx+len(infoBegTag):endIndex]
        info = info.strip('\r\n')
        info = ''.join(ch for ch in info if ch not in exclude)

        words = re.split('\s', info)

        #print words

        info = info.lower()
        bsObj = BSContentObject(link, date, info)
        bsObj.set_tokens(words)

        print bsObj.to_json()

        #bsObj.print_sql()

        # mp3File = "/Users/212391398/Downloads/bsr/bsr_"+str(date)+".mp3"
        #
        # try:
        #     dataRes = urllib2.urlopen(link)
        #     with open(mp3File, "wb") as audFile:
        #         audFile.write(dataRes.read())
        # except:
        #     print link + " - returned no data"


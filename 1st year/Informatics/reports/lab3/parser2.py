import json
import xmljson
import time

from lxml.etree import fromstring

start_time = time.time()
filename_for_parsing = "my-schedule.xml"
filename_for_result = "my-new-schedule_2.json"
file_read = open(filename_for_parsing, "r", encoding='utf-8')
file_write = open(filename_for_result, "w", encoding='utf-8')

line = ""
array = file_read.read().split('\n')
for i in range(1, len(array)):
    line = line + array[i]

xml = fromstring(line)
json_text = json.dumps(xmljson.badgerfish.data(xml), ensure_ascii=False).encode('utf8')
file_write.write(json_text.decode())
print("--- %s seconds ---" % (time.time() - start_time))

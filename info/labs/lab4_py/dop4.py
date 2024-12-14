import time

from json2xml_parser_lab4 import parse_json, all2xml
from json2xml_parser_lab4_re import parse_json as parse_json_r
from json2xml_parser_lab4_re import all2xml as all2xml_r
from json2xml import json2xml
from json2xml.utils import readfromjson

with open("main.json", "r", encoding="utf-8") as f:
    data = f.read()

json_data = readfromjson('main.json')


start_time = time.perf_counter()
for i in range(100):
    all2xml(parse_json(data))
end_time = time.perf_counter()

print(f"Основа - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    json2xml.Json2xml(json_data, item_wrap=False, attr_type=False).to_xml()
end_time = time.perf_counter()

print(f"Доп 1  - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    all2xml_r(parse_json_r(data))
end_time = time.perf_counter()

print(f"Доп 2  - {end_time - start_time}")

start_time = time.perf_counter()
for i in range(100):
    all2xml(parse_json(data))
end_time = time.perf_counter()

print(f"Доп 3  - {end_time - start_time}")
from json2xml_parser_lab4_re import parse_json, all2xml

with open("main.json", "r", encoding="utf-8") as f:
	data = f.read()
with open("schedule_re.xml", "w", encoding="utf-8") as f:
	header = '<?xml version="1.0" encoding="UTF-8" ?>'
	print(header + all2xml(parse_json(data)),file=f)
